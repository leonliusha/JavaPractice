/**
 * Created by Administrator on 2015/8/29.
 */
public class MonkeyPeachs2 {
    /****
     * f(n+1) = f(n)/2 - 1 ==>  f(n+1) +1 = f(n)/2  ==> f(n) = 2*f(n+1) + 2;
     * @param n
     * @return
     */
    public static int f(int n){
        int result = 0;
        if(n==10){
            result = 1;
        }else{
            result = (f(n+1)+1)*2;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println("the totoal peaches is: "+f(1));
    }
}
