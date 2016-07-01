package CTCI_16;

public class SimpleThread extends Thread {

	public int count = 0;
	
	@Override
	public void run() {
		System.out.println("Thread starting.");
		
		try {
			while (count < 5) {
				Thread.sleep(500);
				System.out.println("In SimpleThread, count is " + count);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("Thread interruptd");
		}
		System.out.println("Thread terminating");
	}
	
}
