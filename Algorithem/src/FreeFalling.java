/**
 * Created by Administrator on 2015/8/29.
 */
public class FreeFalling {
    public static double f(int n){
        double result;
        if(n == 1){
            result = 100;
            return result;
        }else{
            result = f(n-1)/2;
            return result;
        }

    }
    public static void main(String args[]){
       f(4);
    }
}
