package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Prop {
	private int x,y;//炸弹坐标
	private int width,height;
	private BufferedImage image;
	private int size;
	public Prop() {
		// TODO Auto-generated constructor stub
		try {
			image = ImageIO.read(getClass().getResource("prop_type_0.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		size = 10;
		y = 0;
		x = 0;
	}
//	核弹向下飘来
	int flag = 0;
	public void step()
	{
		y+=2;
		if(x == 430)
		{
			flag = 1;
		}
		else if(x == 0)
		{
			flag = 0;
		}
		if(flag == 0 )
		{
			x+=2;
		}
		else
		{
			x-=2;
		}
		if(y == 700)
		{
			y=0;
		}
	}
	public boolean hit(MyPlane m )
	{
//		if(x>m.getX()&&x+width<m.getX()+m.getWidth())
//		{
//			if( y>m.getY() && y+height<m.getY()+m.getHeight())
//			{
//				return true;
//			}
//			else
//			{
//				return false;
//			}
//		}
//		return false;
		if(x+width -30 < m.getX() || x + 30> m.getX()+m.getWidth())
		{
			return false;
		}
		else if(y +25 > m.getY()+m.getHeight() || y + height - 25< m.getY())
		{
			return false;
		}
		return true;
	}
	public void  getBoom()
	{
		y=0;
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
