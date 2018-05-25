package chapter.eighteen;

public class ThreadTest extends Thread{
	private int count = 10;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTest().start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(true) {
			System.out.print(count + " ");
			if(-- count == 0) {
				return;
			}
		}
	}

}
