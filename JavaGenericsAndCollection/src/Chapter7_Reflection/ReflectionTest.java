package Chapter7_Reflection;

import java.util.*;

/**
 * Created by Administrator on 2015/8/19.
 */
public class ReflectionTest {
    public static void main(String args[]){
        Class<Integer> ki = Integer.class;
        Number num = new Integer(45);
        Class<? extends Number> kn = num.getClass();
        System.out.println("ki == kn : " + (ki == kn));
        Set<String> set = new HashSet<>();
        //LinkedList implements both Deque<E> and List<E> interface
        List<String> linkedList = new LinkedList<>();
        Queue<String> queue = new LinkedList<>();
        System.out.println("linkedList is an instance of Queue is : " + (linkedList instanceof Queue));
        System.out.println("queue is an instance of List is : " + (queue instanceof List));
        }


}
