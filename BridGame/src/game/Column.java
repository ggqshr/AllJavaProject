package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Column {
	public BufferedImage image;
	public int x,y;
	public int width,height;
	
	//柱子的水平方线的间距
	public int dis;
	//柱子的垂直方向的间距
	public int gap;
	//柱子的个数
	public static int count;
	
	public Column() throws IOException {
		// TODO Auto-generated constructor stub
		count++;
		image = ImageIO.read(Column.class.getResource("/img/column.png"));
		width = image.getWidth();
		height = image.getHeight();
		//垂直的位置
		gap = 100;
		//水平的位置
		dis = 300;
		x = (count-1) * dis;
		y = (int) (Math.random()*(350-218+1)+218);
	}
	
	public void step()
	{
		x--;
		if(x==width/2)
		{
			x = 2 * dis -width/2;
			y = (int) (Math.random()*(350-218+1)+218);
		}
	}
}
