package main;

public class Triangle {
	Point A, B, C; 
	
	public Triangle(Point p1, Point p2, Point p3) {
		A = p1; B = p2; C = p3; 
	}
	
	public double Perimeter() {
		double peri = 0; 
		peri += A.distance(B); 
		peri += B.distance(C);
		peri += C.distance(A);
		
		
		return peri; 
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(0,0);
		Point p2 = new Point(0,4);
		Point p3 = new Point(3,0);
		
		Triangle t = new Triangle(p1,p2,p3);
		
		System.out.println(t.Perimeter());
	}
	
	
}
