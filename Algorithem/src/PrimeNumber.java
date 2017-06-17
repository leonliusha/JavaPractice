/**
 * Created by Administrator on 2015/8/26.
 */
public class PrimeNumber {

    public static boolean isPrimeNumber(int number){
        for(int i=2;i<Math.sqrt(number);i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        int n = 0;
        for(int i=2;i<=100;i++) {
            if (isPrimeNumber(i)) {
                n++;
                System.out.print(i + " ");
                if (n == 10) {
                    System.out.println();
                    n = 0;
                }
            }
        }
    }
}
