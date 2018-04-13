import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class test {

	static class sss extends Thread
	{
		private  int x = 1;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true)
			{
				System.out.println(x++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public sss() {
			// TODO Auto-generated constructor stub
		}
	}
	static class testt2 extends Thread
	{
		private  String x1 ="nihao";
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while(true)
			{
				System.out.println(x1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}
	public static void main(String[] args) {
		sss  s  = new sss();
		s.start();
		testt2 tt = new testt2();
		tt.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s.stop();
		tt.stop();
	}
}
