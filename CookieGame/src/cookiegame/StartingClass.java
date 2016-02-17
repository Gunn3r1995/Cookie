package cookiegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

public class StartingClass extends Applet implements Runnable, KeyListener {

	private Player player;
	private Image image, character, characterDown, characterJumped, currentSprite, background;
	private Graphics second;
	private URL base;
	private static Background background1, background2;

	@Override
	public void init() {

		setSize(800, 480);
		setBackground(Color.BLACK);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame) this.getParent().getParent();
		frame.setTitle("Cookie Alpha");
		try {
			base = getDocumentBase();
		} catch (Exception e) {
			// TODO: handle exception
		}

		// Image Setups
		character = getImage(base, "Images/character.png");
		characterDown = getImage(base, "Images/Down.png");
		characterJumped = getImage(base, "Images/Jumped.png");
		currentSprite = character;
		background = getImage(base, "Images/background.png");

	}

	@Override
	public void start() {
		background1 = new Background(0, 0);
		background2 = new Background(2160, 0);
		player = new Player();

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
			player.update();
			if (player.isJumped()) {
				currentSprite = characterJumped;
			} else if (player.isJumped() == false && player.isCrouched() == false) {
				currentSprite = character;
			}
			background1.update();
			background2.update();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Graphics g) {
		if (image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}

		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);

		g.drawImage(image, 0, 0, this);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, background1.getBackgroundX(), background1.getBackgroundY(), this);
		g.drawImage(background, background2.getBackgroundX(), background2.getBackgroundY(), this);
		g.drawImage(currentSprite, player.getCenterX() - 61, player.getCenterY() - 63, this);

	}

	@Override
	public void keyPressed(KeyEvent e) {

		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Move up");
			break;

		case KeyEvent.VK_S:
			currentSprite = characterDown;
			if (player.isJumped() == false) {
				player.setCrouched(true);
				player.setSpeedX(0);
			}
			break;

		case KeyEvent.VK_A:
			player.moveLeft();
			player.setMovingLeft(true);
			break;

		case KeyEvent.VK_D:
			player.moveRight();
			player.setMovingRight(true);
			break;

		case KeyEvent.VK_SPACE:
			player.jump();
			break;

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			System.out.println("Stop moving up");
			break;

		case KeyEvent.VK_S:
			currentSprite = character;
			player.setCrouched(false);
			break;

		case KeyEvent.VK_A:
			player.stopLeft();
			break;

		case KeyEvent.VK_D:
			player.stopRight();
			break;

		case KeyEvent.VK_SPACE:
			break;

		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public static Background getBackground1() {
		return background1;
	}

	public static Background getBackground2() {
		return background2;
	}

}
