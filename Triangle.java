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
	
	public void display() {
		A.display();
		B.display();
		C.display();
	}
	
	public double area() {
		double y_diff = 0;
		double x_diff = 0; 
		
		PyList ys = new PyList(); 
		ys.add(A.getY());ys.add(B.getY());ys.add(C.getY());
		
		y_diff = ys.max() - ys.min();

		
		PyList xs = new PyList(); 
		xs.add(A.getX()); xs.add(B.getX()); xs.add(C.getX());
		
		x_diff = xs.max() - xs.min(); 
		
		return 0.5*x_diff*y_diff; 
	}
	
	public boolean isRight() {
		if(A.distance(B) > B.distance(C) && A.distance(B) > C.distance(A)) {
			return Math.pow(A.distance(B),2) == Math.pow(B.distance(C), 2) + Math.pow(C.distance(A), 2);
		} else if(B.distance(C) > A.distance(B) && B.distance(C) > A.distance(C)) {
			return Math.pow(B.distance(C),2) == Math.pow(A.distance(C), 2) + Math.pow(A.distance(B), 2);
		} 
		
		return Math.pow(C.distance(A),2) == Math.pow(B.distance(C), 2) + Math.pow(C.distance(B), 2);
	}
	
	public boolean isEquilateral() {
		return A.distance(B) == A.distance(C) && A.distance(B) == C.distance(B); 
	}
	
	public boolean isScalene() {
		return A.distance(B) != A.distance(C) && A.distance(B) != C.distance(B); 
	}
	
	public boolean isIsoceles() {
		
	}
	
	public static void main(String[] args) {
		Triangle t = new Triangle(new Point(-1,0),
								  new Point(50,0),
								  new Point(-1,5));
		

		
		System.out.println(t.Perimeter());
		t.display();
		System.out.println(t.isRight());
		System.out.println(t.area()); 
		System.out.println(t.isEquilateral());
	}
	
	
}
