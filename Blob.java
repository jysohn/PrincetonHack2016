import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;

public class Blob {
    
    private int mass;    //number of pixels
    private double cx;   //x-coordinate of center of mass
    private double cy;   //y-coordinate of center of mass   
    
    public Blob() {
        mass = 0;
        cx = 0;
        cy = 0;     
    }
    
    //Add a pixel at (i, j) to blob.
    public void add(int i, int j) {
        cx = (cx * mass + i)/(mass + 1);
        cy = (cy * mass + j)/(mass + 1);
        mass++;       
    }
    
    //Accessor for mass
    public int mass() {
        return mass;
    }
    
    public double x() {
        return cx;
    }
    
    public double y() {
        return cy;
    }
    
    //Return distance between center of masses of two blobs
    public double distanceSquaredTo(Blob b) {        
        double value = ((cx - b.cx)*(cx - b.cx) + (cy - b.cy)*(cy - b.cy));
        return value;
    }
    
    //TAKEN FROM THE COS 126 PAGE
    public String toString() {
        return String.format("%2d (%8.4f, %8.4f)", mass, cx, cy);
    }
    
    public static void main(String[] args) {
        Blob a = new Blob ();
        Blob b = new Blob ();
        
        for (int i = 0; i < 4; i++) {
            a.add(6, 2 + i);
            b.add(i, 3); 
            StdOut.println("a: " + a);
            StdOut.println("b: " + b);
            StdOut.println("Distance: " + a.distanceSquaredTo(b));
        }
        
        
    }
}
