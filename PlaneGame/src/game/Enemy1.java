package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Enemy1 {
	
	private int x,y;
	private BufferedImage image;
	
	private int size;
	private int speed;
	private ArrayList<BufferedImage> images = new ArrayList<>();
	private int index;
	private int width,height;
	//Ëæ»úÊý
	private Random random = new Random();
	
	public Enemy1(int yy,int speed) {
		// TODO Auto-generated constructor stub
		x = random.nextInt(480);
		this.y = yy;
		this.speed = speed;
		try {
			image = ImageIO.read(Enemy.class.getResource("/img/enemy1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		size = 40;
		for ( int i=0;i<4;i++)
		{
			try {
				images.add(ImageIO.read(Enemy.class.getResource("/img/enemy1_down"+(i+1)+".png")));
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

}
