package woo.chris.game;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

//command + shift + o   - fast import

public class Window extends Canvas{

	//add generated serial number ID
	private static final long serialVersionUID = -7259108873705494293L;

	//constructor for Window
	public Window(int width, int height, String title, Game game) {
		//JFrame - frame of the window (inbuilt library within Java JRE)
		JFrame frame = new JFrame(title);
		
		//
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Allows the x button (top right of window) to stop the thread
		frame.setResizable(false);//Makes it so that the window is not resizable
		frame.setLocationRelativeTo(null);//Makes the window appear in the middle
		frame.add(game);//Adds game class into the frame
		frame.setVisible(true);//Makes the window visible
		game.start();//function from Game class - public synchronized void start()
	}
}
