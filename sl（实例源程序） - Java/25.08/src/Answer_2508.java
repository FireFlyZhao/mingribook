import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Answer_2508 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField_1;

	private JTextField textField;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2508 frame = new Answer_2508();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Answer_2508() {
		super();
		setTitle("25-8");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JLabel label = new JLabel();
		label.setText("方式一：");
		panel.add(label);

		textField = new JTextField();
		textField.addKeyListener(new KeyListener() {

			int keyCode;

			public void keyPressed(KeyEvent e) {
				keyCode = e.getKeyCode();
			}

			public void keyTyped(KeyEvent e) {
				if (keyCode < KeyEvent.VK_0 || keyCode > KeyEvent.VK_9)
					e.consume();
			}

			public void keyReleased(KeyEvent e) {
			}

		});
		textField.setColumns(20);
		panel.add(textField);

		final JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);

		final JLabel label_1 = new JLabel();
		label_1.setText("方式二：");
		panel_1.add(label_1);

		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {

			String num = "0123456789";

			public void keyTyped(KeyEvent e) {
				if (num.indexOf(e.getKeyChar()) < 0)
					e.consume();
			}

		});
		textField_1.setColumns(20);
		panel_1.add(textField_1);
		//
	}
}
