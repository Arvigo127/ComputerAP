package main;

public class PIApprox {
	public static void main(String[] args) {
		int denom = 1; 
		int operand = 1; 
		double pi_approx = 0.0; 
		
		for (int i = 0; i <= 10; i++) {
			pi_approx += 4*(operand*(1/denom));
		}
	}
}
