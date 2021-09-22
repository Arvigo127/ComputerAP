package main;

import main.LinearRegression; 

public class LinearMain {
	public static void main(String[] args) {
		double[] x = {1, 2, 3};
		double[] y = {4, 8, 12};
		
		LinearRegression rg = new LinearRegression(x, y); 
		
		System.out.println(rg.LR()); 
	}
}
