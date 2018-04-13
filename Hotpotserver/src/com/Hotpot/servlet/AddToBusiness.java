package com.Hotpot.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.BusinessDao;
import com.Hotpot.dao.FoodCheckDao;
import com.Hotpot.dao.impl.BusinessDaoImpl;
import com.Hotpot.dao.impl.FoodCheckDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Business;
import com.example.ggq.restaurant.com.Hotpot.entity.Combo;
import com.example.ggq.restaurant.com.Hotpot.entity.Customer;
import com.example.ggq.restaurant.com.Hotpot.entity.Food;
import com.example.ggq.restaurant.com.Hotpot.entity.FoodCheck;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class AddToBusiness
 */
public class AddToBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson();
		PrintWriter out = null;
			out = response.getWriter();
		//用这个才能正常显示中文
		BufferedReader br = null;
			br = new BufferedReader(new InputStreamReader(  
			        (ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");  
        String temp;  
		while ((temp = br.readLine()) != null)  
			   sb.append(temp);  
		out.print("ok");
		out.flush();
		HashMap<String, Object> map = gson.fromJson(sb.toString(), 
				new TypeToken<HashMap<String,Object>>(){}.getType());
		BusinessDao businessDao = new BusinessDaoImpl();
		FoodCheckDao foodCheckDao = new FoodCheckDaoImpl();
		Business business = null;
		FoodCheck foodCheck = null;
		ArrayList<Food> food = (ArrayList<Food>) map.get("food");
		String foodJson = gson.toJson(food);
		ArrayList<Food> foods = gson.fromJson(foodJson,
				new TypeToken<ArrayList<Food>>() {}.getType());
		ArrayList<Combo> combo = (ArrayList<Combo>) map.get("combo");
		String comboJson = gson.toJson(combo);
		ArrayList<Combo> combos = gson.fromJson(comboJson
				,new  TypeToken<ArrayList<Combo>>(){}.getType());
		String customerJson = gson.toJson(map.get("customer"));
		Customer customer = gson.fromJson(customerJson, Customer.class);
 		System.out.println(customer.getCustomerName());
 		for (Combo combo2 : combos) {
			business = new Business();
			business.setBusinessMoney(combo2.getComboPrice());
			business.setComboNumber(combo2.getComboNumber());
			business.setCustomerNumber(customer.getCustomerNumber());
			business.setBusinessType("combo");
			businessDao.insertBusiness(business);
		}
 		int foosNum = 0 ;
 		float foodPrice = 0f;
		for (Food food2 : foods) {
			foosNum+=food2.getFoodNum();
			foodPrice+=food2.getFoodPrice()*food2.getFoodNum();
		}
		if(foods.size()>0)
		{
			business = new Business();
			business.setFoodSum(foosNum);
			business.setBusinessMoney(foodPrice);
			business.setBusinessType("food");
			business.setCustomerNumber(customer.getCustomerNumber());
			Object[] inf =  businessDao.insertBusiness(business);
			for (Food food2 : foods) {
				foodCheck = new FoodCheck();
				foodCheck.setBusinessNumber(inf[0].toString());
				foodCheck.setCheckPrice(food2.getFoodPrice()*food2.getFoodNum());
				foodCheck.setCustomerNumber(customer.getCustomerNumber());
				foodCheck.setFoodNum(food2.getFoodNum());
				foodCheck.setFoodNumber(food2.getFoodNumber());
				foodCheck.setCheckDate(inf[1].toString());
				foodCheckDao.insertFoodCheck(foodCheck);
			}
		}
		
	}
}
