package com.hpsx.view;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.hpsx.dao.impl.UserDaoImpl;
import com.hpsx.po.User;

public class menu {
    
	static UserUI userUI = new UserUI();	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userUI.primary_menu();
		
		}
	}
