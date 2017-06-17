import java.lang.reflect.Field;

/**
 * Created by Administrator on 2015/9/17.
 */
public class IntegerTest {
    public static void main(String args[])throws Exception{
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.set(6,7);
        System.out.printf("2 * 3 = %d\n ", 2 * 3);
    }
}
