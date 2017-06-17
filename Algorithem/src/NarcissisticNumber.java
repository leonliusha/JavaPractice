/**
 * Created by Administrator on 2015/8/26.
 */
public class NarcissisticNumber {

    public static int lengthOfNumber(int number){
        int length = 0;
        do{
            if(number > 0) {
                number = number / 10;
                length++;
            }
        }while(number != 0);
        return length;
    }

    public static int[] getDigits(int number,int length){
        int[] digits = new int[length];
        for(int i=length-1;i>=0;i--){
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    public static int calculate(int digit, int length){
        int result = 1;
        if(length == 1)
            return digit;
        else {
            for (int i = 0; i < length; i++) {
                result = result * digit;
            }
            return result;
        }
    }

    public static int calculate2(int digit, int length) {
        return (int)Math.pow(digit,length);
    }

    public static void main (String args[]){
        for (int i = 1; i < 500; i++){
            int result = 0;
            int length = lengthOfNumber(i);
            int[] digits = getDigits(i,length);
            for(int index=0;index<length;index++){
               result =  result + calculate2(digits[index],length);
            }
            if(result == i)
                System.out.println(i);
        }


    }


}
