import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/29.
 */
public class CycleNumber {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a number: ");
        int number = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        while(number!=0){
            arr.add(number % 10);
            number = number / 10;
        }
        int i=0, j=arr.size();
        boolean found = true;
       while(i<j/2 && found){
           if(arr.get(i) != arr.get(j-1-i)){
               found = false;
           }
           ++i;
       }
        System.out.println("The number is Cycle number is: "+found);

    }
}
