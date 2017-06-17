import java.util.HashMap;

/**
 * Created by Administrator on 2015/9/14.
 */
public class ModeTesting {
    public static boolean isOdd(int i){
        //this is not correct, because negative integer value will always return false no matter if it is a odd or not.
        //such as, -9 is odd, but the following will return false.
        //because the contract of MODE operator is for positive integer ONLY.
        return i % 2 == 1;

        //using following statement instead
        //return i % 2 != 0;

        //for the performance consideration using '&' operation is faster
        //return (i & 1) != 0;

    }

    public static void main(String args[]){
        System.out.println(" the result is: "+ isOdd(-9));
        System.out.println(5 & 1);
    }
}
