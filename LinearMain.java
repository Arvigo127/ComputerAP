package main;

public class LinearMain {
	public static void main(String[] args) {
		double[] x = {1, 2, 3};
		double[] y = {-5, -10, -13};
		
		LinearRegression rg = new LinearRegression(x, y); 
		
		System.out.println(rg.LR()); 
	}
}
