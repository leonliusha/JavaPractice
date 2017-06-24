package Practise;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyTesting {
	private int currentEvenValue=0;
	private Lock lock = new ReentrantLock();
	public int next(){
		lock.lock();
		try{
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		}
		finally{
			lock.unlock();
		}
	}
	
	public void untimed(){
		boolean captured = lock.tryLock();
		try{
			System.out.println("trylock() "+captured);
		}finally{
			if(captured)
				lock.unlock();
		}
	}
	
	public void timed(){
		boolean captured = false;
		try{
			try {
				captured = lock.tryLock(2, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("trylock(2,TimeUnit.SECONDS) "+captured);
		}finally{
			if(captured)
				lock.unlock();
		}
	}
	
	class MyExceptionHandler implements Thread.UncaughtExceptionHandler{

		@Override
		public void uncaughtException(Thread t, Throwable e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class MyThreadFactory implements ThreadFactory{
		public Thread newThread(Runnable r){
			Thread t = new Thread();
			t.setUncaughtExceptionHandler(new MyExceptionHandler());
			return t;
		}
		
	}
	
	public static void main(String args[]){
		ConcurrencyTesting ct = new ConcurrencyTesting();
		Thread t = new Thread();
		Arrays.asList("a b c d e".split(" "));
		ExecutorService es = Executors.newCachedThreadPool(ct.new MyThreadFactory());
	}
}
