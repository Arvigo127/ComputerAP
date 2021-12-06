package main;

public class Point {
	private int x, y; 
	
	public Point() {
		x = 0; y = 0; 
	}
	
	public Point(int newx, int newy) {
		x = newx;
		y =  newy; 
	}
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y; 
	}
	
	public void setX(int input) {
		x = input; 
	}
	
	public void setY(int input) {
		y = input; 
	}
	
	public void display() {
		System.out.println(String.format("(%s,%s)", x, y));
	}
	
	public Point midpoint(Point a, Point b) {
		Point midpoint = new Point((a.getX()-b.getX())/2, (a.getY()-b.getY())/2); 
		return midpoint; 
	}
			
	
	public double distance(Point input) {
		int y_distance = input.getY() - y; 
		int x_distance = input.getX() - x; 
		
		return Math.sqrt(x_distance*x_distance + y_distance*y_distance); 
	}
	
	public static void main(String[] args) {
		Point point1 = new Point();
		Point point2 = new Point(0,3);
		
		System.out.println(point1.distance(point2));
	}
	
	
}
