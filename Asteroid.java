/** by Mohammadali Saffary
 * Asteroid.java
 * 
 * Class that represents an Asteroid object
 */
import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Polygon {

	public Asteroid(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint(Graphics brush, Color color) {
		Point[] pts = getPoints();
		int[] xpts = new int[pts.length];
		int[] ypts = new int[pts.length];
		int npts = pts.length;

		for (int i = 0; i < npts; i++) {
			xpts[i] = (int)pts[i].x;
			ypts[i] = (int)pts[i].y;
		}

		brush.setColor(color);
		brush.drawPolygon(xpts, ypts, npts);

	}

	// Detect if there was a collision
	public boolean collision(Polygon poly) {
		Point[] points = poly.getPoints();
		for(Point p : points) {
			if(this.contains(p)) {
				return true;
			}
		}
		return false;
	}

	//	move the asteroid
	public void move() {
		position.x += Math.cos(Math.toRadians(rotation));
		position.y += Math.sin(Math.toRadians(rotation));

		if (position.x > Asteroids.SCREEN_WIDTH) {
			position.x = 0;
		}
		if (position.y > Asteroids.SCREEN_HEIGHT) {
			position.y = 0;
		}
		if (position.x < 0) {
			position.x = Asteroids.SCREEN_WIDTH;
		}
		if (position.y < 0 ) {
			position.y = Asteroids.SCREEN_HEIGHT;
		}

	}
}
