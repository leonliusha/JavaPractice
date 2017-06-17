/**
 * Created by Administrator on 2015/8/29.
 */
public class ThreeDigits {
    public static void main(String args[]){
        int count = 0;
        for(int x=1;x<5;x++){
            for(int y=1;y<5;y++){
                for(int z=1;z<5;z++){
                    if(x!=y && y!=z && x!=z){
                        System.out.println(" "+x+y+z);
                        count++;
                    }
                }
            }
        }
        System.out.println("total count is: "+count);
    }
}
