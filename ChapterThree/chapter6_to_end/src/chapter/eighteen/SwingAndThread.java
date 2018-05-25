package chapter.eighteen;

import java.awt.*;
import java.net.*;

import javax.swing.*;

public class SwingAndThread extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel jl = new JLabel();
	private static Thread t;
	private int count = 0;
	private Container container = getContentPane();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAndThread();
	}
	
	
	public SwingAndThread() {
		setBounds(300, 200, 250, 100);
		container.setLayout(null);
		URL url = SwingAndThread.class.getResource("1.gif");
		Icon icon = new ImageIcon(url);
		jl.setIcon(icon);
		jl.setHorizontalAlignment(SwingConstants.LEFT);
		jl.setBounds(10, 10, 200, 50);
//		jl.setOpaque(false);
		t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (count <=200) {
					jl.setBounds(count, 10, 200, 50);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count += 4;
					if (count == 200) {
						count = 10;
					}
				}
			}
		});
		t.start();
		container.add(jl);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
