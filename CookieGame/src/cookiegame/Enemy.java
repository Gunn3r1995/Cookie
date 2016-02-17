package cookiegame;

public class Enemy {

	private int maxHealth, currentHealth, power, speedX, centerX, centerY;
	private Background bg = StartingClass.getBackground1();

	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = bg.getSpeedX();
	}

	public void die() {
	}

	public void attack() {
	}

}
