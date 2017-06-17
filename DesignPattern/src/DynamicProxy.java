import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2015/8/29.
 */
public class DynamicProxy{
    public static void main(String args[]){
        Singer Rihanna = new Rihanna();
        Singer rihannaAgent = (Singer)Proxy.newProxyInstance(Rihanna.getClass().getClassLoader(),
                                                    Rihanna.getClass().getInterfaces(),
                                                    new AgentJob(Rihanna));
        rihannaAgent.Sing();
    }




}
