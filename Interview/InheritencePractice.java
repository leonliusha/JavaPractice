package Practise;
class A{
	String s;
	A(String s){
		this.s = s;
		System.out.println(s);
	}
	private void start(){
		System.out.println(s);
	}
}

class B extends A{
	String s;
	B(String s){
		super(s);
		this.s =s;
		System.out.println(s);
	}
	public void start(){
		System.out.println("public start at B");
	}
}

class C extends B{
	String s;
	C(String s ){
		super(s);
		this.s = s;
		System.out.println(s);
	}
	public void start(){
		System.out.println(s);
	}
}
public class InheritencePractice {
	public static void main(String args[]){
		//A a = new A("a");
		//a.start();
		A b = new B("b");
		//b.start();
		//B c = new C("c");
		//c.start();
		
	}
}
