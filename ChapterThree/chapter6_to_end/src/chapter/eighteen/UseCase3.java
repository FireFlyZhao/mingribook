package chapter.eighteen;

public class UseCase3 extends Thread{
	int index = 0;
	String[] str={"Hello","Java","world","study","��ҪѧϰJava����","Java��̴ʵ��ܰ���ѧϰ�������Լ������з�"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UseCase3().start();
	}
	
	public void run() {
		while(true) {
			System.out.println(str[index++%6]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
