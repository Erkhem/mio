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
		
		for(int i=0; i<10;i++){
			System.out.println(i+"th element is : "+realInputs[i]);
		}
		int output = perceptron.getDecisionOfInput(realInputs, NUM_INSTANCES, inputs, outputs);
		System.out.print("Input "+realInputs+" is classified to "+output);
		
		
		
		
		
		
		//MIO Lab 2
		
		//Defined 3 new classes. A [-10,-5] ; B [ -2, 3] ; C[5,10]
		int nr_instances = 90;

		// Create 3 Perceptrons which clasify if the element is clasified into A or B or C each classes. 
		Perceptron perceptronA = new Perceptron();
		Perceptron perceptronB = new Perceptron();
		Perceptron perceptronC = new Perceptron();
		
		double[][] inputs2 = new double[10][nr_instances];
		//expected outputs, which indicated which class it should be classified.
		//0-A, 1-B, 2-C
		int[] outputs2  = new int[nr_instances];
		
		//Prepare training data for A
		//30 random points of class A
		for(int i = 0; i < nr_instances/3; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-10 , -5); 
			}
			outputs2[i] = 1;         
		}

		//30 random points of class B
		for(int i = 29; i < nr_instances/3; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-2 , 3); 
			}
			outputs2[i] = 0;        
		}
		
		//30 random points of class C
		for(int i = 59; i < nr_instances/3; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(5 , 10); 
			}
			outputs2[i] = 0;        
		}		
		
		perceptronA.trainData(nr_instances/3, inputs2, outputs2);

		
		//Prepare training data for B
		
		for(int i = 0; i < nr_instances/3; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-10 , -5); 
			}
			outputs2[i] = 0;         
		}
		//30 random points of class B
		for(int i = 29; i < nr_instances/2; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-2 , 3); 
			}
			outputs2[i] = 1;        
		}
		
		//30 random points of class C
		for(int i = 59; i < nr_instances/2; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(5 , 10); 
			}
			outputs2[i] = 0;        
		}	
		
		
		perceptronB.trainData(nr_instances/3, inputs2, outputs2);
		
		
		
		//Prepare training data for C
		
		for(int i = 0; i < nr_instances/3; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-10 , -5); 
			}
			outputs2[i] = 0;         
		}
		//30 random points of class B
		for(int i = 29; i < nr_instances/2; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(-2 , 3); 
			}
			outputs2[i] = 0;        
		}
		
		//30 random points of class C
		for(int i = 59; i < nr_instances/2; i++){
			for(int inputId=0;inputId<10;inputId++){
				inputs2[inputId][i] = randomNumber(5 , 10); 
			}
			outputs2[i] = 1;        
		}
		
		perceptronC.trainData(nr_instances/3, inputs2, outputs2);
		
		//generate real input for real data instance (not training data) 1 l shirheg instance, 10 shirheg huleen awagch input ruu orj 1 output garna.
				double realInputs2[] = new double[10]; //we have 10 inputs
				for(int j = 0; j < 10; j++){
					realInputs2[j] = randomNumber(-10, +10);
				}
				
				for(int i=0; i<10;i++){
					System.out.println(i+"th element is : "+realInputs[i]);
				}
				int output2 = perceptron.getDecisionOfInput(realInputs2, nr_instances, inputs, outputs);
				System.out.print("Input "+realInputs+" is classified to "+output);
		
		//Not able to train
				
				double[][] inputsNotLiniear = new double[10][NUM_INSTANCES];
				int[] ouputsNonLinear = new int[NUM_INSTANCES];
				
				
				//fifty random points of class 1
				for(int i = 0; i < NUM_INSTANCES/2; i++){
					for(int inputId=0;inputId<10;inputId++){
						inputsNotLiniear[inputId][i] = randomNumber(-10 , 0); 
					}
					ouputsNonLinear[i] = 0;         
				}

				//fifty random points of class 0
				for(int i = 50; i < NUM_INSTANCES; i++){
					for(int inputId=0;inputId<10;inputId++){
						inputsNotLiniear[inputId][i] = randomNumber(4 , 8); 
					}
					ouputsNonLinear[i] = 1;        
				}
				
				//Last element will always be clasified wrong
				ouputsNonLinear[NUM_INSTANCES-1] = 1;
				ouputsNonLinear[NUM_INSTANCES-2] = 1;
				
				Perceptron perceptronNotLiniear = new Perceptron();
				double[] clasiffiedWrong = {5,5,5,5,5,5,5,5,5,5};
				
				int wrongTrainingDataOutput = perceptronNotLiniear.getDecisionOfInput(clasiffiedWrong, NUM_INSTANCES, inputsNotLiniear, ouputsNonLinear);
				System.out.print("This wrong training data output will be random: "+wrongTrainingDataOutput);
		
		
		
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