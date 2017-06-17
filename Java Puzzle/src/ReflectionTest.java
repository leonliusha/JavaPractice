import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/9/8.
 */
public class ReflectionTest {
    public static void main(String args[]) throws Exception{
        A a = new A();
        Method aMethod = a.getClass().getDeclaredMethod("a");
        aMethod.setAccessible(true);
        aMethod.invoke(a);
        List<Integer> list = new ArrayList<>();
    }
}

class A{
    private void a(){
        System.out.println("this is a private method a ");
    }
}
