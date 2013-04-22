package net.diegozhu.java.game.hero;
public class AnimationThread implements Runnable{

	private Map mp;
	public AnimationThread(Map m){
		this.mp = m;
	}
	@Override
	public void run() {
		while(true){
			try {
				mp.repaint();
				Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
					}
			}
	}
		
	

	
}
