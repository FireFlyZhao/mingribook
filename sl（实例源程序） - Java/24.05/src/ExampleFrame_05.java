import static javax.swing.SpringLayout.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class ExampleFrame_05 extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		ExampleFrame_05 frame = new ExampleFrame_05();
		frame.setVisible(true);
	}
	
	public ExampleFrame_05() {
		super();
		setTitle("使用弹簧和支柱");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		Spring vST = Spring.constant(20);// 创建一个支柱
		Spring hSP = Spring.constant(20, 100, 500);// 创建一个弹簧
		
		JButton lButton = new JButton("按钮L");
		getContentPane().add(lButton);
		springLayout.putConstraint(NORTH, lButton, vST, NORTH,
				getContentPane());// “按钮L”北侧——>容器北侧
		springLayout.putConstraint(WEST, lButton, hSP, WEST,
				getContentPane());// “按钮L”西侧——>容器西侧
		
		JButton rButton = new JButton("按钮R");
		getContentPane().add(rButton);
		// “按钮R”北侧——>“按钮R”北侧
		springLayout.putConstraint(NORTH, rButton, 0, NORTH, lButton);
		springLayout.putConstraint(WEST, rButton, Spring.scale(hSP, 2),
				EAST, lButton);// “按钮R”西侧——>“按钮L”东侧
		// 容器东侧——>“按钮R”东侧
		springLayout.putConstraint(EAST, getContentPane(), hSP, EAST,
				rButton);
	}
	
}
