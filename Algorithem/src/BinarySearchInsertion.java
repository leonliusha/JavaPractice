import java.util.Scanner;

/**
 * Created by Administrator on 2015/8/30.
 */
public class BinarySearchInsertion {
    static int[] sorted = new int[]{1,6,16,20,22,26,30,33,35,36,40,44,45,47,49,53,55,57,60,61,66,68,70,72,75,78,80,83,87,90,94,96,99};
    static int[] newArr = new int[sorted.length+1];
    public static void main(String args[]){
        System.out.print("please enter a number for insertion: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        searchInsertion(number);
    }

    static void searchInsertion(int number){
        int start=0, end=sorted.length-1,mid;
            if(number >=sorted[end]) {
                newArr[newArr.length - 1] = number;
                copy(newArr.length-1);
            }
            else if(number <= sorted[start]) {
                newArr[0] = number;
                copy(0);
            }
            else{
                while(start < end){
                    mid = (start + end) / 2;
                    if(number == sorted[mid]){
                        newArr[mid] = number;
                        copy(mid);
                    }else if(number < sorted[mid] && number >= sorted[mid-1]){
                        newArr[mid-1] = number;
                        copy(mid-1);
                    }else if(number > sorted[mid] && number <= sorted[mid+1]){
                        newArr[mid+1] = number;
                        copy(mid+1);
                    }
                }
            }
    }
    public static void copy(int index){
        int i ,j = 0;
        for(i=0;i<sorted.length;i++,j++){
            if(index == i && index == j){
                j = j + 1;
            }
            newArr[j] = sorted[i];

        }
    }
}
