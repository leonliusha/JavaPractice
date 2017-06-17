/**
 * Created by Administrator on 2015/8/29.
 */
public class SumOfDevisionNumber {
    public static void main(String args[]){
        double x=2, y=1;
        double sum = 0.0;
        for(int i=1;i<=20;i++){
            sum = sum + x/y;
            x = x + y;
            y = x - y;
        }
        System.out.println("the result of first 20 numbers are: "+sum);
    }
}
