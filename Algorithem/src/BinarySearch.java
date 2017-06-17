import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/29.
 */
public class BinarySearch {
    public static void main(String args[]){
        int[] array = new int[]{1,2,3,4,9,10,34,45,54};
        System.out.print("enter a number for searching: ");
        Scanner scanner = new Scanner(System.in);
        int search = scanner.nextInt();
        boolean found = false;

        int start=0,end=array.length-1,n=-1;
        if(search>=array[0]&&search<=array[array.length-1]) {
            while (n != start && n != end) {
                if(search == array[start]){
                    found = true;
                    n = start;
                    break;
                }else if(search == array[end]){
                    found = true;
                    n = end;
                    break;
                }
                n = (start + end) / 2;
                if (search < array[n]) {
                    end = n;
                } else if (search > array[n]) {
                    start = n;
                } else if (search == array[n]) {
                    found = true;
                    break;
                }
                n = -1;
            }
        }
        if(found){
            System.out.println("Found! at index "+n);
        }
        else
            System.out.println("Sorry!");

    }
}
