package Wildcard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class ArraysWithGenerics {
	//array subtyping is COVARIANT, meaning that type S[] is considered to be a subtype of T[] whenever S is a subtype of T.
	public static void put(){
		Integer[] ints = new Integer[]{1,2,3};
		Number[] nums =ints;
		nums[2] = 3.14; //this will throw an ArrayStoreException, since trying to put an double into Integer[]
		assert Arrays.toString(ints).equals("[1,2,3.14]");
	}
	
	//List subtyping is INVARIANT, meaning that List<S> is not subtype of List<T>, except in the case where S and T are identical.
	/*public static void ListPut(){
		List<Integer> ints = Arrays.asList(1,2,3);
		List<Number> nums = ints; //Compile-time error
		nums.set(2, 3.14);
	}*/

	public static void arrayAndListTesting(){
		List<Integer> intLists = Arrays.asList(1,2,3);
//		List<Number> numLists = intLists;
		Integer[] intArrays = new Integer[]{1,2,3};
		Number[] numArrays = intArrays;
		numArrays[0] = 3.14;       // ArrayStoreException
		for(int i=0;i<numArrays.length;i++)
			System.out.print("numArrays is:"+numArrays[i]);
	}
	
	//this method violate the Get and Put principle, which is Get uses extends and Put uses the super.
	//because we can not put a value into a type declared with an extends wildcard

	//List<String> is NOT a subtype of List<Object>
	//List<String> IS a subtype of List<? extends Object>
	//List<Object> IS a subtype of List<? super String>
	//NO wildcard type for return value, because:
	//1>would not make API any more flexible
	//2>would not force use to deal with wildcard type explicitly
	//3>User should not have to think about the wildcard to use your API
	public static void put2(){
		List<Integer> ints = Arrays.asList(1,2,3);
		List<? extends Number> nums = ints;
		//nums.set(2, 3.14); //compile-time error
	}
	
	public static void reverse(List<?> list){
		List<Object> tmp = new ArrayList<Object>(list);
		for(int i=0;i<list.size();i++){
			//list.set(i, tmp.get(list.size()-i-1)); // compile-time error, we can not set an Object to an unknown type.
		}
	}

	public static <T> void reverse2(List<T> list){
		List<T> tmp = new ArrayList<>(list);
		for(int i=0;i<list.size();i++)
			list.set(i,tmp.get(list.size()-i-1));
	}
	
	//instead, we can rewrite the upon method with following
	//this is called  Wildcard Capture
	public static void reverseVersion2(List<?> list){
		rev(list);
	}
	
	private static <T> void rev(List<T> list){
		List<T> tmp = new ArrayList<T>(list);
		for(int i=0;i<list.size();i++){
			list.set(i, tmp.get(list.size()-i-1));
		}
		
	}
	
	
	//Wildcard restriction,
	public static void wildcardRestriction(){
		//List<?> list = new ArrayList<?>();  //compile-time error, can not initiate ArrayList<?>
		//<1> no Instance Creation(new)
		//Map<String,? extends Number> map = new HashMap<String,? extends Number>();   //compile-time error, can not initiate HashMap<String,? extends Number>
	
		//<2> only top level parameters in instance creation are prohibited from containing wildcards.
		//Nested wildcards are permitted. the following is legal:
		List<List<? extends Object>> lists = new ArrayList<List<? extends Object>>();
		lists.add(Arrays.asList(1,2,3));
		lists.add(Arrays.asList("four","three","tw0"));
	}
	
	
	
	
	
	//Again, the Get and Put principle.
	public static void StructureWithWildcard(){
		List<Number> nums = new ArrayList<Number>();
		List<? super Number> sink = nums;
		List<? extends Number> source = nums;
		for(int i=0;i<10;i++){
			sink.add(i);
		}
		double sum=0;
		for(Number num:source)
			sum+=num.doubleValue();
	}
	
	public static void main(String args[]){
		//put();
		arrayAndListTesting();
		Collections.reverse(Arrays.asList(1,2,3,4,5));
	}
	
}