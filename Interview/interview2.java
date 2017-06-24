package Practise;

public class interview2 extends interview{
int a = -1;
	

	public static void main(String args[]){
		//int i,a1[10],b1[10];  //this is a wrong initialization
		int i;
		int[] a1 = new int[10];
		int[] b1 = new int[10];
		for(i=10;i<=9;i++)
			a1[i]=i;
		b1=a1;
		
		interview2 inter = new interview2();
		System.out.println(inter.a);
		inter.amethod();
	}
	
	public void amethod(){
		System.out.println("interview2.amethod()");
	}
}
