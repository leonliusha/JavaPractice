/**
 * Created by Administrator on 2015/8/29.
 */
public class Shape {
    public static void main(String args[]){

        for(int i=0;i<7;i++){
            if(i%2==0) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
