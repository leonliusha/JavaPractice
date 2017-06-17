import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2015/9/17.
 */
public class ThreadTest {
    public static int j;
    public static int number;
    public static void main(String args[]){
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0;i<2;i++){
            service.execute(new increase(number++));
            service.execute(new decrease(number++));
        }
    }
}

class increase implements Runnable{
    private int count = 0;
    private int number;
    public increase(int number){
        this.number = number;
    }
    private void inc(){
        ThreadTest.j = ThreadTest.j + 1;
        System.out.println("Thread:"+number+" the j is:"+ThreadTest.j);
    }
    public void run(){
        while(count <= 20){
            inc();
            count++;
            try {
                Thread.sleep(200);
            }catch(InterruptedException e ){

            }
        }
    }
}

class decrease implements Runnable{
    private int count = 0;
    private int number;
    public decrease(int number){
        this.number = number;
    }
    private void dec(){
        ThreadTest.j = ThreadTest.j - 1;
        System.out.println("Thread:"+number+" the j is:"+ThreadTest.j);
    }
    public void run(){
        while(count <= 20){
            dec();
            count++;
            try {
                Thread.sleep(200);
            }catch(InterruptedException e ){

            }
        }
    }
}
