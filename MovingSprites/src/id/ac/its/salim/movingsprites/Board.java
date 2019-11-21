package id.ac.its.salim.movingsprites;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	private final int ICRAFT_X = 40;
	private final int ICRAFT_Y = 60;
	
	private Timer timer;
	private Spaceship spaceShip;
	private final int DELAY = 10;
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
		addKeyListener(new TAdapter());
		setBackground(Color.black);
		setFocusable(true);
		
		spaceShip = new Spaceship(ICRAFT_X,ICRAFT_Y);
		
		timer = new Timer(DELAY,this);
		timer.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(spaceShip.getImage(),spaceShip.getX(),spaceShip.getY(),this);
		List<Missile> missiles = spaceShip.getMissiles();
		
		for(Missile missile : missiles) {
			g2d.drawImage(missile.getImage(), missile.getX(), missile.getY(), this);
		}
	}
	
	private class TAdapter extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			spaceShip.keyReleased(e);
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			spaceShip.keyPressed(e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
//		step();
		updateMissiles();
		updateSpaceShip();
		
		repaint();
	}
	
	private void updateMissiles() {
		List<Missile> missiles = spaceShip.getMissiles();
		
		for(int i = 0;i<missiles.size();i++) {
			Missile missile = missiles.get(i);
			if(missile.isVisible()) {
				missile.move();
			}
			else {
				missiles.remove(i);
			}
		}
	}
	
	private void updateSpaceShip() {
		spaceShip.move();
		repaint(spaceShip.getX()-1,spaceShip.getY()-1,spaceShip.getWidth()+2,spaceShip.getHeight()+2);
	}
//	
//	private void step() {
//		spaceShip.move();
//		repaint(spaceShip.getX()-1,spaceShip.getY()-1,spaceShip.getWidth()+2,spaceShip.getHeight()+2);
//	}

}
