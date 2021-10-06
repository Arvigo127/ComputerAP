package main;

public class PIApprox {
	public static void main(String[] args) {
		double denom = 1; 
		double operand = 1; 
		double pi_approx = 0.0; 
		
		for (int i = 0; i <= 2000000000; i++) {
			pi_approx += 4*(operand*(1/denom));
			operand = operand * -1; 
			denom += 2; 
		}
		
		System.out.println(pi_approx); 
	}
}
