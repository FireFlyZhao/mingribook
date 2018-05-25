package com.lzw;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class DrawWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public static void main(String args[]) {
		try {
			DrawWindow frame = new DrawWindow();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public DrawWindow() {
		super();
		setBounds(100, 100, 458, 357);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		//
	}
	protected JPanel getPanel() {
		if (panel == null) {
			panel = new MyPanel();
		}
		return panel;
	}

}
