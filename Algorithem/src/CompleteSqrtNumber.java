/**
 * Created by Administrator on 2015/8/29.
 */
public class CompleteSqrtNumber {
    public static void main(String args[]){
        for(int i=1;i<100000;i++){
            //CompleteSqrtNumber is an Integer after MAth.sqrt(n)
            //so, if x = Math.sqrt(n) and x%1=0; then this N is a Complete Sqrt Number
            if(Math.sqrt(i+100)%1 == 0){
                if(Math.sqrt(i+268)%1 == 0){
                    System.out.println(i +"加100是个完全平方数，加168又是一个平方数");
                    System.out.println("Math.sqrt("+25+"+100)%1 is :"+Math.sqrt(25+100)%1);
                    System.out.println(15.5%1);
                }
            }
        }
    }
}
