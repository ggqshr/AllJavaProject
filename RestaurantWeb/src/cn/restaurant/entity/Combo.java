package cn.restaurant.entity;

public class Combo {
private String comboNumber;
private String comboName;
private int  noodlesNum;
private int  meatNum;
private int  vegetableNum;
private int  soupNum;
private float comboPrice;
private int comboSum;
public int getComboSum() {
	return comboSum;
}
public void setComboSum(int comboSum) {
	this.comboSum = comboSum;
}
public Combo() {
	// TODO Auto-generated constructor stub
}
public String getComboNumber() {
	return comboNumber;
}
public void setComboNumber(String comboNumber) {
	this.comboNumber = comboNumber;
}
public String getComboName() {
	return comboName;
}
public void setComboName(String comboName) {
	this.comboName = comboName;
}
public int getNoodlesNum() {
	return noodlesNum;
}
public void setNoodlesNum(int noodlesNum) {
	this.noodlesNum = noodlesNum;
}
public int getMeatNum() {
	return meatNum;
}
public void setMeatNum(int meatNum) {
	this.meatNum = meatNum;
}
public int getVegetableNum() {
	return vegetableNum;
}
public void setVegetableNum(int vegetableNum) {
	this.vegetableNum = vegetableNum;
}
public int getSoupNum() {
	return soupNum;
}
public void setSoupNum(int soupNum) {
	this.soupNum = soupNum;
}
public float getComboPrice() {
	return comboPrice;
}
public void setComboPrice(float comboPrice) {
	this.comboPrice = comboPrice;
}


}
