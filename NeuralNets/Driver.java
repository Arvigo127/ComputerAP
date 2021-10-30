package main.NeuralNets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		System.out.println("Starting...");
		ImageLoader il = new ImageLoader(62500,2);
		
		System.out.println("Populating data...");
		il.populateData();
		
		NeuralNetwork nn = new NeuralNetwork();
		
		System.out.println("Scanning for pre-existing Neural Network...");
		try {
			FileInputStream fi = new FileInputStream(new File("src\\main\\NeuralNets\\data\\nn.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			nn = (NeuralNetwork) oi.readObject();
			
			System.out.println("Found!");
			
			oi.close();
			fi.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Network Found, Initializing Neural Network...");
			nn = new NeuralNetwork(62500,30,30,2, 0.005);
			System.out.println("Fitting Neural Network to Data...");
			nn.fit(il.getX(), il.getY(), 5000);
			System.out.println("Done! Saving Neural Network");
			
			try {
				FileOutputStream f = new FileOutputStream(new File("src\\main\\NeuralNets\\data\\nn.txt"));
				ObjectOutputStream o = new ObjectOutputStream(f);
	
				// Write objects to file
				o.writeObject(nn);
	
				o.close();
				f.close();
			} catch (IOException f) {
				System.out.println("Error saving Neural Network");
			}
			
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		double [][] input = il.getX();

		//System.out.println(String.format("Prediction on input %s", Arrays.toString(input[i])));
		
		System.out.println("Predicting index: 1");
		List<Double> output = nn.predict(input[1]).toArray();
		System.out.println(parseInput(output));
		System.out.println(output);
		
		System.out.println("Predicting index: 45");
		output = nn.predict(input[45]).toArray();
		System.out.println(parseInput(output));
		System.out.println(output);
		
		

	}
	
	public static String parseInput(List<Double> f) {
		String result = "";
		
		if(f.get(0)>f.get(1)) {
			result = "Dog";
		} else {
			result = "Cat";
		}
		
		return result;
	}

}