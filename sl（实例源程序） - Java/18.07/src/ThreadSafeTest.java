public class ThreadSafeTest implements Runnable {
	int num = 10; // 设置当前总票数
	
	public void run() {
		while (true) {
			if (num > 0) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("tickets" + num--);
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadSafeTest t = new ThreadSafeTest(); // 实例化类对象
		Thread tA = new Thread(t); // 以该类对象分别实例化4个线程
		Thread tB = new Thread(t);
		Thread tC = new Thread(t);
		Thread tD = new Thread(t);
		tA.start(); // 分别启动线程
		tB.start();
		tC.start();
		tD.start();
	}
}
