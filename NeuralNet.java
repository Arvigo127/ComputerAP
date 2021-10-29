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
	
	public double sigmoid_prime(double input) {
		return input*(1-input);
	}
	
	public double[] feedForward(double[] inputArray) {
		double[] input = inputArray; 
		
		for(int neuron = 0; neuron<hiddenLayerOne.length; neuron++) {
			double sum = hiddenLayerOne[neuron][hiddenLayerOne[0].length-2];
			for(int weight = 0; weight < hiddenLayerOne[0].length-2; weight++) {
				sum += hiddenLayerOne[neuron][weight]*input[weight]; 
			}
			
			hiddenLayerOne[neuron][hiddenLayerOne[0].length-1] = activation(sum); 
			
			
		}
		
		
		for(int neuron = 0; neuron<hiddenLayerTwo.length; neuron++) {
			double sum = hiddenLayerTwo[neuron][hiddenLayerTwo[0].length-2];
			for(int weight = 0; weight < hiddenLayerTwo[0].length-2; weight++) {
				sum += hiddenLayerTwo[neuron][weight]*hiddenLayerOne[weight][hiddenLayerOne[0].length-1]; 
			}
			
			hiddenLayerTwo[neuron][hiddenLayerTwo[0].length-1] = activation(sum); 
			
			
		}
		
		double[] outputLayerActivations = new double[outputLayer.length]; 
		
		for(int neuron = 0; neuron<outputLayer.length; neuron++) {
			double sum = outputLayer[neuron][outputLayer[0].length-2];
			for(int weight = 0; weight < outputLayer[0].length-2; weight++) {
				sum += outputLayer[neuron][weight]*hiddenLayerTwo[weight][hiddenLayerTwo[0].length-1]; 
			}
			
			outputLayer[neuron][outputLayer[0].length-1] = activation(sum);			
			
		}
		
		for(int i = 0; i<outputLayer.length; i++) {
			outputLayerActivations[i] = outputLayer[i][outputLayer[0].length-1];
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
		double[] inputData = Arrays.copyOfRange(x, 0, inputLayer.length);
		System.out.println(Arrays.toString(inputData));
		
		double[] result = feedForward(inputData);
		
		
		double[] dataResults = Arrays.copyOfRange(x, inputLayer.length, x.length);
		
		System.out.println(String.format("result data of %s, dataResults of %s", Arrays.toString(result), Arrays.toString(dataResults)));
		
		double error = 0; 
		
		for(int i = 0; i<result.length; i++) {
			error += result[i]/dataResults[i];
		}
		
		return error/result.length;
		
		
	}
	
	public void backpropagate(double[][] inputData, int learningRate, int iterations) {
		for(int i = 1; i<=iterations; i++) { 		
			System.out.println(String.format("Iteration %s", i));
			for(int dataRow = 0; dataRow<inputData.length; dataRow++) {
				 System.out.println(Arrays.toString(inputData[dataRow]));
				 
			}
		}
	}
	
	public static void main(String[] args) {
		NeuralNet nn = new NeuralNet(2, 4, 4, 1); 
		
		//nn.print();
		
		double[] inputs = {0,1,0};
		double[] result = nn.feedForward(inputs);
		
		nn.print();
		
		System.out.println(Arrays.toString(result));
		
		double[] testData = {0,1,1};
		
		System.out.println(nn.testError(testData));
		
		double[][] data = {{1,0,1},{0,0,0},{1,1,0},{0,1,1}};
		
		nn.backpropagate(data, 4, 5);
	}

}
