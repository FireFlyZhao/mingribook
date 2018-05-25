package keyListener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputKeyListener extends KeyAdapter {// 输入键监听类继承键盘事件
	public void keyTyped(KeyEvent e) {
		String key="-0123456789"+(char)8;// 定义通过键盘可以输入的按键
		if(key.indexOf(e.getKeyChar())<0){// 当前按下的按键没在key列表里
			e.consume();// 销毁当前没在key列表里的按键
		}
	}
}