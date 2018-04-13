package game;


//////////////////
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class BossBullet {
	private double x,y;//×Óµ¯×ø±ê
	private int width,height;
	private BufferedImage image;
	private int size;
	
	public BossBullet(Boss boss) {
		// TODO Auto-generated constructor stub
		x  = boss.getX() + boss.getWidth()/2;
		y = boss.getY() + boss.getHeight()/2;
		size = 10;
		try {
			image = ImageIO.read(getClass().getResource("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
	}
	double flag1 =3;
	double flag2 = 3;
	public void step() {
			x-=flag1;
			y-=flag2;
			if(y<=0)
			{
				flag2 = -flag2;
				flag1 = new Random().nextDouble();
			}
			else if(y >= 690)
			{
				flag2 = -flag2;
				flag1 = Math.random()*1.3+1.1;
			}
			if(x<=0)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+1.1;
			}
			else if(x >= 450)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+0.6;
			}
			
	}
	public void step1() {
			
			x+=flag1;
			y-=1.5*flag2;
			if(y<=0)
			{
				flag2 = -flag2;
				flag1 = new Random().nextDouble();
			}
			else if(y >= 690)
			{
				flag2 = -flag2;
				flag1 = Math.random()*1.3+1.1;
			}
			if(x<=0)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+1.1;
			}
			else if(x >= 450)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+0.6;
			}
		}
		
	public void step2() {
			x+=flag1;
			y+=1.2*flag2;
			if(y<=0)
			{
				flag2 = -flag2;
				flag1 = new Random().nextDouble();
			}
			else if(y >= 690)
			{
				flag2 = -flag2;
				flag1 = Math.random()*1.3+1.1;
			}
			if(x<=0)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+1.1;
			}
			else if(x >= 450)
			{
				flag1=-flag1;
				flag2 = Math.random()*1.3+0.6;
			}
}
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public double getY() {
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
