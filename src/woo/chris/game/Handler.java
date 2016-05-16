package woo.chris.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {//Maintains/updates/renders all objects in the game
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {//Updates all game objects
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);//Sets tempObject to the object at position i
			
			tempObject.tick();
		}
	}
	public void render(Graphics g) {//Renders all game objects
		for(int i = 0; i < object.size(); i++){
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removedObject(GameObject object) {
		this.object.remove(object);
	}
}
