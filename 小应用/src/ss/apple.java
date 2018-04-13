package ss;
import java.applet.*;
import java.awt.*;
public class apple extends Applet{
	String s;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		 s="ÄãºÃ";
	}

	
	public void paint (Graphics g)
	{
		this.setBackground(Color.white);
		g.drawString(s, 20, 20);
	}
	
	

}
