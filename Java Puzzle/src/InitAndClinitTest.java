/**
 * Created by Administrator on 2015/9/1.
 */
public class InitAndClinitTest {
    //all static field and static block will be collected into an method called <clinit>,
    //which is added into class file when the class get compiled.
    //the <clinit> will be called when
    //1:when static filed are called
    //2:when main method called, the main method owner's <clinit> called
    static int y = 2;
    int yy = 3;

    byte b = 127;

    static {
        System.out.println("InitAndClinitTest y ="+y);
    }
    {
        ++y;
    }
    InitAndClinitTest(){
        System.out.println("InitAndClinit constructor y="+y);
    }

    public static void main(String args[]){
       // new InitAndClinitTest();
        //new Test2();
       // new Test2();
       new Test();
       System.out.println();
       new Test("ssssss");

    }
}
class Test extends InitAndClinitTest{
    static int x = 1;
    static String s = "123";
    static{
        if(s.equals("123"))
            s = "345";
        if(x == 1)
            x = 2;
    }
    {
        System.out.println("<init>");
        if(s.equals("345"))
            s = "678";
        if(x ==2 )
            x = 3;
        ++x;
    }
    public Test(){
        System.out.println(x);
        System.out.println(s);
    }

    public Test(String ss){
        System.out.println(x);
        System.out.println(s);
    }
}

class Test2 extends InitAndClinitTest{

}
