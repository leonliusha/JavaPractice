import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/8/26.
 */
public class SemaphoreTest {
    public static void main(String args[]){
        final int THREAD_COUNT = 20;
        final int RESOURCE_COUNT = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(RESOURCE_COUNT,true);
        for(int i=0;i<THREAD_COUNT;i++) {
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "saving data");
                        //TimeUnit.MILLISECONDS.sleep(2000);
                        Thread.sleep((long) (Math.random() * 10000));
                        semaphore.release();
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " has been interrupted");
                    }
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

//    public static void main(String[] args) {
//        // 线程池
//        ExecutorService exec = Executors.newCachedThreadPool();
//        // 只能5个线程同时访问
//        final Semaphore semp = new Semaphore(5);
//        // 模拟20个客户端访问
//        for (int index = 0; index < 20; index++) {
//            final int NO = index;
//            Runnable run = new Runnable() {
//                public void run() {
//                    try {
//                        // 获取许可
//                        semp.acquire();
//                        System.out.println("Accessing: " + NO);
//                        Thread.sleep((long) (Math.random() * 10000));
//                        // 访问完后，释放 ，如果屏蔽下面的语句，则在控制台只能打印5条记录，之后线程一直阻塞
//                        semp.release();
//                    } catch (InterruptedException e) {
//                    }
//                }
//            };
//            exec.execute(run);
//        }
//        // 退出线程池
//        exec.shutdown();
//    }
}
