package WildcardPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class ForEachLoopTest {
	public static void removeNegative(List<Double> v){
		System.out.println("the size of this list is :"+v.size());
		//you need to explicitly introduce an iterator if you wish to use the remove method
		for(Iterator<Double> it = v.iterator();it.hasNext();){
			if(it.next() < 0)
				it.remove();
		}
		System.out.println("the size of this list is :"+v.size());
	}
	
	public static double dot(List<Double> u, List<Double> v){
		if(u.size() != v.size())
			throw new IllegalArgumentException("different sizes");
		double d = 0;
		//you need to explicitly introduce an iterator if you wish to iterate over more than one list in parallel. 
		Iterator<Double> uIt = u.iterator();
		Iterator<Double> vIt = v.iterator();
		while(uIt.hasNext()){
			assert uIt.hasNext() && vIt.hasNext();
			d += uIt.next() * vIt.next();
		}
		assert !uIt.hasNext() && !vIt.hasNext();
		return d;
	}
	
	//Here is a method that accepts an array of any type and converts it to a list
	//By writing <T> at the beginning of the method signature, which declares T as a new type variable.
	//the scope of the type T is local to the method itself; it may appear in the method signature and the
	//method body, but not outside the method
	public static <T> List<T> toList(T[] arr){
		List<T> list = new ArrayList<T>();
		for(T elt:arr)
			list.add(elt);
		return list;
	}
	
	//vararg feature allows us to pass vary arguments to an method, and all passed arguments in the end will be 
	//packed into an array. The previous method can be written as following
	public static <T> List<T> toList2(T...arr){
		List<T> list = new ArrayList<T>();
		for(T elt:arr)
			list.add(elt);
		return list;
	}
	
	public static <T> void addAll(List<T> list,T...arr){
		for(T elt:arr)
			list.add(elt);
	}
	
	//we can do this, because nums is a type of list of Number
	public static void addIntAndDouble(){
		List<Number> nums = new ArrayList<Number>();
		nums.add(2);
		nums.add(2.2);
		assert nums.toString().equals("[2,2.2]");
		
		//List<Integer> ints = new ArrayList<Integer>();
		//ints.add(1);
		//ints.add(2);
		//we can not do this, can not cast from List<Integer> to List<Number>,
		//because List<Integer> is not a subtype of List<Number>.
		//If a structure contains elements with a type of form ? extends E,
		//we can get elements out of the structure, but we can not put elements into 
		//the structure.
		//List<Number> num = ints;
		//num.add(2.2);
		//assert ints.toString().equals("[2,2.2]");
		
		
	}
	
	//Wildcards and super
	/*
	 * 										Principle of Usage of Wildcard
	 * The get and put principle: Use and extends wildcard when you only get values out of a structure, 
	 * use a super wildcard when you only put values into a structure, and donot use wildcard when you both get and put.
	 */
	public static <T> void copy(List<? super T> dst, List<? extends T> src){
		for(int i=0;i<src.size();i++){
			dst.set(i, src.get(i));
		}
	}
	
	//we could also declare the method with several possible signatures
	/*public static <T> void copy(List<T> dst, List<T> src){
		for(int i=0;i<src.size();i++){
			dst.set(i, src.get(i));
		}
	}
	
	public static <T> void copy(List<T> dst, List<? extends T> src){
		for(int i=0;i<src.size();i++){
			dst.set(i, src.get(i));
		}
	}
	
	public static <T> void copy(List<? super T> dst, List<T> src){
		for(int i=0;i<src.size();i++){
			dst.set(i, src.get(i));
		}
	}*/
	
	//this method gets all of the value from a collection, which contains any type that is the subtype of Number,
	//so we are using extends wildcard
	public static double sum(Collection<? extends Number> nums){
		double s = 0.0;
		for(Number num : nums){
			s += num.doubleValue();
		}
		return s;
	}
	
	//whenever you use the add method, you put values into a structure, so use a super wildcard.
	public static void count(Collection<? super Integer> ints, int n){
		for(int i=0;i<n;i++){
			ints.add(i);
		}
	}
	
	
	
	
	public static void main(String args[]){
		ForEachLoopTest.removeNegative(Arrays.asList(12.2,12.4,12.5,12.6,12.7));
		double d = dot(Arrays.asList(12.2,12.4,12.5,12.6,12.7),Arrays.asList(12.2,12.4,12.5,12.6,12.7));
		System.out.println("the result of dot() is:"+d);
		
		List intList = toList(new Integer[]{1,2,3,4});//auto boxing conversion happens here
		List stringList = toList(new String[]{"1","2","3","4","5"});
		System.out.println("the intlist size is:"+intList.size());
		System.out.println("the stringList size is:"+stringList.size());
		
		List intList2 = toList2(1,2,3,4);//auto boxing conversion happens here
		List stringList2 = toList2("1","2","3","4","5");
		System.out.println("the intlist size is:"+intList2.size());
		System.out.println("the stringList size is:"+stringList2.size());
		
		//Whenever a vararg is declared, one may either pass a list of arguments, or explicitly pass the array directly.
		List intList3 = toList2(new Integer[]{1,2,3,4});//auto boxing conversion happens here
		List stringList3 = toList2(new String[]{"1","2","3","4","5"});
		System.out.println("the intlist size is:"+intList2.size());
		System.out.println("the stringList size is:"+stringList2.size());
		
		
		//the preceding method for addAll()
		List<Integer> ints = new ArrayList<Integer>();
		addAll(ints,1,2);
		addAll(ints,new Integer[]{3,4});
		assert ints.toString().equals("[1,2,3,4]");
		
		List<Object> objs = Arrays.<Object>asList(2,2.2,"Three");
		List<Integer> integers = Arrays.asList(5,6);
		copy(objs,integers);
		assert objs.toString().equals("[5,6,Three]");
		
		//we could also implements the method by using following
		copy(objs,integers);
		//<Object> is the type <T>
		ForEachLoopTest.<Object>copy(objs,ints);
		ForEachLoopTest.<Number>copy(objs,ints);
		ForEachLoopTest.<Integer>copy(objs,ints);
		
		
		//all of the following calls are legal for method sum()
		List<Integer> intts = Arrays.asList(1,2,3);
		sum(ints);
		List<Double> doubles = Arrays.asList(2.2,3.3,4.4);
		sum(doubles);
		List<Number> numbers = Arrays.<Number>asList(2,3.33,4,5.6);
		sum(numbers);
		
		//all of the following are legal calls for method count()
		List<Integer> intsss = new ArrayList<Integer>();
		count(intsss,3);
		List<Number> numsss = new ArrayList<Number>();
		count(numsss,5); numsss.add(3.23);
		List<Object> objsss = new ArrayList<Object>();
		count(objsss,9); objsss.add("ten");
				
	}
}
