import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/29.
 */
public class CompleteNumber {
    public static void main(String args[]){
        System.out.println("please enter a number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        completeNumber(number);
        LinkedList ll = new LinkedList();
        ArrayList ls = new ArrayList();
        Class c = BubbleSort.class;
        c.getProtectionDomain().getCodeSource().getLocation();

    }

    public static void completeNumber(int number){
        System.out.println("the complete number in the range of 0 to " + number + "is following: ");
        for(int i=1;i<number;i++){
            int sum = 0;
            for(int j=1;j<=i/2;j++){
                if(i%j==0){
                    sum = sum + j;
                }
            }
            if(sum == i){
                System.out.println(i);
            }
        }
    }
}
