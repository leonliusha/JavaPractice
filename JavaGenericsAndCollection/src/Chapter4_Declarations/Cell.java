package Chapter4_Declarations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//the type parameter has to be allocated to class identifier, can not be allocated to constructor..
public class Cell<T> {
	private final int id;
	private final T value;
	
	//Static members fare shared across all instantiations for a class, so the same count is 
	//incremented when allocating either a string or an integer cell.
	private static int count=0;
	private static synchronized int nextId(){
		//Arrays.asList();
		return count++;
	}
	
	//Since the class may be used with different type parameters, it makes no sense to refer to T in the declaration of the static filed
	//values or static method getValues().
	//public static List<T> values1 = new ArrayList<T>();//compile-time error, can not make static reference to a none static type T
	//public static List<T> getValues(){return values;} // compile-time error.

	//If we want a list of all values kept in cells, then we need to use a list of objects.
	private static List<Object> values = new ArrayList<Object>();
	public Cell(T value){
		this.value = value;
		id = nextId();
		values.add(value);
	}
	
	public static List<Object> getValues(){
		return values;
	}
	
	public T getValue(){
		return value;
	}
	
	public int getId(){
		return id;
	}
	
	public static synchronized int getCount(){
		return count;
	}
	
	public static void main(String args[]){
		Cell<Integer> a = new Cell<Integer>(1);
		Cell<String> b = new Cell<String>("two");
		
		//Because static members are independent of any type parameters, we are not permitted to follow the class
		//name with type parameters when accessing a static member. The count is static, so it is a property of the class as a whole,
		//not any particular instance.
		Cell.getCount();// this is ok
		//Cell<Integer>.getCount(); // get compile-time error
		//Cell<?>.getCount(); //get compile-time error
		assert a.getId() == 1 && b.getId() == 1 && Cell.getCount() == 2;
		
		System.out.println(false | false);
	}
}
