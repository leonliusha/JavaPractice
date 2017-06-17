import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/8/25.
 */
public class CallableAndRunnable {

    public class TaskWithResult implements Callable<String> {
        private int id;
        public TaskWithResult(int id){
            this.id = id;
        }

        public String call(){
            return "result of TaskWithResult is: "+id;
        }

    }

    public static void main (String args[]){
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.shutdown();
    }
}
