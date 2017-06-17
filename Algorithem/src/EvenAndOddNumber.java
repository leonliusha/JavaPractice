/**
 * Created by Administrator on 2015/8/30.
 */
public class EvenAndOddNumber {
    public static void sum(int number){
        double sum = 0;
        if(number%2==0) {
            for (int i = 2; i <= number; i += 2) {  //this is a good idea
                sum = sum + (double) 1 / i;
            }
        }else{
            for(int i = 1; i <= number; i++){
                sum = sum + (double) 1 / i;
            }
        }

    }
}
