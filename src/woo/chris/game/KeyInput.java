package woo.chris.game;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private Handler handler;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		//PointerInfo a = MouseInfo.getPointerInfo();
		//Point b = a.getLocation();
		//double mouseX = b.getX();
		//double mouseY = b.getY();
		//double distX, distY, veloX, veloY; //distX/Y is the difference in X/Y of the player and the cursor
		//veloX/Y is the velocity of the bullet x/y, they should add up to bulletV(total velocity of the bullet)
		//double bulletV = 10;
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player
				if(key == KeyEvent.VK_W) tempObject.setVelY(-4);
				if(key == KeyEvent.VK_A) tempObject.setVelX(-4);
				if(key == KeyEvent.VK_S) tempObject.setVelY(4);
				if(key == KeyEvent.VK_D) tempObject.setVelX(4);
			}
			if(tempObject.getID() == ID.Arrow){
				//Arrow Keys to shoot
				if(key == KeyEvent.VK_UP) tempObject.setVelY(-10);
				if(key == KeyEvent.VK_DOWN) tempObject.setVelY(10);
				if(key == KeyEvent.VK_LEFT) tempObject.setVelX(-10);
				if(key == KeyEvent.VK_RIGHT) tempObject.setVelX(10); 
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int key  = e.getKeyCode();
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				//key events for player
				
				if(key == KeyEvent.VK_W) tempObject.setVelY(0);
				if(key == KeyEvent.VK_A) tempObject.setVelX(0);
				if(key == KeyEvent.VK_S) tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) tempObject.setVelX(0);
			}
		}
	}
}
