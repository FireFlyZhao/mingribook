package com.lzw;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FrameDraw extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public static void main(String args[]) {
		try {
			FrameDraw frame = new FrameDraw();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public FrameDraw() {
		super();
		setBounds(100, 100, 269, 185);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(getPanel(), BorderLayout.CENTER);
		//
	}
	protected JPanel getPanel() {
		if (panel == null) {
			panel = new DrawPanel();
		}
		return panel;
	}

}
