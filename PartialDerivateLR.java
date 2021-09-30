package main;

public class PartialDerivateLR {
	public static void main(String[] args) {
		double[] data_x = {1,2,3};
		double[] data_y = {4.5,7,9.5}; 
		int n = data_x.length;
		double lr = 0.0089; 
		double m = 0; 
		double b = 0; 
		int iterations = 3000; 
		System.out.println("started code"); 
		
		for (int i = 1; i <= iterations; i++) {
			 
			double sum_m = 0;
			double sum_b = 0; 
			for (int q = 0; q<data_x.length; q++) {
				 
				sum_m += m_partial_deriv(data_x[q], data_y[q], (m*data_x[q]+b));
				sum_b += b_partial_deriv(data_x[q], data_y[q], (m*data_x[q]+b));
			}
			
			m -= lr*(sum_m/n); 
			b -= lr*(sum_b/n); 
			
			System.out.println(String.format("Iteration %d, slope %s and intercept %s", i, m, b));
			
		}
		
	}
	
	public static double m_partial_deriv(double x, double y_actual, double y_predicted) {
		 
		
		double sum = -2*x*(y_actual-y_predicted); 
			
		
		return sum;
	}
	
	public static double b_partial_deriv(double x, double y_actual, double y_predicted) {
		 
		
		double sum = -2*(y_actual-y_predicted); 
			
		
		return sum;
	}
	
	public static double y_point(double slope, double x, double intercept) {
		double point = slope*x+intercept;
		return point;
	}
}




