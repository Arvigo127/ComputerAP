package main;

import main.LinearRegression; 

public class LinearMain {
	public static void main(String[] args) {
		double[] x = {1, 2, 3};
		double[] y = {1, 4, 3};
		
		LinearRegression rg = new LinearRegression(x, y); 
	}
}
