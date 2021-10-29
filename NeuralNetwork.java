package main;

import java.util.List;

public class NeuralNetwork {
	
	Matrix weights_ih,weights_ho , bias_h,bias_o;	
	double l_rate;
	
	public NeuralNetwork(int i,int h,int o, double learning_rate) {
		weights_ih = new Matrix(h,i);
		weights_ho = new Matrix(o,h);
		
		l_rate = learning_rate;
		
		bias_h= new Matrix(h,1);
		bias_o= new Matrix(o,1);
		
	}
	
	public List<Double> predict(double[] X)
	{
		Matrix input = Matrix.fromArray(X);
		Matrix hidden = Matrix.multiply(weights_ih, input);
		hidden.add(bias_h);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weights_ho,hidden);
		output.add(bias_o);
		output.sigmoid();
		
		return output.toArray();
	}
	
	
	public void fit(double[][]X,double[][]Y,int epochs)
	{
		for(int i=0;i<epochs;i++)
		{	
			int sampleN =  (int)(Math.random() * X.length );
			this.train(X[sampleN], Y[sampleN]);
		}
	}
	
	public void train(double [] X,double [] Y)
	{
		Matrix input = Matrix.fromArray(X);
		Matrix hidden = Matrix.multiply(weights_ih, input);
		hidden.add(bias_h);
		hidden.sigmoid();
		
		Matrix output = Matrix.multiply(weights_ho,hidden);
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
		Matrix hidden_T = Matrix.transpose(hidden);
		Matrix who_delta =  Matrix.multiply(gradient, hidden_T);
		
		//applies proper gradients
		weights_ho.add(who_delta);
		bias_o.add(gradient);
		
		Matrix who_T = Matrix.transpose(weights_ho);
		Matrix hidden_errors = Matrix.multiply(who_T, error);
		
		Matrix h_gradient = hidden.dsigmoid();
		h_gradient.multiply(hidden_errors);
		h_gradient.multiply(l_rate);
		
		Matrix i_T = Matrix.transpose(input);
		Matrix wih_delta = Matrix.multiply(h_gradient, i_T);
		
		weights_ih.add(wih_delta);
		bias_h.add(h_gradient);
		
	}


}