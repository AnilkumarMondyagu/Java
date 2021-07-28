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
        // Initialize numPoints to 0
        int numberOfPoints=0;
        //Iterate through the points
        for(Point currPt:s.getPoints()){
            //Increment numPoints for every point
            numberOfPoints++;
        }
        return numberOfPoints;
    }

    public double getAverageLength(Shape s) {
        double perimeter=getPerimeter(s);
        double numberOfSides=getNumPoints(s);
        double averageLength=perimeter/numberOfSides;

        return averageLength;
    }

    public double getLargestSide(Shape s) {
        Point previousPoint = s.getLastPoint();
        double largestSide = 0.0;

        for(Point currentPoint : s.getPoints()){
            double currentSide = previousPoint.distance(currentPoint);
            if(currentSide > largestSide) {
                largestSide = currentSide;
            }
            previousPoint = currentPoint;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        Point lastPoint=s.getLastPoint();
        int largestX=lastPoint.getX();
        for(Point currentPoint:s.getPoints()){
            int currentX=currentPoint.getX();
            if(currentX>largestX){
                largestX=currentX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;

        for(File f : dr.selectedFiles()){
            FileResource currentFile = new FileResource(f);
            Shape s = new Shape(currentFile);
            double perimeter = getPerimeter(s);
            if(perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File fileWithLargetsPerimeter=null;

        for(File f : dr.selectedFiles()){
            FileResource currentFile = new FileResource(f);
            Shape s = new Shape(currentFile);
            double perimeter = getPerimeter(s);
            if(perimeter > largestPerimeter) {
                largestPerimeter = perimeter;
                fileWithLargetsPerimeter=f;
            }
        }
        return fileWithLargetsPerimeter.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints=getNumPoints(s);
        System.out.println("Number of points = " + numPoints);
        double averageLength=getAverageLength(s);
        System.out.println("Average Length = " + averageLength);
        double largestSide=getLargestSide(s);
        System.out.println("Largest Side = " + largestSide);
        double largestX=getLargestX(s);
        System.out.println("Largest X coordinate = " + largestX);

    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter = " + largestPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        String fileWithLargestPerimeter = getFileWithLargestPerimeter();
        System.out.println("File with largest Perimeter is " + fileWithLargestPerimeter);
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
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
