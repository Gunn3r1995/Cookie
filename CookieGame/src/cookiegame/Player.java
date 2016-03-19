package cookiegame;

import java.util.ArrayList;

public class Player {

	// Constants
	final int JUMPSPEED = -10;
	final int MOVESPEED = 5;
	final int GROUND = 382;

	private int centerX = 100;
	private int centerY = GROUND;
	private boolean movingUp = false;
	private boolean movingRight = false;
	private boolean movingDown = false;
	private boolean movingLeft = false;

	private static Background background1 = StartingClass.getBackground1();
	private static Background background2 = StartingClass.getBackground2();

	private int speedX = 0;
	private int speedY = 0;

	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public void update() {

		// Moves Character or Scrolls Background accordingly.
		if (speedX < 0) {
			centerX += speedX;
		}
		if (speedX == 0 || speedX < 0) {
			background1.setSpeedX(0);
			background2.setSpeedX(0);

		}
		if (centerX <= 800 && speedX > 0) {
			centerX += speedX;
		}
		if (speedX > 0 && centerX > 800) {
			background1.setSpeedX(-MOVESPEED);
			background2.setSpeedX(-MOVESPEED);
		}

		// Updates Y Position
		centerY += speedY;
		if (centerY + speedY >= GROUND) {
			// centerY = GROUND;
		}

		// Prevents going beyond X coordinate of 0
		if (centerX + speedX <= 60) {
			centerX = 61;
		}
	}

	// Move Player
	public void moveUp() {
		speedY = -MOVESPEED;
	}

	public void moveRight() {
		speedX = MOVESPEED;
	}

	public void moveDown() {
		speedY = MOVESPEED;
	}

	public void moveLeft() {
		speedX = -MOVESPEED;
	}

	// Stop Moving
	public void stopUp() {
		setMovingUp(false);
		stop();
	}

	public void stopRight() {
		setMovingRight(false);
		stop();
	}

	public void stopDown() {
		setMovingDown(false);
		stop();
	}

	public void stopLeft() {
		setMovingLeft(false);
		stop();
	}

	public void stop() {
		// Not Moving
		if (isMovingUp() == false && isMovingRight() == false && isMovingDown() == false && isMovingLeft() == false) {
			speedX = 0;
			speedY = 0;
		}
		
		// Moving Up
		if (isMovingUp() == true && isMovingRight() == false && isMovingDown() == false && isMovingLeft() == false) {
			moveUp();
		}
		
		// Moving Right
		if (isMovingUp() == false && isMovingRight() == true && isMovingDown() == false && isMovingLeft() == false) {
			moveRight();
		}
		
		// Moving Down
		if (isMovingUp() == false && isMovingRight() == false && isMovingDown() == true && isMovingLeft() == false) {
			moveDown();
		}
		// Moving Left
		if (isMovingUp() == false && isMovingRight() == false && isMovingDown() == false && isMovingLeft() == true) {
			moveLeft();
		}
	}

	// Shooting Directions
	public void shootUp() {
		Projectile p = new Projectile(centerX + 0, centerY - 50, "Up");
		projectiles.add(p);
	}

	public void shootRight() {
		Projectile p = new Projectile(centerX + 50, centerY - 25, "Right");
		projectiles.add(p);
	}

	public void shootDown() {
		Projectile p = new Projectile(centerX + 0, centerY - 10, "Down");
		projectiles.add(p);
	}

	public void shootLeft() {
		Projectile p = new Projectile(centerX - 50, centerY - 25, "Left");
		projectiles.add(p);
	}

	// Center Player
	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingRight() {
		return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
		this.movingRight = movingRight;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public ArrayList getProjectiles() {
		return projectiles;
	}

}