package com.Hotpot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.FoodDao;
import com.Hotpot.dao.impl.FoodDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Food;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetFoodAsType
 */
public class GetFoodAsType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFoodAsType() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		String foodType = request.getParameter("foodType");
		FoodDao foodDao = new FoodDaoImpl();
		ArrayList<Food> foods = foodDao.queryFoodAsType(foodType);
		String string = gson.toJson(foods);
		out.print(string);
	}

}
