import java.applet.*;
import java.awt.Graphics;
import java.awt.Image;
public class E15_13 extends Applet{
	int index=0;
	Image imgs[]=new Image[6];
	public void init()
	{
		for(;index<6;index++){
			imgs[index]=getImage(getDocumentBase(), index+1+".jpg");
		}
	}
	public void paint(Graphics g){
		for(;index<6;index++){
		g.drawImage(imgs[index], 0, 0,300,400, this);
		try{
			Thread.sleep(100);
		}catch(InterruptedException e){System.out.println(e.toString());}
		}
		if(index==6)index=0;
	
		repaint();
	}
}