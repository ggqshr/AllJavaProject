package cn.restaurant.entity;

public class Food {
private String foodNumber;
private String foodName;
private String foodType;
private float foodPrice;
private int foodBanlance;
//public Food() {
//	foodNumber="2";
//	foodName="花卷";
//	foodType="面点";
//	foodPrice=12;
//	foodBanlance=30;
//}
public String getFoodNumber() {
	return foodNumber;
}
public void setFoodNumber(String foodNumber) {
	this.foodNumber = foodNumber;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
public float getFoodPrice() {
	return foodPrice;
}
public void setFoodPrice(float foodPrice) {
	this.foodPrice = foodPrice;
}
public int getFoodBanlance() {
	return foodBanlance;
}
public void setFoodBanlance(int foodBanlance) {
	this.foodBanlance = foodBanlance;
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return foodNumber+","+foodName+","+foodType+","+foodPrice+","+foodBanlance;
}

}
