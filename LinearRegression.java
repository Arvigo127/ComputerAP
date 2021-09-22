package main;

public class LinearRegression {
	static double[] x, y;
	public LinearRegression(double[] x_in, double[] y_in) {
		x = x_in;
		y = y_in; 
	}
	
	public double LR() {
		double slope_initial = 1;
		double y_inter_initial = 0; 
		
		boolean sign_change_flag = false;
		double places = 1; 
		double end_condition = 1; 
		
		while (end_condition < 5) {
			double sum_distance = 0; 
			if (sign_change_flag) {
				places = places/10; 
				sign_change_flag = false; 
			}
		
			for (int i=0; i<x.length; i++) {
				double compare_point = y[i] - find_point(slope_initial, y_inter_initial, x[i]); 
				
				sum_distance += (preserve_sign(compare_point))*Math.pow(compare_point, 2); 
			}
			
			if (sum_distance == 0) {
				return slope_initial; 
			} else if (sum_distance > 0) {
				slope_initial += places; 
				System.out.print(sum_distance);
				System.out.print(" added "); 
				System.out.println(slope_initial); 
			} else {
				slope_initial -= places;
				System.out.print(sum_distance);
				System.out.print(" subtracted "); 
				System.out.println(slope_initial); 
			}
			
			end_condition++; 
		}
		return slope_initial; 
	}
	
	
	
	public static double find_point(double slope, double inter, double x) {
		return slope*x+inter; 
	}
	
	public static double preserve_sign(double point) {
		double sign = 1; 
		if (point != 0) {
			sign = point/Math.abs(point); 
		}
		return sign;
	}
}
