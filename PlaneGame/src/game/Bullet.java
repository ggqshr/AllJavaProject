package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet {

	private int x,y;
	private int width,height;
	private BufferedImage image;
	private int size;
	public Bullet(MyPlane m) {
		// TODO Auto-generated constructor stub
		x = m.getX();
		y = m.getY() - m.getHeight()/2;
		size = 10;
		try {
			image = ImageIO.read(Bullet.class.getResource("/img/bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}
	
//	子弹向上发射
	public void step(MyPlane m)
	{
		y--;
		if(y < m.getY())
		{
			y -= 8;
			if(y<-100)
			{
				x = m.getX() + m.getWidth()/2 - width/2;
				y = m.getY() ;
			}
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
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
