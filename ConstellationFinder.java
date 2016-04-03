import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Picture;
import java.util.Arrays;
import java.awt.Color;

public class ConstellationFinder {
    private final Blob[] stars;
    private final double[] starAngles;
    
    public ConstellationFinder(Blob[] stars) {
        this.stars = new Blob[stars.length];
        for (int i = 0; i < stars.length; i++) {
            this.stars[i] = stars[i];
        }
        
        starAngles = findStarAngles(stars);       
    }
    
    private double[] findStarAngles(Blob[] stars) {
        double[] angles = new double[(stars.length)*(stars.length -1)*(stars.length-2)/2];
        int counter = 0;
        for (int i = 0; i < stars.length; i++) {
            for (int j = i+1; j < stars.length; j++) {
                for (int k = j+1; k < stars.length; k++) {
                    angles[counter] = angle(stars[i], stars[j], stars[k]);
                    counter++;
                    angles[counter] = angle(stars[j], stars[i], stars[k]);
                    counter++;
                    angles[counter] = angle(stars[k], stars[j], stars[i]);
                    counter++;
                }
            }
        }
        Arrays.sort(angles);
        return angles;
    }
    
    public double[] getStarAngles() {
        return starAngles;
    }
    
    public Blob[] getStars() {
        return stars;
    }
    
    private double angle(Blob a, Blob b, Blob c) {
        double a2 = b.distanceSquaredTo(c);
        double b2 = a.distanceSquaredTo(c);
        double c2 = b.distanceSquaredTo(a);
        return Math.toDegrees(Math.acos(((a2-b2-c2)/(-2*Math.sqrt(b2*c2)))));
        
    }
    
    public String getConstellation() {
        return "";
    }
    
    public static void main(String[] args) {
        int P = Integer.parseInt(args[0]);
        double TAU = Double.parseDouble(args[1]);
        Picture picture = new Picture(args[2]);
        
        StarFinder test = new StarFinder(picture, TAU);
        ConstellationFinder tester = new ConstellationFinder(test.getStars(5));
        
        for (Blob b : tester.getStars()) {
            StdOut.println(b);
        }
        
        for (double d : tester.getStarAngles()) {
            StdOut.print(d + ", ");
        }
    }
   
}