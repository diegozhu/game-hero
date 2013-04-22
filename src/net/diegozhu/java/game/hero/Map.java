package net.diegozhu.java.game.hero;

import java.awt.*;
import java.util.Random;
import javax.swing.JPanel;

public class Map extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2917227537706901033L;
	private int ROW = 22;
	private int COL = 48;
	public Hero h1;
	private Random rand = new Random();
	public static final int CS = 32;
	public Point[][] map;
	// 窗体的宽与高
	private static int WIDTH = 1366;
	private static int HEIGHT = 768;
	private Thread threadAnime;

	public Map() {
		map = new Point[ROW][COL];
		this.init();
	}

	public Map(int row, int col) {
		this.ROW = row;
		this.COL = col;
		Map.WIDTH = this.COL * Map.CS;
		Map.HEIGHT = this.ROW * Map.CS;
		map = new Point[ROW][COL];
		this.init();
	}

	public void init() {
		// 随机初始化map数组
		for (int i = 1; i < ROW - 1; i++) {
			for (int j = 1; j < COL - 1; j++)
				map[i][j] = new Point(rand.nextInt(Point.MAX - 1), i, j);
		}
		// 左右两列用墙包裹
		for (int i = 0; i < ROW; i++) {
			map[i][0] = new Point(Point.WALL, i, 0);
			map[i][COL - 1] = new Point(Point.WALL, i, COL - 1);
		}
		// 上下两列用墙包裹
		for (int i = 0; i < COL; i++) {
			map[0][i] = new Point(Point.WALL, 0, i);
			map[ROW - 1][i] = new Point(Point.WALL, ROW - 1, i);
		}
		// 随机确定结束点
		map[rand.nextInt(ROW - 2) + 1][rand.nextInt(COL - 2) + 1]
				.setType(Point.FINISH_POINT);
		// 找到随机数个闲置空间，设为起始点。
		cont: for (int i = 1, n = rand.nextInt(5); i < ROW - 1; i++) {
			for (int j = 1; j < COL - 1; j++)
				if (map[i][j].isFloor() && (--n < 0)) {
					h1 = new Hero(i, j);
					map[i][j].setObj(h1);
					map[i][j].setType(Point.START_POINT);
					break cont;
				}
		}

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++)
				System.out.print("  " + map[i][j].getType());
			System.out.println("");
		}
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		addKeyListener(new actionListener(this));
		// 实例化内部线程AnimationThread
		threadAnime = new Thread(new AnimationThread(this));
		// 启动线程
		threadAnime.start();
	}

	public void paint(Graphics g) {
		this.drawBg(g);
		this.drawObj(g);
	}

	// 画人物
	public void drawObj(Graphics g) {
		g.drawImage(h1.getImage(), h1.getY() * CS, h1.getX() * CS, this);
	}

	// 画背景
	public void drawBg(Graphics g) {
		for (int i = 0; i < ROW; i++)
			for (int j = 0; j < COL; j++)
				g.drawImage(map[i][j].getImage(), j * CS, i * CS, this);
	}

}
