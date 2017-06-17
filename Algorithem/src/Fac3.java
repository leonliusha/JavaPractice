/**
 * Created by Administrator on 2015/8/29.
 */
public class Fac3 {
    //1! + 2! + 3! + 4! + 5!
    public static void main(String args[]){
        int result = 1, sum = 0;
        for(int i=1; i<=5;i++){
            result = result * i;
            sum = sum + result;
        }
        System.out.println("the 1! + 2! + 3! + 4! + 5! is: "+sum);
    }

}
