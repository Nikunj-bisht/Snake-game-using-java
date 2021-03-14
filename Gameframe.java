package sn;

import javax.swing.JFrame;

public class Gameframe extends JFrame {

public Gameframe(){
		
    super.add(new Gamepanel());
		super.setTitle("Snake");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setResizable(false);
		super.pack();super.setVisible(true);
		System.out.println("Jframe object called");

		
	}
	

}
