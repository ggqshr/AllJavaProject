package com.Hotpot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.FoodDao;
import com.Hotpot.dao.impl.FoodDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Food;
import com.google.gson.Gson;

/**
 * Servlet implementation class PushFood
 */
public class PushFood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PushFood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		FoodDao foodDao = new FoodDaoImpl();
		ArrayList<Food> foods = foodDao.listFood();
		ArrayList<Food> hotfood = new ArrayList<>();
		int sum = foods.size();
		Random random = new Random();
		hotfood.clear();
		for(int i =0 ;i < 5 ;i ++)
		{
			
			int k = random.nextInt(sum-1)%(sum);
			hotfood.add(foods.get(k));
		}
		String string = gson.toJson(hotfood);
		out.print(string);
	}

}
