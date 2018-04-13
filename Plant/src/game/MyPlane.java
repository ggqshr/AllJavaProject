package game;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyPlane {
	
	private int x,y;//坐标
	private BufferedImage image;//飞机图片
	private int size;//尺寸
	private int width;//飞机的宽，即图片的宽
	private int height;//飞机的长，即图片的长
	private BufferedImage[] images;//图片数组
	private int index;//数组下标
	
	//飞机初始化
	public MyPlane(){
		x=180;
		y=550;
		size = 10;
		index = 0;
		try {
			image = ImageIO.read(getClass().getResource("hero0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		images = new BufferedImage[2];
		for (int i = 0; i < images.length; i++) {
			try {
				images[i] = ImageIO.read(getClass().getResource("hero"+i+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//get set 方法
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
	public BufferedImage[] getImages() {
		return images;
	}
	public void setImages(BufferedImage[] images) {
		this.images = images;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	//方法
	//飞机飞行
	public void fly(){
		index++;
		image = images[index % 2];
	}
	
	//飞机移动
	public void move (KeyEvent event	){
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT://向左移动 按左键  左移十个单位长度
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT://键盘敲下向右按键 飞机横坐标加10个单位长度
			x += 10;
			break;
		case KeyEvent.VK_UP://键盘敲下向上按键 飞机纵坐标减10个单位长度
			y -= 10;
			break;
		case KeyEvent.VK_DOWN://键盘敲下向下按键 飞机纵坐标加10个单位长度
			y += 10;
			break;
		default:
			break;
		}
	}
//判断大飞机是否被小飞机撞到
	public boolean hit(Enemy enemy) {
//		if (x<=enemy.getX() && x>=enemy.getX() - enemy.getWidth()) {
//			if (y<=enemy.getY() && y>=enemy.getY() - enemy.getHeight())
//				return true;
//			else
//				return false;
//		}
//		else
//			return false;
		if(x+width -30 < enemy.getX() || x + 30> enemy.getX()+enemy.getWidth())
		{
			return false;
		}
		else if(y +25 > enemy.getY()+enemy.getHeight() || y + height - 25< enemy.getY())
		{
			return false;
		}
		return true;
	}
	public boolean hit1(Enemy1 enemy) {
		if (x<=enemy.getX() && x>=enemy.getX() - enemy.getWidth()) {
			if (y<=enemy.getY() && y>=enemy.getY() - enemy.getHeight())
				return true;
			else
				return false;
		}
		else
			return false;
	}
}
