package CollectionFramework;

import sun.java2d.pipe.NullPipe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liu on 15-5-21.>
 */

//merging collections using nature ordering, so has to extends Comparable
    //this merging can be done easily by using SortedSet, such as TreeSet.ie.
    //Set<T> mergedCollection = new TreeSet<T>(c1);
    //mergedCollection.addAll(c2);
public class MergeCollections {
    static <T extends Comparable<? super T>> List<T> merge(Collection<? extends T> c1, Collection<? extends T> c2){
        List<T> mergedList = new ArrayList<T>();
        Iterator<? extends T> it1 = c1.iterator();
        Iterator<? extends T> it2 = c2.iterator();
        T c1Element = getNextElement(it1);
        T c2Element = getNextElement(it2);
        while(c1Element != null || c2Element != null){
            boolean useC1Element = c2Element == null || c1Element != null & c1Element.compareTo(c2Element) < 0;
            if(useC1Element){
                mergedList.add(c1Element);
                c1Element = getNextElement(it1);
            }else {
                mergedList.add(c2Element);
                c2Element = getNextElement(it2);
            }
        }
        return mergedList;
    }

    static <E> E getNextElement(Iterator<E> iterator){
        if(iterator.hasNext()){
            E nextElement = iterator.next();
            if(nextElement == null)
                throw new NullPointerException();
            return nextElement;
        }else
            return null;
    }
}
