package entity;

public class Computer {
	
	private long id;
	private String model;//型号
	private String picName;//名字
	private String prodDesc;//产品说明
	private double price;//价格
	
	public Computer(){
	}

	public Computer(String model, String picName, String prodDesc,
			double price) {
		this.model = model;
		this.picName = picName;
		this.prodDesc = prodDesc;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
