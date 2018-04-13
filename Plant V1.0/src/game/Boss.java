package game;

//////////////////////////  gay杨
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Boss {
	private int x,y;//位置坐标
	private BufferedImage image;//飞机图片
	private BufferedImage[] hitImage;//被打状态
	private int size;//尺寸
	private int width,height;//长宽
	private int speed;//小飞机速度
	private BufferedImage[] images;//小飞机图片数组
	private int index,index1;//数组下标
	private Random random = new Random();//飞机位置随机数
	
	public Boss() {
		// TODO Auto-generated constructor stub
		images = new BufferedImage[6];
		try {
			hitImage = new BufferedImage[2];
			image = ImageIO.read(getClass().getResource("enemy2.png"));
			hitImage[0] = image;
			hitImage[1] = ImageIO.read(getClass().getResource("enemy2_hit.png"));
			
			for(int i=0;i<6;i++)
			{
				images[i]=ImageIO.read(getClass().getResource("enemy2_down"+(i+1)+".png"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		index = 0;
		this.y = -2000;
		this.x = 240-width/2;
	}
	int BossSpeed = 3;
	public void step()
	{
		
		if(y<0)
			y+=4;
		else if(y>=0)
		{
			x+=BossSpeed;
		if(x<=0)
		{
			BossSpeed = -BossSpeed;
		}
		else if(x>=480-width)
		{
			BossSpeed = -BossSpeed;
		}
		}
	}
	public boolean hit(Bullet bullet)
	{
		if (bullet.getX()>x && bullet.getX()<(x + width)) {
			if (bullet.getY()<y+height-20) {
				return true;
			}
			return false;
		}
		return false;
	}
	public void afterHit()
	{
		index ++;
		image = hitImage[index%2];
	}
	public void boom()
	{
		index1++;
		image = images[index1/5%6];
		hitImage[0]=image;
	}
	
	public int getIndex1() {
		return index1;
	}
	public void setIndex1(int index1) {
		this.index1 = index1;
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
	public BufferedImage[] getHitImage() {
		return hitImage;
	}
	public void setHitImage(BufferedImage[] hitImage) {
		this.hitImage = hitImage;
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
	
}
