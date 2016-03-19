package cookiegame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import cookiegame.framework.Animation;

public class StartingClass extends Applet implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Player player;
	private Heliboy hboy1, hboy2;
	private Image image, character, character2, character3, characterDown, characterJumped, 
	currentSprite, heliboy, heliboy2, heliboy3, heliboy4, heliboy5, background;
	private Graphics second;
	private URL base;
	private static Background background1, background2;
	private Animation anim, hanim;

	@Override
	public void init() {

		setSize(800, 480);
		setBackground(Color.WHITE);
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
				character2 = getImage(base, "Images/character2.png");
				character3 = getImage(base, "Images/character3.png");
				
				characterDown = getImage(base, "Images/down.png");
				characterJumped = getImage(base, "Images/jumped.png");
				
				heliboy  = getImage(base, "Images/heliboy.png");
				heliboy2 = getImage(base, "Images/heliboy2.png");
				heliboy3 = getImage(base, "Images/heliboy3.png");
				heliboy4 = getImage(base, "Images/heliboy4.png");
				heliboy5 = getImage(base, "Images/heliboy5.png");


				background = getImage(base, "Images/background.png");

				anim = new Animation();
				anim.addFrame(character, 1250);
				anim.addFrame(character2, 50);
				anim.addFrame(character3, 50);
				anim.addFrame(character2, 50);
				
				hanim = new Animation();
				hanim.addFrame(heliboy, 100);
				hanim.addFrame(heliboy2, 100);
				hanim.addFrame(heliboy3, 100);
				hanim.addFrame(heliboy4, 100);
				hanim.addFrame(heliboy5, 100);
				hanim.addFrame(heliboy4, 100);
				hanim.addFrame(heliboy3, 100);
				hanim.addFrame(heliboy2, 100);
				
				currentSprite = anim.getImage();

	}

	@Override
	public void start() {
		background1 = new Background(0, 0);
		background2 = new Background(2160, 0);
		player = new Player();
		hboy1 = new Heliboy(340, 360);
		hboy2 = new Heliboy(700, 360);
		

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
				currentSprite = anim.getImage();
			}
			
			ArrayList projectiles = player.getProjectiles();
			for (int i = 0; i < projectiles.size(); i++) {
				Projectile p = (Projectile) projectiles.get(i);
				if (p.isVisible() == true) {
					p.update();
				} else {
					projectiles.remove(i);
				}
			}
			
			hboy1.update();
			hboy2.update();
			background1.update();
			background2.update();
			
			animate();
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
	
	public void animate() {
		   anim.update(10);
		   hanim.update(50);
		}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, background1.getBackgroundX(), background1.getBackgroundY(), this);
		g.drawImage(background, background2.getBackgroundX(), background2.getBackgroundY(), this);
		g.drawImage(currentSprite, player.getCenterX() - 61, player.getCenterY() - 63, this);
		g.drawImage(hanim.getImage(), hboy1.getCenterX() - 48, hboy1.getCenterY() - 48, this);
		g.drawImage(hanim.getImage(), hboy2.getCenterX() - 48, hboy2.getCenterY() - 48, this);
		
		ArrayList projectiles = player.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = (Projectile) projectiles.get(i);
			g.setColor(Color.YELLOW);
			g.fillRect(p.getX(), p.getY(), 10, 5);
		}

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
			
		case KeyEvent.VK_UP:
			if (player.isCrouched() == false && player.isJumped() == false) {
				player.shootUp();
			}
			break;
			
		case KeyEvent.VK_RIGHT:
			if (player.isCrouched() == false && player.isJumped() == false) {
				player.shootRight();
			}
			break;
			
		case KeyEvent.VK_DOWN:
			if (player.isCrouched() == false && player.isJumped() == false) {
				player.shootDown();
			}
			break;
			
		case KeyEvent.VK_LEFT:
			if (player.isCrouched() == false && player.isJumped() == false) {
				player.shootLeft();
			}
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
			currentSprite = anim.getImage();
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
