package sn;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;



public class Gamepanel extends JPanel implements  ActionListener {

	static final int sw = 600;
	static final int sh = 600;
	static final int gameunit = (sw*sh)/25;
	 int[] x = new int[this.gameunit];
	 int[] y = new int[this.gameunit];
	int bodyparts = 6;
	int applescount = 0;
	int applex;
	int appley;
	Timer timer;
	char direction = 'R';
	boolean running = false;
	Random random;
	
	Gamepanel(){
		
		this.random  =new Random();
		super.setPreferredSize(new Dimension(this.sw,this.sh));
		super.setBackground(Color.BLACK);
		super.setFocusable(true);
		super.addKeyListener(new Mykeyadaptor());
	this.startgame();	
	}
	
	public void startgame() {


		this.newapple();
		this.running = true;
		timer = new Timer(75,this);
		timer.start();
		System.out.println("Start called");

	}
	
	private void newapple() {
		
	this.applex = 	this.random.nextInt(this.sw/25)*25;
		this.appley = this.random.nextInt(this.sh/25)*25;
		System.out.println("New apple called");

		
	}

	public void paintComponent(Graphics g) {
		System.out.println("paint component");

		super.paintComponent(g);
		draw(g);
		
	}
	
	
	
	public void draw(Graphics g) {
		System.out.println("draw called");

		for(int i=0;i<this.sh/25;i++) {
			
			g.drawLine(i*25, 0, i*25, this.sh);
			g.drawLine(0, i*25, this.sw, i*25);
	
		}
		
		g.fillOval(this.applex, this.appley, 25, 25);
		for(int i=0;i<this.bodyparts;i++) {
			
			if(i==0) {
				g.setColor(Color.GREEN);
		g.fillRect(x[i], y[i], 25, 25);
			}else {
				g.setColor(Color.BLUE);
				g.fillRect(x[i], y[i], 25, 25);

			}
			
			
		}
		
	}
	
	public void move() {
		
		
		for(int i=this.bodyparts;i>0;i--) {
			
			x[i] = x[i-1];
			y[i] = y[i-1];
			System.out.println(x[i]+" "+y[i]);

		}
		
		switch(this.direction) {
		
		case  'U':
			y[0] = y[0]-25;
			
			break;
			

		case  'D':
			y[0] = y[0]+25;
			
			
			break;

		case  'L':
			x[0] = x[0]-25;
			
			
			break;

		case  'R':
			
			x[0] = x[0]+25;
			
			break;
			
			
		
		}
		
	}
	public void checkApple() {
		
		if(x[0] == this.applex && y[0] == this.appley) {
			
			this.bodyparts++;
			this.newapple();
			
		}
		
	}
	
	public void checkCollisions() {
		
	}
	public void gameover(Graphics g) {
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("action performed called");

	if(running) {
		
		move();
		this.checkApple();
		this.checkCollisions();
		
	}
	super.repaint();
		
	}

	public class Mykeyadaptor extends KeyAdapter{
		
		public void keyPressed( KeyEvent e) {
			
			switch(e.getKeyCode()) {
				
				case KeyEvent.VK_LEFT:
					
					if(direction!='R') {
						direction = 'L';
					}
					break;
					
case KeyEvent.VK_RIGHT:
					
					if(direction!='L') {
						direction = 'R';
					}
					break;
						
case KeyEvent.VK_UP:
	
	if(direction!='D') {
		direction = 'U';
	}
	break;
	
case KeyEvent.VK_DOWN:
	
	if(direction!='U') {
		direction = 'D';
	}
	break;
					
				
			}
			
			
		}
		
	}	
	
	
	

}
