/**
 * Created by Administrator on 2015/8/27.
 */
public class BubbleSort {
    public static int[] sort(int[] numbers){
        for(int i=0;i<numbers.length;i++){
           for(int j=0;j<numbers.length-i-1;j++){
               if(numbers[j+1]<numbers[j]){
                   int temp = numbers[j];
                   numbers[j] = numbers[j+1];
                   numbers[j+1] = temp;
               }
           }
        }
        return numbers;
    }

    public static void main(String args[]){
        int[] numbers = {3,9,2,6,10,56,23,16,13,31};
        int[] result = sort(numbers);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
