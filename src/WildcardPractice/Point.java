package WildcardPractice;

import java.lang.reflect.Method;

public class Point {
	public int x;
	public int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point clone(){
		return new Point(x, y);
	}
	
//	public Object clone(){
//		return new Point(x,y);
//	}
	
	
	
	public static void main(String args[]){
		for(Method m: Point.class.getMethods()){
			if(m.getName().equals("clone")){
				System.out.println(m.toGenericString());
				System.out.println(m.toString());
			}
		}
	}
}
