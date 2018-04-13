package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.imageio.ImageIO;

public class Enemy1 {

	private int x,y;//λ������
	private BufferedImage image;//�ɻ�ͼƬ
	private int size;//�ߴ�
	private int width,height;//����
	private int speed;//С�ɻ��ٶ�
	private BufferedImage[] images;//С�ɻ�ͼƬ����
	private int index;//�����±�
	private Random random = new Random();//�ɻ�λ�������
	private int bleed;
	
	//���췽��  ��ʼ������
	public Enemy1 (int speed,int y) {
		x = random.nextInt(480);//��ʼ��������
		this.y = y ;//��ʼ��������
		this.speed = speed;
		try {
			image = ImageIO.read(getClass().getResource("enemy1.png"));//��ʼ��ͼƬ
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		width = image.getWidth();
		height = image.getHeight();
		size = 40;
		images = new BufferedImage[4];
		for (int i = 0; i < images.length; i++) {
			try {
				images[i] = ImageIO.read(getClass().getResource("enemy1_down"+(i+1)+".png"));
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

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
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

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	//С�ɻ�����
	public void step() {
		y +=speed;//ÿ��ʱ�������ٶ�����ʾ����ôԶ
		if(y == 520){//����ɳ���ҳ�棬�������ϵ��´��·�һ��
			y = -20;
			x = random.nextInt(480);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}
	public boolean hit(Bullet bullet){
		if (bullet.getX()>x && bullet.getX()<(x + width)) {
			if (bullet.getY()<y) {
				return true;
			}
			return false;
		}
		return false;
	}
	
	public void boom() {
		index ++;
		image = images[index % images.length];
	}
}
