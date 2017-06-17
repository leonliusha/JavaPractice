/**
 * Created by Administrator on 2015/8/27.
 */
public class InsertionSort {
    public static int[] sort(int[] numbers){
        int i,j;
        for(i=1;i<numbers.length;i++){
            int temp = numbers[i];
            j = i;
            while(j > 0 && numbers[j-1] >= temp){
                numbers[j] = numbers[j-1];
                --j;
            }
            numbers[j] = temp;
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
