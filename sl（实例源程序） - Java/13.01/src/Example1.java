import java.awt.*;

import javax.swing.*;

public class Example1 extends JFrame {
	private static final long serialVersionUID = 1L;

// ����һ����̳�JFrame��
	public void CreateJFrame(String title) { // ����һ��CreateJFrame()����
		JFrame jf = new JFrame(title); // ʵ����һ��JFrame����
		Container container = jf.getContentPane(); // ��ȡһ������
		JLabel jl = new JLabel("����һ��JFrame����"); // ����һ��JLabel��ǩ
		// ʹ��ǩ�ϵ����־���
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl); // ����ǩ��ӵ�������
		container.setBackground(Color.white);//���������ı�����ɫ
		jf.setVisible(true); // ʹ�������
		jf.setSize(200, 150); // ���ô����С
		// ���ô���رշ�ʽ
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[]){//���������е���createJFrame()����
		new Example1().CreateJFrame("����һ��JFrame����");
	}
}
