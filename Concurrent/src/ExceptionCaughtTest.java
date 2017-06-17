import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2015/9/2.
 */
public class ExceptionCaughtTest{

    public static void main(String arg[]){
        ExecutorService executor = Executors.newCachedThreadPool(new HandlerThreadFactory());
        System.out.println("after ExecutorService instance initiation");
        executor.execute(new ExceptionThread2());
        executor.shutdown();

    }
}

class ExceptionThread2 implements Runnable{
    public void run(){
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
    public void uncaughtException(Thread t,Throwable e){
        System.out.println("caught: "+e);
    }
}

class HandlerThreadFactory implements ThreadFactory{
    public Thread newThread(Runnable r){
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        return t;
    }
}