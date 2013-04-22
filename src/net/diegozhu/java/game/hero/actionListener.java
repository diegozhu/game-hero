package net.diegozhu.java.game.hero;

import java.awt.event.*;

public class actionListener implements KeyListener, WindowListener,
		MouseListener {

	Map mp;

	public actionListener(Map mp) {
		this.mp = mp;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch (arg0.getKeyCode()) {
		case inc.left:
			System.out.println("(" + mp.h1.getX() + "," + (mp.h1.getY() - 1)
					+ ")");
			if (mp.map[mp.h1.getX()][mp.h1.getY() - 1].canBeMoveHere(mp.h1))
				mp.h1.mvLeft();
			break;
		case inc.right:
			System.out.println("(" + mp.h1.getX() + "," + (mp.h1.getY() + 1)
					+ ")");
			if (mp.map[mp.h1.getX()][mp.h1.getY() + 1].canBeMoveHere(mp.h1))
				mp.h1.mvRight();
			break;
		case inc.up:
			System.out.println("(" + (mp.h1.getX() + 1) + "," + mp.h1.getY()
					+ ")");
			if (mp.map[mp.h1.getX() + 1][mp.h1.getY()].canBeMoveHere(mp.h1))
				mp.h1.mvUp();
			break;
		case inc.down:
			System.out.println("(" + (mp.h1.getX() - 1) + "," + mp.h1.getY()
					+ ")");
			if (mp.map[mp.h1.getX() - 1][mp.h1.getY()].canBeMoveHere(mp.h1))
				mp.h1.mvDown();
			break;
		default:
			break;
		}
		mp.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
