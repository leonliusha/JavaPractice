import java.util.HashMap;

/**
 * Created by Administrator on 2015/9/1.
 */
public class AutoBoxing {
    public static void main(String args[]){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer cc = new Integer(22);
        Integer dd = new Integer(22);
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Integer h = -127;
        Integer h2 = -127;
        Integer h3 = 128;
        Integer h4 = 128;
        Integer h5 = 127;
        Integer h6 = 127;

        // the auto boxing would not happen until math operation happened.
        //Java will put -127 to 127 in the Constant Value Pool.
        System.out.println(c == d);
        System.out.println("cc == dd is "+(cc == dd));
        System.out.println(e == f);
        System.out.println(h == h2);
        System.out.println("h3 == h4 is "+(h3 == h4));
        System.out.println(h5 == h6);

        //the auto boxing will happen until the math operation happened.
        System.out.println(c == (a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g == (a+b));
        System.out.println(3L == 3);
        System.out.println(g.equals(a+b));
        System.out.println(30L == 30);
    }


}
