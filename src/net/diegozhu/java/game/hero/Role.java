package net.diegozhu.java.game.hero;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Role extends Obj {

	public static final int NULL = 0;
	public static final int HERO = 1;
	public static final int PRINCESS = 2;
	public static final int OLDMAN = 3;
	private int steps = 0;
	private Image image;
	private int type;

	public Role(int type, int x, int y) {
		super(Obj.ROLE, x, y);
		this.type = type;
		this.setImage(type);
	}

	public int getSteps() {
		return this.steps;
	}

	public Image getImage() {
		return this.image;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void mvUp() {
		this.x++;
		this.steps++;
	}

	public void mvDown() {
		this.x--;
		this.steps++;
	}

	public void mvLeft() {
		this.y--;
		this.steps++;
	}

	public void mvRight() {
		this.y++;
		this.steps++;
	}

	public void flyTo() {
	}

	private void setImage(int type) {
		try {
			switch (type) {
			case Role.HERO:
				image = new ImageIcon(
						Point.class.getResource("../../../../../images/hero.png")).getImage();
				break;
			case Role.PRINCESS:
				image = new ImageIcon(
						Point.class.getResource("../../../../../images/princess.png")).getImage();
				break;
			case Role.OLDMAN:
				image = new ImageIcon(
						Point.class.getResource("../../../../../images/oldman.png")).getImage();
				break;
			default:
				break;
			}
		} catch (NullPointerException e) {
			System.out.println("can not find picture:" + e.getMessage());
		}
	}
}
