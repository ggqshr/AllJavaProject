package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Brid {
	public BufferedImage image;
	public int x,y;
	public int width,height;
	public int size;
	public ArrayList<BufferedImage> images = new ArrayList<>();
	public int index;
	public final double v;
	public double time;
	public double speed;
	public double s;
	public Brid() throws IOException {
		// TODO Auto-generated constructor stub
		image = ImageIO.read(Brid.class.getResource("/img/0.png"));
		width = image.getWidth();
		height = image.getHeight();
		x = 140;
		y = 240;
		size = 40;
		time = 0.25;
		v = 15;
		speed = v;
		for (int i=0;i<=7;i++)
		{
			BufferedImage image1= ImageIO.read(Brid.class.getResource("/img/"+i+".png"));
			images.add(image1);
		}
	}
	
	public void fly()
	{
		index++;
		int size=images.size();
		image = images.get(index/8%size);
	}
	
	public void step()
	{
		double d = speed;
		s = d*time;
		y = (int) (y-35);
	}
	
	public void down()
	{
		double d = speed;
		s = d*time;
		y = (int) (y+s);
	}
	
	public void flyup()
	{
		speed = v;
	}
	
	public boolean f(Ground ground)
	{
		if (y >= ground.y)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean f(Column column)
	{
		System.out.println(x);
		System.out.println(column.x - column.width / 2);
		if (x < column.x - column.width / 2)
		{
			if (y > column.y - column.gap / 2 && y < column.y + column.gap / 2)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		return false;
	}
	
}
