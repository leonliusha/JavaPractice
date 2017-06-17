/**
 * Created by Administrator on 2015/9/16.
 */

/***
 * te MICROS_PER_DAY gets a wrong number, because 24*60*60*1000*1000 is an int operation, the result will be
 * converts to Long after the calculation, because each factor of calculation is an integer.
 * But the calculation result is a wrong number, because the result is out of the boundary of integer, so
 * the result will be cut out. The MILLIS_PER_DAY is a correct result, because it is in the boundary of integer.
 *
 * To solve this problem, using a LONG value be the first calculation factory, this will force the remaining calculation
 * follows the LONG calculation.
 */
public class LongInteger {
    public static void main(String args[]){
        final long MICROS_PER_DAY = 24*60*60*1000*1000;
        final long MILLIS_PER_DAY = 24*60*60*1000;
        System.out.println("the MICROS_PER_DAY IS:"+MICROS_PER_DAY);
        System.out.println("the MILLIS_PER_DAY IS:"+MILLIS_PER_DAY);
        System.out.println("the result is: "+ MICROS_PER_DAY / MILLIS_PER_DAY);

        //SOLUTION
        final long MICROS_PER_DAY_2 = 24L*60*60*1000*1000;
        final long MILLIS_PER_DAY_2 = 24L*60*60*1000;
        System.out.println("the MICROS_PER_DAY_2 IS:"+MICROS_PER_DAY_2);
        System.out.println("the MILLIS_PER_DAY_2 IS:"+MILLIS_PER_DAY_2);
        System.out.println("the result is: "+ MICROS_PER_DAY_2 / MILLIS_PER_DAY_2);

    }
}
