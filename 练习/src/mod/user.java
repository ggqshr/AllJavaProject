package mod;

import java.awt.print.Printable;

public class user {
	private String id;
	private String name;
	private String sex;
//public user() {
//	// TODO Auto-generated constructor stub
//	id="1";
//	name="ggq";
//	sex="男声";
//}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
@Override
public String toString() {
	return id+","+name+","+sex;
}

}
