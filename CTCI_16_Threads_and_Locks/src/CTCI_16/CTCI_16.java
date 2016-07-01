package CTCI_16;

/** Threads and Locks
 * Threads can be implemented in two ways:
 * 	1. Implementing the java.lang.Runnable interface
 * 	2. Extending the java.lang.Thread class
 * 
 * Runnable may be preferred because:
 * 	- No multiple inheritance in Java so using Runnable allows you to extend from another class
 * 	- A class might only be interested in being runnable, and therefore, inheriting the full 
 * 	overhead of the Thread class would be excessive
 */
public class CTCI_16 {

	
	public void startRunnableThread() {
		SimpleRunnable runnableThread = new SimpleRunnable();

		Thread thread = new Thread(runnableThread);
		thread.start();
	
		
		/* waits until above thread counts to 5 (slowly) */
		while (runnableThread.count != 5) {
			try {
				System.out.print("In startRunnableThread");
				Thread.sleep(250);
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
	
	public void startSimpleThread() {
		
		SimpleThread simpleThread = new SimpleThread();
		simpleThread.start();
		
		while (simpleThread.count != 5) {
			try {
				Thread.sleep(250);
				System.out.println("In startSimpleThread");
			} catch (InterruptedException exc) {
				exc.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CTCI_16 m = new CTCI_16();
		Thread t1 = new Thread() {
			public void run() {
				m.startSimpleThread();
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				m.startRunnableThread();
			}
		};
		t1.start();
		t2.start();
	}

}
