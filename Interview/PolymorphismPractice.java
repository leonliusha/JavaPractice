package Practise;

import java.util.HashMap;
import java.util.Map;

public class PolymorphismPractice {
	public void f(){System.out.println("private f()");}

	public static void main(String args[]){
		//PolymorphismPractice po = new Derived();
		Map m = new HashMap();
		Derived po = new Derived();
		po.f();
		
	}
}
	
	
	class Derived extends PolymorphismPractice{
		public void f(){
			System.out.println("public f() at Derived");
			//return "public f() at Derived";
	}
	}
	
	
		
		

