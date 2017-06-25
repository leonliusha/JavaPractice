/**
 * Created by Administrator on 2017/6/25.
 */

abstract class BB{
    private String str;
//    public BB(String str){
//        System.out.println("the abstract B class has been Instantiated");
//        this.str = str;
//        System.out.println("the Str is:"+str);
//    }
    public abstract void play();
}
public class InstanceAbstrctClass extends BB{
    public InstanceAbstrctClass(String a){
        //super(a);
        System.out.println("subclass has been instantiated");
    }
    @Override
    public void play(){
        System.out.println("instantiating subclass has to instantiate super class. this is how to instantiate abstract");
    }

    public static void main(String args[]){
        BB ab = new InstanceAbstrctClass("hello");
    }

}
