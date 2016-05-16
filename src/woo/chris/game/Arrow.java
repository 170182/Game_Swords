package woo.chris.game;

import java.awt.Graphics;

public class Arrow extends GameObject {

	public Arrow(int x, int y, ID id) {
		super(x, y, id);
	}

	public void tick() {
		x += velX;
		y += velY;
		
		//Arrow will start from origin of the player
		//and will go towards the current cursor location
		//Save current cursor location on click
		//a is difference in x
		//b is difference in y
		//c = a+b/velocity of bullet
		//velX = a/c
		//velY  = b/c
		//these are both doubles
	}

	public void render(Graphics g) {
		
	}
	
}
