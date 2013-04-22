package net.diegozhu.java.game.hero;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Point {

	public static final int FLOOR = 0;
	public static final int WALL = 1;
	public static final int START_POINT = 5;
	public static final int FINISH_POINT = 6;
	public static final int MAX = 4;

	private int x;
	private int y;
	private int type;
	private int Obj_type;
	private Image BGimage; // 具有填充效果的图片

	public Point(int type, int x, int y) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.Obj_type = Obj.NULL;
		this.setImage(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
		this.setImage(type);
	}

	public boolean isFloor() {
		return (this.type == Point.FLOOR) ? true : false;
	}

	public boolean canBeMoveHere(Role rl) {
		if (this.type == Point.FINISH_POINT) { // 抵达终点。退出程序
			System.out.println("finish job!" + "\n steps:" + rl.getSteps());
			System.exit(0);
		}
		return (this.Obj_type == Obj.NULL) && (this.type != Point.WALL) ? true : false;
	}

	public void setObj(Obj obj) {
		this.Obj_type = obj.getType();
	}

	public Image getImage() {
		return this.BGimage;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	private void setImage(int type) {
		try {
			ImageIcon imageIcon;
			switch (type) {
			case Point.FLOOR:
				imageIcon = new ImageIcon(
						Point.class.getResource("images/floor.gif"));
				BGimage = imageIcon.getImage();
				break;
			case Point.WALL:
				imageIcon = new ImageIcon(
						Point.class.getResource("images/wall.gif"));
				BGimage = imageIcon.getImage();
				break;
			case Point.START_POINT:
				imageIcon = new ImageIcon(
						Point.class.getResource("images/start_point.gif"));
				BGimage = imageIcon.getImage();
				break;
			case Point.FINISH_POINT:
				imageIcon = new ImageIcon(
						Point.class.getResource("images/finish_point.gif"));
				BGimage = imageIcon.getImage();
				break;
			default:
				imageIcon = new ImageIcon(
						Point.class.getResource("images/floor.gif"));
				BGimage = imageIcon.getImage();
				break;
			}
		} catch (NullPointerException e) {
			System.out.println("can not find picture:" + e.getMessage());
		}
	}
}
