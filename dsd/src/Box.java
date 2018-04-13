public class Box{
	private int length;
	private int height;
	private int width;
	void setBox(int l,int w,int h)
	{
		length=l;
		width=w;
		height=h;
	}
	int volume()
	{
		return height*length*width;
	}
	public static void main(String[] args) {
		Box box=new Box();
		box.setBox(1, 2, 3);
		System.out.println(box.volume());
	}
}