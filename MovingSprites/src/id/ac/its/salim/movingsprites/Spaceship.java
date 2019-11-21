package id.ac.its.salim.movingsprites;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Spaceship extends Sprite {
	private int dx;
	private int dy;
	private List<Missile> missiles;
	private int x=40;
	private int y=60;
	private int w;
	private int h;
	private Image image;
	
	public Spaceship(int x,int y) {
		super(x,y);
//		loadImage();
		initSpaceShip();
	}
	
	private void initSpaceShip() {
		missiles = new ArrayList<>();
		loadImage("E:/Document/Eclipse-Workspace/MovingSprites/bin/id/ac/its/salim/movingsprites/spesip.png");
		getImageDimension();
	}
	

	
//	private void loadImage() {
//		ImageIcon ii = new ImageIcon();
//		image = ii.getImage();
//		
//		w = image.getWidth(null);
//		h = image.getHeight(null);
//	}
	
	public void move() {
		x+=dx;
		y+=dy;
	}
	public List<Missile> getMissiles(){
		return missiles;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void keyPressed(KeyEvent e) {
		int key =e.getKeyCode();
		
		if(key==KeyEvent.VK_SPACE) {
			fire();
		}
		if(key==KeyEvent.VK_LEFT) {
			dx = -2;
		}

		if(key==KeyEvent.VK_RIGHT) {
			dx = 2;
		}

		if(key==KeyEvent.VK_UP) {
			dy = -2;
		}

		if(key==KeyEvent.VK_DOWN) {
			dy = 2;
		}
	}
	
	public void fire() {
		missiles.add(new Missile(x+width,y+height/2));
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key==KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if(key==KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if(key==KeyEvent.VK_UP) {
			dy = 0;
		}

		if(key==KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
}
