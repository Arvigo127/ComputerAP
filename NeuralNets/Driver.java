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
		
		System.out.println("Populating data array...");
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
				System.exit(0);
			}
			
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
			System.exit(0);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		double [][] input = il.getX();

		//System.out.println(String.format("Prediction on input %s", Arrays.toString(input[i])));
		
		parsePrediction(nn, input, 0);
		parsePrediction(nn, input, 29);
		
		

	}
	
	public static void parsePrediction(NeuralNetwork ninput, double[][] data, int index) {
		System.out.println("Predicting index: " + index);
		
		long startTime = System.currentTimeMillis();
		List<Double> output = ninput.predict(data[index]).toArray();
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Predicted in %s milliseconds", endTime-startTime));
		
		if(output.get(0)>output.get(1)) {
			System.out.println(String.format("Dog (%.2f%%)", output.get(0)*100));
		} else {
			System.out.println(String.format("Cat (%.2f%%)", output.get(1)*100));
		}
		
		
	}
	
	

}