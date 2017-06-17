/**
 * Created by Administrator on 2015/8/27.
 */
public class SelectionSort {
    public static int[] sort(int[] numbers){
        int temp,k=0;
        for(int i=0;i<numbers.length-1;i++){
            int min = numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                if(min > numbers[j]){
                    min = numbers[j];
                    k = j;
                }
            }
            temp = numbers[i];
            numbers[i] = min;
            numbers[k] = temp;

        }
        return numbers;
    }

    public static void main(String args[]){
        int[] numbers = {3,9,2,26,10,56,23,16,24,31};
        int[] result = sort(numbers);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}
