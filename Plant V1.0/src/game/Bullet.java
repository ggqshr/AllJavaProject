package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet {
	private int x,y;//子弹坐标
	private int width,height;
	private BufferedImage image;
	private int size;
	
	//构造方法
	
	public  Bullet(MyPlane plane) {
		x  = plane.getX() + plane.getWidth()/2;
		y = plane.getY() - plane.getHeight()/2;
		size = 10;
		try {
			image = ImageIO.read(getClass().getResource("bullet1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		
	}
	
	//子弹向上发射
	public void step(MyPlane plane) {
		y-=10;	
		if (y < plane.getY()) {
			y -=8;
			if(y <=0){//子弹重生
				x = plane.getX()+plane.getWidth()/2;
				y = plane.getY() - plane.getHeight()/2;
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
