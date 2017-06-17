package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
public class CollectionsFrameworkTest {
	public static void main(String args[]){
		//Arrays.asList() return an ArrayList that is an inner class of class Arrays.
		//this inner class ArrayList does not has add() and remove() method, therefore, this returned inner class ArrayList
		//can not be resized.
		List<String> a = Arrays.asList("one","two","three","four");
		Iterator<String> iterator = a.iterator();
		while(iterator.hasNext()){
			System.out.println("the element is:"+iterator.next());
		}
		a.add("five");   //this will give an unsupportedOperationException,because Arrays.asList() return an fixed size ArrayList.
		while(iterator.hasNext())
			System.out.println("the element is:"+iterator.next());
		Collection c = null;
		
		
		List strings = Arrays.asList("a","b","c","d");
		//this will give an runtime exception of Class Cast Error.
		//Remember this principle: the reified type of an array must be a subtype of the erasure of its static type.
		//CAN NOT cast Object[] to String[]
		String[] aa = (String[])toArray2(strings);
		
		List<String> l = Arrays.asList("1","2","3");
		String[] aaa = new String[l.size()];
		for(int i=0;i<l.size();i++)
			aaa[i] = l.get(i);
		
		removeElement();
		
	}
	
	public static void removeElement(){
		Collection<String> col = new ArrayList<String>();
		for(int i=0;i<5;i++)
			col.add(new Integer(i).toString());
		for( String s : col)
			System.out.println("in removeElement()-the String is:"+s);
		for(Iterator<String> it=col.iterator();it.hasNext();){
			String s = it.next();
			if(s.equals("3"))
				//using iterator's remove method is better, since it will not throws ConcurrentModificationException
				it.remove();//col.remove(s);
		}
		for( String s : col)
			System.out.println("in removeElement()-the String is:"+s);
	}
	
//	public <T> T[] toArray(Collection<T> c){
//		//T[] a = new T[c.size()]; // compile-time error, this will give an" can not create a generic array of T
//		int size = c.size();
//		T[] a = new T[size];  // this would not work either, we can not create an generic array of T
//		int i=0;
//		for(T t:c)
//			a[i++] = t;
//		return a;
//	}
	
	public static Object[] toArray2(Collection c){
		Object[] a = new Object[c.size()];
		int i=0;
		for(Object x:c)
			a[i++] = x;
		return a;
	}
	
	//One way to get money is to already have money.One way to get a new array of a generic type is to already have an array of that type.
	//then the reified type information for new array can be copied from the old.
	//Reflection is used to allocate a new array with the same reified type as the old, and then the collection is copied into the new array.
	@SuppressWarnings("unchecked")
	public static <T> T[] Array(Collection<T> c,T[] a){
		if(a.length < c.size())
			//this is a good way to create an Array of Generic Type T
			a = (T[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), c.size());
		int i=0;
		for(T x:c)
			a[i++] = x;
		if(i < a.length)
			a[i] = null;
		return a;
	}
	
	
	//NEVER create an array with generic type value
//	public List<Integer>[] twoLists(){
//		List<Integer> a = Arrays.asList(1,2,3);
//		List<Integer> b = Arrays.asList(4,5,6);
//		List<Integer> c = new ArrayList<Integer>();
//		List<Integer> d = new ArrayList<Integer>();
//		List e = new ArrayList();
//		List f = new ArrayList();
//		List g =  Arrays.asList(1,2,3);
//		List h = Arrays.asList(4,5,6);
//		//return new List<Integer>[]{a,b};
//		return new List<Integer>[]{a,b};   //compile-time error, we CANNOT create a generic type array
//	}

	
	Collection c = new ArrayList();
	
	//Stack threadSafe = new SynchronizedArrayStack(new ArrayStack());
	
	//this concurrent collection using Mechanisms 1: Copy-on-Write, any change to the value of the collection results in a new array being created
	//to represent the new values. Synchronization is used by these classes during the creation of a new array. 
	//The collection based on Copy-on-Write using an snapshot iterators, which can read the values in one of there arrays without danger of them
	//being changed by another thread.
	CopyOnWriteArrayList a = new CopyOnWriteArrayList();
	
	//this concurrent collection using Mechanisms 2: Compare-and-Swap, it makes a local copy of the variables, when it is ready to update the variable it call CAS,
	//which in one atomic operation compares the variable's value with its value at the start end, if they are the same, updates it with the new value.
	//If they are not the same, the variable must have been modified by another thread, in this situation, CAS thread can try the calculation using the new value.
	ConcurrentLinkedQueue b = new ConcurrentLinkedQueue();
	
	//this concurrent collection using Mechanisms 3: java.util.concurrent.locks.Lock
	ConcurrentHashMap hashMap = new ConcurrentHashMap();
	
	public static List<Integer>[] twoList(){
		List<Integer> a = Arrays.asList(1,2,3);
		List<Integer> b = Arrays.asList(4,5,6);
		ArrayList c = new ArrayList(a);
		List d = Arrays.asList("aaa","ccc");

		return new List[]{d};
		//can not create a parameterized type array.
		//return new List<Integer>[]{a,b}; // can not create an array by using un reified type , such as List<Integer>,
		//return new List[]{a,b};            // List is an reified type, but list<Integer> is not
		//return new ArrayList[]{c};       //this is also ok, because ArrayList is reified type
		//return new ArrayList<Integer>[]{c};   // this is NOT OK< because ArrayList<Integer> is un reified type.
	}
	

}
