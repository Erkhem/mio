import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;

class mio1Perceptrons
{
	static int MAX_ITER = 100;
	static double LEARNING_RATE = 0.1;           
	static int NUM_INSTANCES = 100;
	static int theta = 0; 
	
	public static void main(String args[]){ 
		
		Perceptron perceptron = new Perceptron();
		
		double[][] inputs = new double[10][NUM_INSTANCES];		
				
		
		int[] outputs = new int [NUM_INSTANCES];

		//fifty random points of class 1
		for(int i = 0; i < NUM_INSTANCES/2; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs[inputId][i] = randomNumber(-10 , 0); 
			}
			outputs[i] = 1;         
		}

		//fifty random points of class 0
		for(int i = 50; i < NUM_INSTANCES; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs[inputId][i] = randomNumber(4 , 8); 
			}
			outputs[i] = 0;        
		}
		
		
		
		//generate real input for real data instance (not training data) 1 l shirheg instance, 10 shirheg huleen awagch input ruu orj 1 output garna.
		double realInputs[] = new double[10]; //we have 10 inputs
		for(int j = 0; j < 10; j++){
			realInputs[j] = randomNumber(-10, +10);
		}
		
		int output = perceptron.getDecisionOfInput(realInputs, NUM_INSTANCES, inputs, outputs);
		System.out.print("Input "+realInputs+" is classified to "+output);
	}
	//end main  
 
	public static double randomNumber(int min , int max) {
		DecimalFormat df = new DecimalFormat("#.####");
		double d = min + Math.random() * (max - min);
		String s = df.format(d);
		double x = Double.parseDouble(s);
		return x;
	}

}