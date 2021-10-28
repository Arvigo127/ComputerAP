package main;

import java.util.Arrays;

public class NeuralNet {
	double[][] hiddenLayerOne; 
	double[][] hiddenLayerTwo;
	double[][] outputLayer;
	double[] inputLayer;
	
	public NeuralNet(int nInputLayer, int nHiddenLayerOne, int nHiddenLayerTwo, int nOutputLayer) {
		//generates each layer as a double matrix, each row is a neuron and each column is the amount of weights, plus a bias and an output
		hiddenLayerOne = new double[nHiddenLayerOne][nInputLayer+2];
		hiddenLayerTwo = new double[nHiddenLayerTwo][nHiddenLayerOne+2];
		outputLayer = new double[nOutputLayer][nHiddenLayerTwo+2];
		inputLayer = new double[nInputLayer];
		
		//adds random numbers for weights and biases to start
		for(int i = 0; i<nHiddenLayerOne; i++) {
			for(int j = 0; j < hiddenLayerOne[0].length-1; j++) {
				hiddenLayerOne[i][j] = Math.random();
			}
		}
		
		for(int i = 0; i<nHiddenLayerTwo; i++) {
			for(int j = 0; j < hiddenLayerTwo[0].length-1; j++) {
				hiddenLayerTwo[i][j] = Math.random();
			}
		}
		
		for(int i = 0; i<nOutputLayer; i++) {
			for(int j = 0; j < outputLayer[0].length-1; j++) {
				outputLayer[i][j] = Math.random();
			}
		}
		
		
	} 
	
	public double activation(double input) {
		return (1/1+Math.exp(input*-1));
		
	}
	
	public double[] feedForward(double[] inputArray) {
		double[] input = inputArray; 
		double[] firstLayerActivations = new double[hiddenLayerOne.length]; int fLA_counter = 0; 
		
		for(int neuron = 0; neuron<hiddenLayerOne.length; neuron++) {
			double sum = hiddenLayerOne[neuron][hiddenLayerOne[0].length-2];
			for(int weight = 0; weight < hiddenLayerOne[0].length-2; weight++) {
				sum += hiddenLayerOne[neuron][weight]*input[weight]; 
			}
			
			firstLayerActivations[fLA_counter++] = activation(sum); 
			
			
		}
		
		double[] secondLayerActivations = new double[hiddenLayerTwo.length]; int sLA_counter = 0; 
		
		for(int neuron = 0; neuron<hiddenLayerTwo.length; neuron++) {
			double sum = hiddenLayerTwo[neuron][hiddenLayerTwo[0].length-2];
			for(int weight = 0; weight < hiddenLayerTwo[0].length-2; weight++) {
				sum += hiddenLayerTwo[neuron][weight]*firstLayerActivations[weight]; 
			}
			
			secondLayerActivations[sLA_counter++] = activation(sum); 
			
			
		}
		
		double[] outputLayerActivations = new double[outputLayer.length]; int oLA_counter = 0; 
		
		for(int neuron = 0; neuron<outputLayer.length; neuron++) {
			double sum = outputLayer[neuron][outputLayer[0].length-2];
			for(int weight = 0; weight < outputLayer[0].length-2; weight++) {
				sum += outputLayer[neuron][weight]*secondLayerActivations[weight]; 
			}
			
			outputLayerActivations[oLA_counter++] = activation(sum); 
			
			
		}
		
		return outputLayerActivations;
		
	}
	
	public void print() {
		for(int i = 0; i<hiddenLayerOne.length; i++) {
			System.out.print(Arrays.toString(hiddenLayerOne[i]));
		}
		
		System.out.println(); 
		
		for(int i = 0; i<hiddenLayerTwo.length; i++) {
			System.out.print(Arrays.toString(hiddenLayerTwo[i]));
		}
		
		System.out.println();
		
		for(int i = 0; i<outputLayer.length; i++) {
			System.out.print(Arrays.toString(outputLayer[i]));
		}
		
		System.out.println(); 
	}
	
	public double testError(double[] x) {
		
		//returns average error between predicted and test values
		if(x.length != inputLayer.length+outputLayer.length) {
			System.out.println("Size of input array out of bounds!");
			return 0; 
		}
		double[] inputData = Arrays.copyOfRange(x, 0, inputLayer.length-1);
		
		double[] result = feedForward(inputData);
		
		double[] dataResults = Arrays.copyOfRange(x, inputLayer.length, x.length-1);
		
		double error = 0; 
		
		for(int i = 0; i>result.length; i++) {
			error += result[i]/dataResults[i];
		}
		
		return error/result.length;
		
		
	}
	
	public static void main(String[] args) {
		NeuralNet nn = new NeuralNet(2, 4, 4, 1); 
		
		nn.print();
		
		double[] inputs = {0,1};
		double[] result = nn.feedForward(inputs);
		
		System.out.println(Arrays.toString(result));
	}

}
