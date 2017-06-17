import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2015/8/26.
 */
public class Restaurant {
    Meal meal;
    WaitPerson waitPerson = new WaitPerson(this);
    Chef chef = new Chef(this);
    ExecutorService executorService = Executors.newCachedThreadPool();
    public Restaurant(){
        executorService.execute(waitPerson);
        executorService.execute(chef);
    }

    public static void main(String args[]){
        new Restaurant();
    }

}

    class Meal{
        private final int orderNum;
        public Meal(int orderNum){
            this.orderNum = orderNum;
        }
        public String toString(){
            return "Meal " + orderNum;
        }
    }

    class WaitPerson implements Runnable{
        private Restaurant restaurant;
        public WaitPerson(Restaurant restaurant){
            this.restaurant = restaurant;
        }
        public void  run(){
            try{
                while(!Thread.interrupted()){  // interrupted by call ExecutorService.shutdownNow();
                    synchronized (this){
                        while(restaurant.meal == null){
                            wait();               // same as this.wait();
                        }
                    }
                    System.out.println("Waitperson got "+restaurant.meal);
                    synchronized (restaurant.chef){
                        restaurant.meal = null;
                        restaurant.chef.notifyAll();
                    }
                }
            }catch(InterruptedException e){
                System.out.println("Waiter has been interrupted");
            }
        }
    }

    class Chef implements Runnable{
        private Restaurant restaurant;
        private int count = 0;
        public Chef(Restaurant restaurant){
            this.restaurant = restaurant;
        }

        public void run(){
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (restaurant.meal != null) {
                            wait();
                        }
                        if(++count == 10){
                            System.out.println("Out of food, closing");
                            restaurant.executorService.shutdownNow();    //this will call interrupt() to all thread created by Executors
                        }
                        System.out.print(count + "order up!!" );
                        synchronized (restaurant.waitPerson){
                            restaurant.meal = new Meal(count);
                            restaurant.waitPerson.notifyAll();
                        }
                        TimeUnit.MILLISECONDS.sleep(2000);
                    }
                }
            }catch(InterruptedException e){
                System.out.println("Chef has been interrupted");
            }
        }
    }


