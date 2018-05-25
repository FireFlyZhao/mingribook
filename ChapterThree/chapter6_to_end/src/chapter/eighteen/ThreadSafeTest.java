package chapter.eighteen;

public class ThreadSafeTest implements Runnable{
	int num = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadSafeTest t = new ThreadSafeTest();
		ThreadSafeTest t2 = new ThreadSafeTest();
		Thread tA = new Thread(t);
		Thread tB = new Thread(t);
		Thread tC = new Thread(t);
		Thread tD = new Thread(t);
		tA.start(); 
		tB.start();
		tC.start();
		tD.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			synchronized ("") {
				if (num > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("tickets" + num--);
				}else {
					break;
				}
			}
			
		}
	}
	
	
	
}
