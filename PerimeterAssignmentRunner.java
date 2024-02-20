import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
    	
    	int numPoints = 0;
    	for(Point currPt : s.getPoints()){
    		numPoints ++;
    	}	

        return numPoints;
    }

    public double getAverageLength(Shape s) {
    	
    	int numPoints = getNumPoints (s);
    	double perimeter = getPerimeter(s);
    	double avglen = perimeter/numPoints;
    	
        return avglen;
    }

    public double getLargestSide(Shape s) {
    	
    	double largest = 0;
    	Point prevPt = s.getLastPoint();
    	
    	for (Point currPt : s.getPoints()) {
    		
    		double currDist = prevPt.distance(currPt);
    		if (largest < currDist) {
    			largest = currDist;
    		}
    		prevPt = currPt;
    	}
        return largest;
    }

    public double getLargestX(Shape s) {
    	
    	double x = 0;
    	
    	for (Point currPt : s.getPoints()) {
    		if (x < currPt.getX()) {
    			x = currPt.getX();
    		}
    	}     
        return x;
    }

    public double getLargestPerimeterMultipleFiles() {
    	
    	DirectoryResource dr = new DirectoryResource();
    	double largestPerimeter = 0;
    	
    	for (File f : dr.selectedFiles()) {
    		 FileResource fr = new FileResource(f);
             Shape s = new Shape(fr);
             
             //
             double currPerimeter = getPerimeter(s);
        
             if (largestPerimeter < currPerimeter) {
            	 largestPerimeter = currPerimeter;
             }   		
    	}
        
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null;   
    	double largestPerimeter = 0;
    	DirectoryResource dr = new DirectoryResource();
        //File temp = null;    
        
        for (File f : dr.selectedFiles()) {
        	FileResource fr = new FileResource(f);
        	Shape s = new Shape(fr);
        	
        	double currPerimeter = getPerimeter(s);
        	
        	if (largestPerimeter < currPerimeter) {
        		largestPerimeter = currPerimeter;
        		temp = f;
        		
        	}
        	
        }

        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double avgLen = getAverageLength(s);
        double largestX = getLargestX(s);
        double largestSide = getLargestSide(s);
        
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("average length = " + avgLen);
        System.out.println("largest X = " + largestX);
        System.out.println("largest side = " + largestSide);
    }
    
    public void testPerimeterMultipleFiles() {
    	double LargPerimeter = getLargestPerimeterMultipleFiles();
    	System.out.println("largest perimeter of all files = " + LargPerimeter);
    	
    }

    public void testFileWithLargestPerimeter() {
    	String LargPerimeterFile = getFileWithLargestPerimeter();
    	System.out.println("file with the largest perimeter = " + LargPerimeterFile);

    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {

        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        //pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
