import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by liu on 15-5-15.
 */
public class Searching {
    public static void main(String args[]){
        String[] strings = {"0","1","2","3","4","99"};
        List<Integer> integers = new ArrayList<Integer>();
        for(String s : strings)
            integers.add(Integer.valueOf(s));
        System.out.print(Collections.binarySearch(integers,99,comp));
    }
    static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //pay attention to == operator, the == operator compares the references, and return true if and only if the
            //two references are identical. When o1 and o2 do the auto unboxing, which means they become the int, then
            //== operator do compare the values. this is a bug in early JDK, but in JDK 7 this bug is fixed, now when we
            //do the integer auto unboxing, the compiler will do the values value checking just like equals() does.
            return o1 < o2 ? -1 : (o1==o2 ? 0 : 1);

            //we can fix this by following
            //return o1 < o2 ? -1 : (o1.equals(o2) ? 0 : 1);
        }
    };

}
