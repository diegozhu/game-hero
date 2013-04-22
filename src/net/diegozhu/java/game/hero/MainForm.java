package net.diegozhu.java.game.hero;

import java.awt.*;
import javax.swing.JFrame;

public class MainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3377447825571888240L;

	public MainForm(int height, int width) {
		map = new Map((int) (height - 100) / Map.CS, (int) (width - 100) / Map.CS);
		Container contain = getContentPane();
		contain.add(map);
		pack();
	}

	private Map map;

	public static void main(String args[]) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int a, b;
		a = screenSize.width;
		b = screenSize.height;

		System.out.println(a + " " + b);
		final MainForm m1 = new MainForm(screenSize.height, screenSize.width);

		m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m1.setVisible(true);

		// 居中显示
		Dimension size = m1.getSize();
		int x = (screenSize.width - size.width) / 2;
		int y = (screenSize.height - size.height) / 2;
		m1.setLocation(x, y);
	}
}
