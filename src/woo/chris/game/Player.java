package woo.chris.game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {
	
	public Player(int x, int y, ID id) {
		super(x, y, id);
	}
	
	public void tick() {
		x += velX;//Moves the player object left/right by speed
		y += velY;//Moves the player object up/down by speed

		x = Game.clamp(x,  0, Game.WIDTH - 32);
		y = Game.clamp(y, 0, Game.HEIGHT - 52);
	}
	
	public void render(Graphics g) {
		if(id == ID.Player) g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
	}
}
