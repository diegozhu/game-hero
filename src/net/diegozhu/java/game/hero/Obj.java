package net.diegozhu.java.game.hero;

import java.awt.Image;

public class Obj {

	protected int x;
	protected int y;
	private int type;
	private Image image;
	public static final int NULL = 0;
	public static final int ROLE = 1;

	public Obj(int type, int x, int y) {
		this.x = x;
		this.y = y;
		this.setImage(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isFloor() {
		return (this.type == 0) ? true : false;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Image getImage() {
		return this.image;
	}

	private void setImage(int type) {
	}
}
