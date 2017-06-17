/**
 * Created by Administrator on 2015/8/26.
 */
public class MonkeyAndPeachs {
    /***
     * f(n-1) = f(n)/2 - 1  ==>   f(n-1) + 1 = f(n)/2  ==>   2 * f(n-1) + 2 = f(n)   ==>   f(n) = 2 * (f(n-1) + 1)
     * @param n days
     * @return
     */


    public static int f(int n){
        if(n == 1)
            return 1;
        else
           return 2*(f(n-1)+1);
    }

    public static void main(String args[]){
        System.out.println(f(10));
    }
}
