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
//        // �̳߳�
//        ExecutorService exec = Executors.newCachedThreadPool();
//        // ֻ��5���߳�ͬʱ����
//        final Semaphore semp = new Semaphore(5);
//        // ģ��20���ͻ��˷���
//        for (int index = 0; index < 20; index++) {
//            final int NO = index;
//            Runnable run = new Runnable() {
//                public void run() {
//                    try {
//                        // ��ȡ���
//                        semp.acquire();
//                        System.out.println("Accessing: " + NO);
//                        Thread.sleep((long) (Math.random() * 10000));
//                        // ��������ͷ� ����������������䣬���ڿ���ֻ̨�ܴ�ӡ5����¼��֮���߳�һֱ����
//                        semp.release();
//                    } catch (InterruptedException e) {
//                    }
//                }
//            };
//            exec.execute(run);
//        }
//        // �˳��̳߳�
//        exec.shutdown();
//    }
}
