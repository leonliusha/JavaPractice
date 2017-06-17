import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Created by Administrator on 2015/8/29.
 */
class AgentJob implements InvocationHandler {
    Singer singer;
    public AgentJob(Object singer){
        Objects.requireNonNull(singer);
        this.singer = (Singer)singer;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        System.out.println("Sign the contract");
        result = method.invoke(singer, args);
        System.out.println("Collect money");
        return result;
    }
}
