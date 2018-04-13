package game;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyPlane {
	
	private int x,y;//����
	private BufferedImage image;//�ɻ�ͼƬ
	private int size;//�ߴ�
	private int width;//�ɻ��Ŀ���ͼƬ�Ŀ�
	private int height;//�ɻ��ĳ�����ͼƬ�ĳ�
	private BufferedImage[] images;//ͼƬ����
	private int index;//�����±�
	
	//�ɻ���ʼ��
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
	
	//get set ����
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
	
	//����
	//�ɻ�����
	public void fly(){
		index++;
		image = images[index % 2];
	}
	
	//�ɻ��ƶ�
	public void move (KeyEvent event	){
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT://�����ƶ� �����  ����ʮ����λ����
			x -= 10;
			break;
		case KeyEvent.VK_RIGHT://�����������Ұ��� �ɻ��������10����λ����
			x += 10;
			break;
		case KeyEvent.VK_UP://�����������ϰ��� �ɻ��������10����λ����
			y -= 10;
			break;
		case KeyEvent.VK_DOWN://�����������°��� �ɻ��������10����λ����
			y += 10;
			break;
		default:
			break;
		}
	}
//�жϴ�ɻ��Ƿ�С�ɻ�ײ��
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
