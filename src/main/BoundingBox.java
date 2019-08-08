package main;

public class BoundingBox { 
    private int x1, y1;   // lower left
    private int x2, y2;   // upper right
   
    public BoundingBox(int x1, int y1, int x2, int y2) {
        this.x1 = Math.min(x1, x2);
        this.x2 = Math.max(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.y2 = Math.max(y1, y2);
    }

    public BoundingBox(Point p, Point q) {
        this(p.getX(), p.getY(), q.getX(), q.getY());
    }


    // does this BoundingBox r intersect s?
    public boolean intersects(BoundingBox s) {
        BoundingBox r = this;
        return (r.x2 >= s.x1 && r.y2 >= s.y1 && s.x2 >= r.x1 && s.y2 >= r.y1);
    }


    // return the area
    public double area() {
        return (x2 - x1) * (y2 - y1);
    }

    // return the area
    public String toString() {
        return "[(" + x1 + ", " + y1 + ") (" + x2 + ", " + y2 + ")]";
    }
}