package model;

import java.util.*;

public class user {
private String name;
private int id;
private Date creatdataDate;
private Date updataDate;
public Date getCreatdataDate() {
	return creatdataDate;
}
public void setCreatdataDate(Date creatdataDate) {
	this.creatdataDate = creatdataDate;
}
public Date getUpdataDate() {
	return updataDate;
}
public void setUpdataDate(Date updataDate) {
	this.updataDate = updataDate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
@Override
public String toString() {
	return "user [name=" + name + ", id=" + id + ", creatdataDate="
			+ creatdataDate + ", updataDate=" + updataDate + "]";
}

}
