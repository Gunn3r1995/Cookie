package cookiegame;

public class Enemy {

	private int maxHealth, currentHealth, power, speedX, centerX, centerY;
	private Background background = StartingClass.getBackground1();

	// Behavioral Methods
	public void update() {
		centerX += speedX;
		speedX = background.getSpeedX();
	}

	public void die() {
	}

	public void attack() {
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getPower() {
		return power;
	}

	public int getSpeedX() {
		return speedX;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public Background getBackground() {
		return background;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	public void setBackground(Background background) {
		this.background = background;
	}

}
