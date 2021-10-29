package main.NeuralNets;

public class LinearRegression {
	static double[] x, y;
	public LinearRegression(double[] x_in, double[] y_in) {
		x = x_in;
		y = y_in; 
	}
	
	public String LR() {
		double slope_initial = 1;
		double y_inter_initial = 0; 
		double places = 1; 
		double tmp_sum = 0; 
		
		while (places >= 0.0001) {
			double sum_distance = 0; 

		
			for (int i=0; i<x.length; i++) {
				double compare_point = y[i] - find_point(slope_initial, y_inter_initial, x[i]); 
				
				sum_distance += (preserve_sign(compare_point))*Math.pow(compare_point, 2); 
			}
			
			
			if ((tmp_sum != 0) && (preserve_sign(sum_distance) != preserve_sign(tmp_sum))) {
					places = places/10; 
					
				}
			
			if (sum_distance == 0) {
				return ("y=" + String.valueOf(slope_initial)+ "x"); 
			} else if (sum_distance > 0) {
				slope_initial += places; 
			} else {
				slope_initial -= places;
			}
			

			tmp_sum = sum_distance; 
		}
		
		

		String format = String.format("y=%f.4x+0", slope_initial); 
		return format; 
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
