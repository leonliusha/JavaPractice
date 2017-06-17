import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/29.
 */
public class ChecckNumberLength2 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a number : ");
        int number = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        while(number!=0){
            list.add(number % 10);
            number = number / 10;
        }
        System.out.println("the length of number is: "+list.size());
        for(int i : list){
            System.out.print(i);
        }
    }
}
