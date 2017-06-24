package WildcardPractice;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
public class Comparators {
	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp){
		Iterator<? extends T> iterator = coll.iterator();
		T candidate = iterator.next();
		while(iterator.hasNext()){
			T next = iterator.next();
			if(cmp.compare(candidate, next) < 0 )
				candidate = next;
		}
		return candidate;
	}
	
	public static <T extends Object & Comparable<T>> T max(Collection<T> coll){
		return max(coll,Comparators.<T>natureOrder());
	}
	
	public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll){
		return max(coll, Comparators.<T>reverseOrder());
	}
	
	public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp){
		return max(coll, reverseOrder(cmp));
	}
	
	public static <T extends Object & Comparable<T>> Comparator<T> natureOrder(){
		return new Comparator<T>(){
			public int compare(T t1,T t2){
				return t1.compareTo(t2);
			}
		};
	}	
	
	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder(){
		return new Comparator<T>(){
			public int compare(T t1,T t2){
				return t2.compareTo(t1);
			}
		};
	}
	
	public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp){
		return new Comparator<T>(){
			public int compare(T t1,T t2){
				return cmp.compare(t2, t1);
			}
		};
	}
	
}
