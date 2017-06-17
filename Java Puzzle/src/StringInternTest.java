/**
 * Created by Administrator on 2015/8/26.
 */
public class StringInternTest {
    public static void main(String args[])
    {
        String a = "b";
        String b = "b";
        System.out.println(a==b);
        String c = new String("b");
        System.out.println(a==c);
        String d = new String("b");
        System.out.println(c==d);
        String e = "b";
        //当调用inter()方法是，如果常量池中已经包含了一个等于此String对象的字符串（用equals(Object）来判断），
        //则返回池中字符串。否则将此string对象添加到常量池中，并且返回
        String f = new String("b").intern();  //new String("b")被放进了方法区内的常量池中
        System.out.println(e==f);
        String g = new String("b").intern();
        String h = new String("b");
        System.out.println(g==h);
        System.out.println(f==g);

    }
}
