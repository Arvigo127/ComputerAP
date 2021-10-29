package main.NeuralNets;

import java.util.Arrays;
import java.util.List;

public class Driver {
	
	static double [][] X= {
			{0,0},
			{1,0},
			{0,1},
			{1,1}
	};
	static double [][] Y= {
			{1,0},{0,1},{0,1},{0,1}
	};

	public static void main(String[] args) {
		
		NeuralNetwork nn = new NeuralNetwork(2,4,4,2, 0.05);
		
		

		
		nn.fit(X, Y, 100000);
		double [][] input = {
				{0,0},{0,1},{1,0},{1,1}	
		};
		for(double d[]:input)
		{
			System.out.println(String.format("Prediction on input %s", Arrays.toString(d)));
			nn.predict(d).print();
			
		}		

	}

}