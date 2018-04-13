package util;

public class Book {
	private int num;
	private String name;
	private double price;
	public Book(int num,String name,double price) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.name = name;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
