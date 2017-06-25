package Practise;

public class Fabonacci {

	public int fabonacciAlgorithm(int num){
		if(num == 1){
			return 1;
		}
		else if(num == 2)
		{
			return 1;
		}
		else {
			System.out.println(fabonacciAlgorithm(num-1) + fabonacciAlgorithm(num-2));			
			return fabonacciAlgorithm(num-1) + fabonacciAlgorithm(num-2);
		}
	}
	
	public static void main(String args[]){
		Fabonacci fab = new Fabonacci();
		int result = fab.fabonacciAlgorithm(5);
		System.out.println("result is"+result);
	}
}
