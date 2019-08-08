package main;

public class Point {
	private int x; 
    private int y;   
   
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public void setX(int a) {
    	this.x = a;
    }
    
    public void setY(int a) {
    	this.y = a;
    }
    
}
