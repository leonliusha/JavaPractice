package WildcardPractice;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

class ComparablePractice {
	Number m = new Integer(2);
	Number n = new Double(2.2);
	//assert m.compareTo(n) < 0;   //compile-time error, because Number does not implement Comparable interface.
	
	
	// the code    "<T extends Object & Comparable<? super T>>" is used to define what kind of T it is.
	//and we say that T is bounded by Comparable<? super T>.
	//unlike wildcards, type variables must always be bounded using extends, never super.
	//Following the Get and Put principle, we use extends with Collection because we get values of type T form collection,
	//and we use super with Comparable because we put value of type T into the compareTo method.
	public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll){
		Iterator<? extends T> iterator = coll.iterator();
		T candidate = iterator.next(); //using iterator next() rather than get(0).
		while(iterator.hasNext()){
			T next = iterator.next();
			if(next.compareTo(candidate)>0){
				candidate = next;
			}
		}
		return candidate;
	}
	
	
	//this is an another way to accomplish the previous task without using Comparable interface.
	//alternatively, using Comparator interface.
	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp){
		Iterator <? extends T> iterator = coll.iterator();
		T candidate = iterator.next();
		for(T elt:coll){
			if(cmp.compare(candidate, elt)<0)
				candidate = elt;
		}
		return candidate;
	}
	
	
	// this is an inner class that behaving like a Comparator.
	Comparator<String> sizeOrder = new Comparator<String>(){
		public int compare(String s1, String s2){
			return 
				s1.length() < s2.length() ? -1 :
				s1.length() > s2.length() ? 1 :
				s1.compareTo(s2);
		}
	};
	
	//This simply reverse the order of arguments to the comparator. And here is a method that returns the reverse of the
	//natural ordering.
	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder(){
		return new Comparator<T>(){
			public int compare(T t1,T t2){
				return t2.compareTo(t1);
			}
		};
	}
}
