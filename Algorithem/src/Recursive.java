/**
 * Created by Administrator on 2015/8/26.
 */
public class Recursive {

    static void recursive(int number){
        int i;
        for(i=2;i<number-1;i++){
            if(number%i==0) {
                System.out.println(i);
                recursive(number/i);
                //break;
                return;
            }
        }
        System.out.println(number);
    }

    public static void main(String args[]){
        recursive(15);
    }
}
