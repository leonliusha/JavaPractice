package CollectionFramework;

import java.util.Iterator;

/**
 * Created by liu on 15-5-21.
 */
public class IteratorAndIterableTest {
    public static void main(String args[]){
        Counter counter = new Counter(10);
        for(int i : counter)
            System.out.println("the counter is:"+i);
    }
}


class Counter implements Iterable<Integer>{
    private int count;
    public Counter(int count){
        this.count = count;
    }
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){
            private int i = 0;
            public boolean hasNext(){
                return i < count;
            }

            public Integer next(){
                i++;
                return i;
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}
