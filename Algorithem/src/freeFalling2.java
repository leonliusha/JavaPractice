/**
 * Created by Administrator on 2015/8/29.
 */
public class freeFalling2 {
    public static void main(String args[]){
        int high = 100, sum = 100;
        for(int i=1;i<=5;i++){
            high = high/2;
            System.out.println("the falling count "+i+" distance is: "+ high);
            sum = sum + high*2;
            System.out.println("the sum distance for falling count "+i+" is: "+sum);
        }
    }
}
