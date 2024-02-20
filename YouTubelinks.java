package findingWebLinks;

import edu.duke.*;

import java.util.ArrayList;

//import edu.duke.URLResource;


public class YouTubelinks {
	
	public ArrayList<String> findURLs(String URL){
		
		ArrayList<String> urlArray = new ArrayList<String>();
		
		System.out.println("Get urls from: " + URL + "\n");
		
		URLResource urls = new URLResource(URL);
		
		for(String currUrl : urls.words()){
			
			
			//transfer lower case letters to upper case letters
			String UpCaseURL = toUpCase(currUrl);
			
			if(UpCaseURL.contains("YOUTUBE.COM")){
				
				int pos = UpCaseURL.indexOf("YOUTUBE>COM");
				
				int start = currUrl.lastIndexOf("href=\"", pos);
				int stop = currUrl.indexOf("\">", pos);
				
				//get the substring between start and stop indices;
				String pureURL = currUrl.substring(start + 6, stop);
				
				System.out.println("URL: " + currUrl);
				System.out.println("URL: " + pureURL +"\n");
				
				urlArray.add(pureURL);
			}
			
		}
		
		return urlArray;
		
		
	}//end findURLs() method;
	
	
	
	//transfer lower case letters into upper case letters;
	private String toUpCase(String str) {
		// TODO Auto-generated method stub
		
		int len = str.length();
		String retStr = "";
		for(int i=0; i<len; i++){
			
			char curChar = str.charAt(i);
			
			if(Character.isLowerCase(curChar)){
				curChar = Character.toUpperCase(curChar);
			}
			
			retStr += curChar;
			
		}//end for loop;
		
		return retStr;
		
	}//end toUpCase() method;


	
	public static void main(String[] args) {
		//create a new FindWebLinks object FWL
		YouTubelinks FWL = new YouTubelinks();
		
		//get the webpage; 
		String URL = "https://www.dukelearntoprogram.com//course2/data/manylinks.html" ;
		
		//call FWL.findURLS() method to get all the urls contain "youtube.com", save them to an arrayList;
		ArrayList<String> urlAL = FWL.findURLs(URL);
		
		//printout the size of url-arraylist; 
		System.out.println("There are " + urlAL.size() + " youtube links in the webpage." + "\n");
		
		// find the second YouTube link on the web page
		System.out.println("The second YouTube link : " + urlAL.get(1));

	}

}
