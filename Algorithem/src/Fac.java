/**
 * Created by Administrator on 2015/8/29.
 */
public class Fac {
    public static int f(int number) {
        if (number == 1) {
            return 1;
        } else if (number == 2) {
            return 2;
        } else {
            return number * f(number - 1);
        }
    }
    public static void main(String args[]){
        System.out.println(f(5));
    }
}
