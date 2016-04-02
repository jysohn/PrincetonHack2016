import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Picture;
import java.awt.Color;
import edu.princeton.cs.algs4.StdDraw;

public class StarFinder {

    private int M;      //width of picture
    private int N;      //height of picture
    private boolean[][] bright;      //contains whether pixel is light or dark
    private boolean[][] checked;     //contains whether pixel was checked
    private Queue<Blob> collection; //collection of all contiguous blobs found
    
    public StarFinder(Picture picture, double tau) {
        M = picture.width();
        N = picture.height();
        bright = new boolean[M][N];
        collection = new Queue<Blob>();
        
        //convert image into bright (true) and darks (false) with an array
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (lum(picture.get(i, j)) >= tau) bright[i][j] = true; 
            }         
        }   
        
        findBlobs();
    }
    
    public static double lum(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        return .299*r + .587*g + .114*b;
    }
    
    //Recursively add adjacent bright pixels to a blob
    private void dfs(int i, int j, Blob blob) {
        if (((i < 0) || (i > M-1)) || ((j < 0) || (j > N-1))) return;
        if (checked[i][j]) return;
        if (!bright[i][j]) return;
        
        checked[i][j] = true;
        blob.add(i, j);
        
        dfs(i-1, j, blob);
        dfs(i, j-1, blob);
        dfs(i, j+1, blob);
        dfs(i+1, j, blob);   
    }
    
    //Go through creating blobs and adding them to a collection
    private void findBlobs() {
        checked = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!checked[i][j]) {
                    if (bright[i][j]) {
                        Blob blob = new Blob();
                        dfs(i, j, blob);
                        collection.enqueue(blob);
                    }
                }
            }
        }
    }
    
    //Return all blobs of size P or greater
    public Blob[] getStars(int P) {
        int size = 0;
        for (Blob blob : collection) {
            if (blob.mass() >= P) size++;
        }
        
        Blob[] list = new Blob[size];
        int i = 0;
        for (Blob blob : collection) {
            if (blob.mass() >= P) {
                list[i] = blob;
                i++;
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        int P = Integer.parseInt(args[0]);
        double TAU = Double.parseDouble(args[1]);
        Picture picture = new Picture(args[2]);
        
        StarFinder test = new StarFinder(picture, TAU);
        Blob[] stars = test.getStars(P);
 //       Blob[] blobs = test.getStars(1);
        
        StdOut.println(stars.length + " Beads:");
        StdDraw.setXscale(0.0, 1000.0);
        StdDraw.setYscale(0.0, 1000.0);
        StdDraw.filledSquare(500.0, 500.0, 500.0);
        StdDraw.setPenRadius(.01);
        StdDraw.setPenColor(Color.WHITE);
        for (Blob b : stars) {
            StdOut.println(b);
            StdDraw.point(b.x(), b.y());
        }
        
      /*  StdOut.println();
        StdOut.println(blobs.length + " Blobs:");
        for (Blob b : blobs) {
            StdOut.println(b);
            
        }  
        */
    } 
    
}