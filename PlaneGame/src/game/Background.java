package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Background {

	private int x,y;
	private BufferedImage image;
	public Background(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		try {
			image = ImageIO.read(Background.class.getResource("/img/background.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
//	±³¾°²»Í£µØ¶¯
	public void step()
	{
		y += 5;
		if (y == 600)
		{
			y = -960;
		}
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
