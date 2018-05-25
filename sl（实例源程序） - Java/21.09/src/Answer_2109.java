import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Answer_2109 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		try {
			Answer_2109 frame = new Answer_2109();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Answer_2109() {
		super();
		setTitle("�ṩ�б������ı��");
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Vector<String> columnNameV = new Vector<>();
		columnNameV.add("����");
		columnNameV.add("Ӫҵ��");// ���һ����Ӫҵ����
		for (int i = 1; i < 21; i++) {
			columnNameV.add("��Ʒ" + i);
		}
		Vector<Vector<Object>> tableValueV = new Vector<>();
		for (int row = 1; row < 31; row++) {
			Vector<Object> rowV = new Vector<>();
			rowV.add(row);
			int sum = 0;// ��Ӫҵ��
			for (int col = 0; col < 20; col++) {
				int value = (int) (Math.random() * 1000);
				rowV.add(value);
				sum += value;// �ۼ���Ӫҵ��
			}
			rowV.insertElementAt(sum, 1);// ������Ӫҵ������
			tableValueV.add(rowV);
		}

		final MFixedColumnTable panel = new MFixedColumnTable(columnNameV,
				tableValueV, 2);// �޸Ĺ̶�������
		getContentPane().add(panel, BorderLayout.CENTER);
		//
	}
}
