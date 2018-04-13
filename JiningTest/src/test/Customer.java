package test;

public class Customer {
private String name;
private String sex;
private String age;
private String tel;
private String qqNum;
private String address;

public Customer()
{
	
}

public Customer(String name, String sex, String age, String tel, String qqNum, String address) {
	super();
	this.name = name;
	this.sex = sex;
	this.age = age;
	this.tel = tel;
	this.qqNum = qqNum;
	this.address = address;
}
public String getName() {
	return name;
}
public String getSex() {
	return sex;
}
public String getAge() {
	return age;
}
public String getTel() {
	return tel;
}
public String getQqNum() {
	return qqNum;
}
public String getAddress() {
	return address;
}
public void setName(String name) {
	this.name = name;
}
public void setSex(String sex) {
	this.sex = sex;
}
public void setAge(String age) {
	this.age = age;
}
public void setTel(String tel) {
	this.tel = tel;
}
public void setQqNum(String qqNum) {
	this.qqNum = qqNum;
}
public void setAddress(String address) {
	this.address = address;
}

}
