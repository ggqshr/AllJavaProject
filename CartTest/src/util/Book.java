package util;

public class Book {
	private int price;
	private int num;
	private String name;
	public Book(String name,int price,int num) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
