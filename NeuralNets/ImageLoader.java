package main.NeuralNets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

public class ImageLoader {
	double[][] X, Y;
	
	public ImageLoader(int imageSize, int outputPossibilities) {
		X = new double[60][imageSize];
		Y = new double[60][outputPossibilities];
	}
	
	public void populateData() {
		for(int dogCounter = 0; dogCounter<30; dogCounter++) {
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("src/main/NeuralNets/data/dog." + String.valueOf(dogCounter) + ".jpg"));
			} catch (IOException e) {
			} 
			
			BufferedImage croppedImg = null;
			
			try {
				croppedImg = resize(img, 250, 250);
			} catch (IOException e) {

			}
			
			for(int row_counter = 0; row_counter<30;row_counter++) {
				for(int row = 0; row<250;row++) {
					for(int column = 0; column<250;column++) {
						X[row_counter][(row*250)+column]= croppedImg.getRGB(row, column);
					}
					
				}
			}
			
			Y[dogCounter][0] = 1;
			Y[dogCounter][1] = 0; 
			
		}
		
		for(int dogCounter = 0; dogCounter<30; dogCounter++) {
			BufferedImage img = null;
			try {
			    img = ImageIO.read(new File("src/main/NeuralNets/data/cat." + String.valueOf(dogCounter) + ".jpg"));
			} catch (IOException e) {
			} 
			
			BufferedImage croppedImg = null;
			
			try {
				croppedImg = resize(img, 250, 250);
			} catch (IOException e) {

			}
			
			for(int row_counter = 30; row_counter<X.length;row_counter++) {
				for(int row = 0; row<250;row++) {
					for(int column = 0; column<250;column++) {
						X[row_counter][(row*250)+column]= croppedImg.getRGB(row, column);
					}
					
				}
			}
			
			Y[dogCounter+30][0] = 0;
			Y[dogCounter+30][1] = 1; 
			
		}
	}
	
	public static BufferedImage resize(BufferedImage img, int newW, int newH) throws IOException {
		return Thumbnails.of(img).forceSize(newW, newH).asBufferedImage();
		}
	
	public double[][] getX() {
		return X;
	}
	
	public double[][] getY() {
		return Y;
	}

}
