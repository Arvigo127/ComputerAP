package main;

public class LinearRegression {
	public LinearRegression(double[] x, double[] y) {
		double slope_initial = 1;
		double y_inter_initial = 0; 
		double sum_distance = 0; 
		
		for (int i=0; i<x.length; i++) {
			sum_distance += Math.pow((y[i]-find_point(slope_initial, y_inter_initial, x[i])), 2); 
		}
		
		System.out.println(sum_distance);  
	}
	
	public static double find_point(double slope, double inter, double x) {
		return slope*x+inter; 
	}
}
