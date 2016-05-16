package woo.chris.game;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = -1442798787354930462L;

	public static final int WIDTH = 640, HEIGHT = WIDTH/12*9;
	
	//Single threaded game (look to change this)
	private Thread thread;
	private boolean running = false;//Checks if the thread is running (on/off)
	
	private Handler handler;
	
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));//'Listens' for key input
		//Creates the window with width, height, title of window
		new Window(WIDTH, HEIGHT, "Game", this);
		
		handler.addObject(new Player(100,100, ID.Player));//adds a Player object to the game at 100,100
		handler.addObject(new BasicEnemy(WIDTH/2, HEIGHT/2, ID.BasicEnemy));
	}
	public synchronized void start() {//Starts the thread
		thread = new Thread(this);//Intializes thread as a new Thread (this refers to this instance of the game class)
		thread.start();//Starts the thread
		running = true;
	}
	public synchronized void stop() { //stops the thread{ //try and catch statement - similar to if/then statement
		try {//contains a block of program statements within which an exception might occur
			thread.join(); //kills/stops the thread
			running = false;
		}
		catch(Exception e){//Executes if an exception of a particular type occurs within the try block
			e.printStackTrace();//Runs an error in the console
		}
	}
	public void run() {
		//Game Loop (necessary for a game to update itself)
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();//calls tick method
				delta--;
			}
			if(running)
				render();//calls void method
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);//parameter is how many buffers it creates (don't go over 3)
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);//Creates rectangle (changes background color to black)
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static int clamp(int var, int min, int max){
		if (var >= max)
		{
			return var = max;
		}
		else if(var <= min)
		{
			return var = min;
		}
		else
		{
			return var;
		}
	}
	
	public static void main(String[] args) {
		new Game();
	}

}
