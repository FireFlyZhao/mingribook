import java.awt.*;

import javax.swing.*;

public class Answer_2108 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Answer_2108 frame = new Answer_2108();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Answer_2108() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel topPanel = new JPanel();
		getContentPane().add(topPanel, BorderLayout.NORTH);

		final JLabel topLabel = new JLabel();
		topLabel.setText("日期：");
		topPanel.add(topLabel);

		final MDateField topTreeComboBox = new MDateField();
		topPanel.add(topTreeComboBox);

		final JPanel bottomPanel = new JPanel();
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		final JLabel bottomLabel = new JLabel();
		bottomLabel.setText("日期：");
		bottomPanel.add(bottomLabel);

		final MDateField bottomTreeComboBox = new MDateField();
		bottomPanel.add(bottomTreeComboBox);

		final JLabel label = new JLabel();
		label.setText("");
		getContentPane().add(label, BorderLayout.CENTER);
		//
	}

}
