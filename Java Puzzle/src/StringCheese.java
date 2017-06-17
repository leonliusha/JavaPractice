import java.lang.reflect.Field;

/**
 * Created by Administrator on 2015/9/16.
 */
public class StringCheese {
    public static void main(String args[]) throws Exception{
       Field field = String.class.getDeclaredField("value");
       field.setAccessible(true);
        field.set("hello!","cheers".toCharArray());
        System.out.println("hello!");
    }
}
