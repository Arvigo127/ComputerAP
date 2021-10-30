package main.NeuralNets;

import java.io.Serializable;


public class NeuralNetwork implements Serializable{
	

	private static final long serialVersionUID = 1L;
	Matrix weights_ih1, weights_h1h2, weights_h2o , bias_h1, bias_h2, bias_o;	
	double l_rate;
	
	public NeuralNetwork() {
		
	}
	
	public NeuralNetwork(int i,int h1, int h2, int o, double learning_rate) {
		weights_ih1 = new Matrix(h1,i);
		weights_h1h2 = new Matrix(h2, h1);
		weights_h2o = new Matrix(o,h2);
		
		l_rate = learning_rate;
		
		bias_h1= new Matrix(h1,1);
		bias_h2= new Matrix(h2, 1); 
		bias_o= new Matrix(o,1);
		
	}
	
	public Matrix predict(double[] X)
	{
		Matrix input = Matrix.fromArray(X);
		Matrix hidden1 = Matrix.multiply(weights_ih1, input);
		hidden1.add(bias_h1);
		hidden1.sigmoid();
		
		Matrix hidden2 = Matrix.multiply(weights_h1h2, hidden1);
		hidden2.add(bias_h2);
		hidden2.sigmoid();
		
		Matrix output = Matrix.multiply(weights_h2o,hidden2);
		output.add(bias_o);
		output.sigmoid();
		
		return output;
	}
	
	
	public void fit(double[][]X,double[][]Y,int epochs)
	{
		for(int i=0;i<epochs;i++)
		{	
			if(i%500==0) {
				System.out.println("   Iteration: " + i);
			}
			int sampleN =  (int)(Math.random() * X.length );
			this.train(X[sampleN], Y[sampleN]);
		}
	}
	
	public void train(double [] X,double [] Y)
	{
		Matrix input = Matrix.fromArray(X);
		Matrix hidden1 = Matrix.multiply(weights_ih1, input);
		hidden1.add(bias_h1);
		hidden1.sigmoid();
		
		Matrix hidden2 = Matrix.multiply(weights_h1h2, hidden1);
		hidden2.add(bias_h2);
		hidden2.sigmoid();
		
		Matrix output = Matrix.multiply(weights_h2o,hidden2);
		output.add(bias_o);
		output.sigmoid();
		
		Matrix target = Matrix.fromArray(Y);
		
		//error matrix has n rows, 1 column
		Matrix error = Matrix.subtract(target, output);
		//dc/da * da/dx terms of dc/dw partial derivative, left separate because this is full partial derivative for dc/db
		Matrix gradient = output.dsigmoid();
		//this is dc/da, should technically be negative but is accounted for by adding later instead of subtracting
		gradient.multiply(error);
		//scalar multiply learning rate
		gradient.multiply(l_rate);
		
		//transpose to get gradient matrix that can be applied to weights
		Matrix hidden2_T = Matrix.transpose(hidden2);
		Matrix wh2o_delta =  Matrix.multiply(gradient, hidden2_T);
		
		//applies proper gradients
		weights_h2o.add(wh2o_delta);
		bias_o.add(gradient);
		
		Matrix wh2o_T = Matrix.transpose(weights_h2o);
		Matrix hidden2_errors = Matrix.multiply(wh2o_T, error); 
		
		Matrix h1h2_gradient = hidden2.dsigmoid(); 
		h1h2_gradient.multiply(hidden2_errors); 
		h1h2_gradient.multiply(l_rate); 
		
		Matrix h1_T = Matrix.transpose(hidden1);
		Matrix wh1h2_delta = Matrix.multiply(h1h2_gradient, h1_T);
		
		weights_h1h2.add(wh1h2_delta);
		bias_h2.add(h1h2_gradient);
		
		Matrix wh1h2_T = Matrix.transpose(weights_h1h2);
		Matrix hidden1_errors = Matrix.multiply(wh1h2_T, hidden2_errors);
		
		Matrix h1_gradient = hidden1.dsigmoid();
		h1_gradient.multiply(hidden1_errors);
		h1_gradient.multiply(l_rate);
		
		Matrix i_T = Matrix.transpose(input);
		Matrix wih1_delta = Matrix.multiply(h1_gradient, i_T);
		
		weights_ih1.add(wih1_delta);
		bias_h1.add(h1_gradient);
		
	}


}