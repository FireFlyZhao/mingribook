import java.awt.*;
import java.awt.print.PageFormat;

import javax.swing.*;

/**
 * 
 */

public class MyCanvas extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private PageFormat pf;
	private Image img;

	public MyCanvas(PageFormat pf, Image img) {
		this.pf=pf;
		this.img=img;
		setPreferredSize(new Dimension((int) pf.getWidth() + 40, (int) pf
				.getHeight() + 80));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO 自动生成方法存根
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(20, 40);
		int x = (int) (pf.getImageableX() - 1);
		int y = (int) (pf.getImageableY() - 1);
		int width = (int) (pf.getImageableWidth() + 1);
		int height = (int) (pf.getImageableHeight() + 1);
		int mw = (int) pf.getWidth();
		int mh = (int) pf.getHeight();
		g2.drawImage(img, x + 1, y + 1, this); // 绘制图像
		g2.drawRect(0, 0, mw, mh);
		g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND, 10f, new float[]{5, 5}, 0f));
		g2.drawRect(x, y, width, height);
	}
}