package java.threadd;

//There are two threads, t1 and t2 should print numbers alternatively
//Example - t1 -1, t2 -2, t1-3, t2-4 and so on.
public class PriceLine_Problem {
	
	private static Object lock = new Object();
	private static int counter = 0;
	
	
	public static void main(String[] args) throws InterruptedException {
		int n = 20;
		
		Runnable r = () -> {
			for(int i=0 ; i< n ; i++) {
				synchronized (lock) {
					 System.out.println(counter++ + "--" + Thread.currentThread().getName());
					 lock.notify();
					 try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();

		t1.join();
		t2.join();
	
		}
}
