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
		//input  variables (features)                      
		double[] x1 = new double [NUM_INSTANCES];    
		double[] x2 = new double [NUM_INSTANCES];
		double[] x3 = new double [NUM_INSTANCES];
		
        
		double[] x4 = new double [NUM_INSTANCES];    
		double[] x5 = new double [NUM_INSTANCES];
		double[] x6 = new double [NUM_INSTANCES];
		
        
		double[] x7 = new double [NUM_INSTANCES];    
		double[] x8 = new double [NUM_INSTANCES];
		double[] x9 = new double [NUM_INSTANCES];
		
		double[] x10 = new double [NUM_INSTANCES];
		
		
		int[] outputs = new int [NUM_INSTANCES];

		//fifty random points of class 1
		for(int i = 0; i < NUM_INSTANCES/2; i++){
			
			x1[i] = randomNumber(4 , 8); 
			x2[i] = randomNumber(2 , 9);    
			x3[i] = randomNumber(5 , 10);
			x4[i] = randomNumber(5 , 10);
			x5[i] = randomNumber(5 , 10);
			x6[i] = randomNumber(5 , 10);
			x7[i] = randomNumber(5 , 10);
			x8[i] = randomNumber(5 , 10);
			x9[i] = randomNumber(5 , 10);
			x10[i] = randomNumber(5 , 10);
			outputs[i] = 1;         
		}

		//fifty random points of class 0
		for(int i = 50; i < NUM_INSTANCES; i++){
			x1[i] = randomNumber(4 , 8); 
			x2[i] = randomNumber(2 , 9);    
			x3[i] = randomNumber(5 , 10);
			x4[i] = randomNumber(5 , 10);
			x5[i] = randomNumber(5 , 10);
			x6[i] = randomNumber(5 , 10);
			x7[i] = randomNumber(5 , 10);
			x8[i] = randomNumber(5 , 10);
			x9[i] = randomNumber(5 , 10);
			x10[i] = randomNumber(5 , 10);
			outputs[i] = 0;        
		}

		double[] weights = new double[11];// 10 for input variables and one for bias
		double localError, globalError;
		int i, p, iteration, output;

		for(int l=0;l<11;l++){
			weights[l] = randomNumber(0,1);
		}

		iteration = 0;
		do {
			iteration++;
			globalError = 0;
			//loop through all instances (complete one epoch)
			for (p = 0; p < NUM_INSTANCES; p++) {
				double inputs[] = {x1[p],x2[p],x3[p],x4[p],x5[p],x6[p],x7[p],x8[p],x9[p],x10[p]};
				// calculate predicted class
				output = calculateOutput(theta,weights, inputs);
				// difference between predicted and actual class values
				localError = outputs[p] - output;
				//update weights and bias
				for(int l = 0; l<10; l++){
					weights[l]+=LEARNING_RATE*localError*inputs[l];
				}
				weights[3] += LEARNING_RATE * localError;
				//summation of squared error (error value for all instances)
				globalError += (localError*localError);
			}

			/* Root Mean Squared Error */
			System.out.println("Iteration "+iteration+" : RMSE = "+Math.sqrt(globalError/NUM_INSTANCES));
		} while (globalError != 0 && iteration<=MAX_ITER);

//weights ni 10 sh bh yostoi
		System.out.println(weights[0] +"*x + "+weights[1]+"*y +  "+weights[2]+"*z + "+weights[3]+" = 0");

		//generate real input for real data instance (not training data) 1 l shirheg instance, 10 shirheg huleen awagch input ruu orj 1 output garna.
		double realInputs[] = new double[10]; //we have 10 inputs
		for(int j = 0; j < 10; j++){
			realInputs[j] = randomNumber(-10, +10);
		}
		output = calculateOutput(theta,weights, realInputs);
		System.out.println("class = "+output);
	}
	//end main  
 
	public static double randomNumber(int min , int max) {
		DecimalFormat df = new DecimalFormat("#.####");
		double d = min + Math.random() * (max - min);
		String s = df.format(d);
		double x = Double.parseDouble(s);
		return x;
	}


	//calculates which class would it belong
	static int calculateOutput(int theta, double weights[], double x[])
	{
		double sum = 0;
		for(int l=0;l<10;l++){
			sum+=x[l]*weights[l];
		}
		sum += weights[10]; //adding bias
		return (sum >= theta) ? 1 : 0;
	}

}