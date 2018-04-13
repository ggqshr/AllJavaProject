package game;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class MyPlane {
	
	private int x,y;
	private BufferedImage image;
	private int size;
	private int width,height;
	private int index;
	private ArrayList<BufferedImage> images = new ArrayList<>();
	public MyPlane() {
		// TODO Auto-generated constructor stub
		x = 180;
		y = 550;
		size = 10;
		index = 0;
		try {
			image = ImageIO.read(MyPlane.class.getResource("/img/hero0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		for ( int i = 0;i<2;i++)
		{
			try {
				images.add(ImageIO.read(MyPlane.class.getResource("/img/hero"+i+".png")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
	public ArrayList<BufferedImage> getImages() {
		return images;
	}
	public void setImages(ArrayList<BufferedImage> images) {
		this.images = images;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public void fly()
	{
		index++;
		image = images.get(index%2);
	}
	public void move(KeyEvent e)
	{
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT:
			x += 10;
			break;
		case KeyEvent.VK_UP:
			y -= 10;
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			break;
		default:
			break;
		}
	}
	public boolean hit(Enemy e)
	{
		if(x <= e.getX()+e.getWidth()/2 && x>=e.getX()-e.getWidth()/2)
		{
			if(y<=e.getY()+e.getHeight()/2 && y >= e.getY() - e.getHeight()/2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}
