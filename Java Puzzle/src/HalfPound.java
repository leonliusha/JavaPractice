/**
 * Created by Administrator on 2015/9/16.
 */

/**
 *  x += i; will be converted to   E1 op= E2 ==>  E1 = (T) ((E1) op (E2)), of which T is the type of E1
 *  if the type of calculation is widen than Left, the Narrow Operation will be applied, the value will be cut out.Wrong result
 *
 *  In following example, x is short, i is int which means i is widen than x, the result will be cut from int to short
 */
public class HalfPound {
    public static void main(String args[]){
        short x = 0;
        int i = 123456;
        x += i;
        System.out.println("the x += i is: "+x);

        short x2 = 0;
        int i2 = 123456;
        //x2 = x2 + i2;   //this will give an error at compile time
    }

}
