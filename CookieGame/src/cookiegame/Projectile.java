package cookiegame;

public class Projectile {

	private int x, y, speedX, speedY;
	private boolean visible;

	public Projectile(int startX, int startY, String Direction) {
		x = startX;
		y = startY;

		if (Direction == "Right") {
			speedX = 7;
			speedY = 0;
		} else if (Direction == "Left") {
			speedX = -7;
			speedY = 0;
		}

		else if (Direction == "Up") {
			speedX = 0;
			speedY = -7;
		}

		else if (Direction == "Down") {
			speedX = 0;
			speedY = 7;
		}
		visible = true;

	}

	public void update() {
		x += speedX;
		y += speedY;
		if (x > 800 || x < 0 || y > 480 || y < 0) {
			visible = false;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpeedX() {
		return speedX;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
}
