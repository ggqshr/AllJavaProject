package 实验十一;
import java.applet.*;
import java.awt.*;
public class KY11_2 extends Applet{
	public String s="输出字符串";
	int i[]={10,60,80};
	int y[]={150,180,300};
	Image im1;
	public void init()
	{setBackground(Color.black);
	setForeground(Color.BLUE);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.drawString(s, 20, 20);
		g.drawLine(40, 40, 100, 40);
		g.drawOval(40, 60, 20, 20);
		g.drawOval(40, 80, 20, 30);
		g.drawRect(40,120, 20, 30);
		g.drawArc(40, 160, 30, 20,40,100 );
		g.drawPolygon(i,y,3);
		im1=getImage(getDocumentBase(),"1.jpg");
		g.drawImage(im1, 40, 600,  this);
		g.drawImage(im1, 40, 300, 200,400,this);
	}

}
