package sdsds;

public class aaaa {
	private String name;
	private int age;
	private static aaaa atest;
	private aaaa(String name ,int age)
	{
		this.name = name ;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public static aaaa getAaaa()
	{
		if(atest==null)
		{
			atest = new aaaa("tom", 12);
		}
		return atest;
	}
}
