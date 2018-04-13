package mod;

public class user {
private int id;
private int password;
private String name;
private String classes;
private String school;
private String sex;
private int phone;
private String email;
public user(){
	id=5;
	password=87;
	name="ggq";
	classes="惠普开发142";
	school="青岛科技大学";
	sex="男";
	phone=12345;
	email="942490@qq.com";
}
@Override
public String toString() {
	return "user [id=" + id + ", password=" + password + ", name=" + name
			+ ", classes=" + classes + ", school=" + school + ", sex=" + sex
			+ ", phone=" + phone + ", email=" + email + "]";
}
public int getPassword() {
	return password;
}
public void setPassword(int password) {
	this.password = password;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClasses() {
	return classes;
}
public void setClasses(String classes) {
	this.classes = classes;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
