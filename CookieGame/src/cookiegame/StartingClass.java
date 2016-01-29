package cookiegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class StartingClass extends Applet implements Runnable, KeyListener{

@Override
   public void init() {
	   
      setSize(800, 480);
      setBackground(Color.BLUE);
      setFocusable(true);      
      addKeyListener(this);
      Frame frame = (Frame) this.getParent().getParent();
      frame.setTitle("Cookie Alpha");
}
	@Override
	public void start() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		while (true) {

			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
		  switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Key W Pressed");
		   break;
		   case KeyEvent.VK_DOWN:
			   System.out.println("Key S Pressed");
		   break;
		   case KeyEvent.VK_LEFT:
			   System.out.println("Key A Pressed");
		   break;
		   case KeyEvent.VK_RIGHT:
			   System.out.println("Key D Pressed");
		   break;
		   case KeyEvent.VK_SPACE:
			   System.out.println("Key Space Pressed");
		   break;
		   }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		   switch (e.getKeyCode()) {
		   case KeyEvent.VK_UP:
			   System.out.println("Key W Released");
		      break;
		   case KeyEvent.VK_DOWN:
			   System.out.println("Key S Released");
		      break;
		   case KeyEvent.VK_LEFT:
			   System.out.println("Key A Released");
		      break;
		   case KeyEvent.VK_RIGHT:
			   System.out.println("Key D Released");
		      break;
		   case KeyEvent.VK_SPACE:
			   System.out.println("Key Space Released");
		      break;
		   }
	}
}
