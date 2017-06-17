import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/29.
 */
public class CheckNumberLength {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a number : ");
        int number = scanner.nextInt();
        char[] ch = Integer.toString(number).toCharArray();
        int numLength = ch.length;
        System.out.println("the length of number is: "+numLength);
        for(int i=numLength-1;i>=0;i--){
            System.out.print(ch[i]+" ");
        }
    }
}
