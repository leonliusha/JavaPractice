/**
 * Created by Administrator on 2015/8/26.
 */
public class BiggestCommonDivisionNumber {

    public static void f(int big, int small){
        int remain = big % small;
        if(remain == 0)
            System.out.println(small);
        else
            f(small,remain);
    }

    public static void main(String args[]){
        f(407,222);
    }
}
