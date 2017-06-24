package Concurrent;


//this will never print "Goodbye world".because System.exit() method halts the execution of the current thread and all others dead in their tracks.
//When System.exit is called, the virtual machine performs two cleanup tasks before shutting down. 
//First, it executes all shutdown hooks that have been registered with Runtime.addShutdownHook. this is useful to release resources external to VM.
//Use shutdown hooks for behavior that must occur before the VM exits. 
//Second,the VM run the finalizes on all objects that have not yet been finalized when either System.runFinalizersOnExit or Runtime.runFinalizersOnExit has 
//been called. But ,Never call System.runFinalizersOnExit or Runtime.runFinalizersOnExit. They are dangerous.
//Finally, System.exit() stops all program threads immediately, it does not cause finally blocks to execute,but it does run shutdown hooks before halting the VM.
public class HelloGoodbye {
	/*public static void main(String [] args){
		try{
		System.out.println("hello world");
		System.exit(0);
		}finally{
			System.out.println("Goodbye world");
		}
	}*/
	
	
	//this will demonstrate this technique.
	public static void main(String args[]){
		System.out.println("Hello world");
		//register an addShutdownHook() before current VM shut down.
		Runtime.getRuntime().addShutdownHook(
				new Thread(){
					public void run(){
						System.out.println("Goodbye world");
					}
				});
		System.exit(0);
	}
}
