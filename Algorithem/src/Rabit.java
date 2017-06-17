/**
 * Created by Administrator on 2015/8/28.
 */
public class Rabit {
    public static int f(int n){
        int resoult;
        if(n == 1) {
            resoult = 2;
            System.out.println(resoult);
            return resoult;
        }else if(n%2==0){
            resoult = f(n-1);
            System.out.println(resoult);
            return resoult;
        }else{
            resoult = f(n-1)*2;
            System.out.println(resoult);
            return resoult;
        }
    }

    public static void main(String args[]){
        f(10);
    }
}
