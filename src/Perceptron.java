import java.text.DecimalFormat;


public class Perceptron {

	static int MAX_ITER = 100;
	private double[] inputs = new double[10];
	double[] weights = new double[11]; //10 inputs+1 bias
	static int theta=1;
	
	static double LEARNING_RATE = 0.1;
	
	//main decision making function
	public int getDecisionOfInput(double[] input,int numberOfTrainingDataInstance,
			double[][] trainingInputs, int[] trainingOutputs){
		
		trainData(numberOfTrainingDataInstance, trainingInputs, weights, trainingOutputs);
		return calculateOutput(weights, inputs);
		
	}
	
	public void trainData(int numberOfInstances,double[][] inputs, double[] weights, int[] outputs ){
		double localError, globalError;
		int i, p, iteration=0, output;		
		
		for(int l=0;l<10;l++){
			weights[l] = randomNumber(0,1);
		}

		iteration = 0;
		do {
			iteration++;
			globalError = 0;
			//loop through all instances (complete one epoch)
			for (p = 0; p < numberOfInstances; p++) {
				// calculate predicted class
				double[] inputInstance = new double[10];
				for(int iter = 0;iter<10;iter++){
					inputInstance[iter] = inputs[iter][p];
				}
				output = calculateOutput(weights, inputInstance);
				// difference between predicted and actual class values
				localError = outputs[p] - output;
				//update weights and bias
				for(int l = 0; l<10; l++){
					weights[l]+=LEARNING_RATE*localError*inputs[l][p];
				}
				weights[3] += LEARNING_RATE * localError;
				//summation of squared error (error value for all instances)
				globalError += (localError*localError);
			}

			/* Root Mean Squared Error */
			System.out.println("Iteration "+iteration+" : RMSE = "+Math.sqrt(globalError/numberOfInstances));
		} while (globalError != 0 && iteration<=MAX_ITER);

	}
	
	//random number generator between min and max
	public static double randomNumber(int min , int max) {
		DecimalFormat df = new DecimalFormat("#.####");
		double d = min + Math.random() * (max - min);
		String s = df.format(d);
		double x = Double.parseDouble(s);
		return x;
	}
	
	//calculates which class would it belong
	static int calculateOutput(double weights[], double x[])
	{
		double sum = 0;
		for(int l=0;l<10;l++){
			sum+=x[l]*weights[l];
		}
		sum += weights[10]; //adding bias
		return (sum >= theta) ? 1 : 0;
	}
	
	private int getTheta(){
		
		//TODO
		return 0;
	}
	
}
