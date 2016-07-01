package CTCI_16;

public class SimpleRunnable implements Runnable {

	public int count = 0;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RunnableThread starting.");
		try {
			while (count < 5) {
				System.out.println("In simpleRunnable");
				Thread.sleep(500);
				count++;
			}
		} catch (InterruptedException exc) {
			System.out.println("RunnableThread interrupted.");
		}
		System.out.println("RunnableThread terminating.");
	}

}