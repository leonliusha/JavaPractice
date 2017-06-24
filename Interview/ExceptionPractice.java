package Practise;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Gum{
	static{
		System.out.println("Gum is loading");
	}
	public void print(){
		System.out.println("pring method from class Gum.");
	}
	public void print2(){
		System.out.println("pring method2 from class Gum.");
	}
	public void print3(){
		System.out.println("pring method3 from class Gum.");
	}
}

public class ExceptionPractice {
	
	public static void main(String[] args) {
		System.out.println("getValue:"+getValue());
		try {
			Class<?> c =Class.forName("Practise.Gum");
			Method[] methods = c.getMethods();
			for(Method m : methods){
				try {
					m.invoke(c.newInstance());
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		public static int getValue(){
		int i=1;
		try{
		throw new Exception();
		}catch(Exception e){
		return ++i;
		}finally{
		    ++i;
		   Class c= Boolean.TYPE;
		   System.out.println(c.getName());
		   System.out.println("is a interface?"+c.isInterface());
		   System.out.println(Boolean.class);
		   Class f = Gum.class;
		   System.out.println(f.getName());
		   try {
			Class.forName("Practise.Gum");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finally:"+i);
		 }							
		}
}
