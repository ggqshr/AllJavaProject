package com.Hotpot.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.BusinessDao;
import com.Hotpot.dao.FoodCheckDao;
import com.Hotpot.dao.impl.BusinessDaoImpl;
import com.Hotpot.dao.impl.FoodCheckDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Business;
import com.example.ggq.restaurant.com.Hotpot.entity.FoodCheck;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetBusiness
 */
public class GetBusiness extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBusiness() {
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
		String customerNumber = request.getParameter("customerNumber");
		BusinessDao businessDao =  new BusinessDaoImpl();
		FoodCheckDao foodCheckDao = new FoodCheckDaoImpl();
		HashMap<String, Object> map = new HashMap<>();
		ArrayList<Business> businesses = businessDao.QueryBusinessAsCustNumber(customerNumber);
		ArrayList<FoodCheck> foodChecks = foodCheckDao.queryFoodCheckAsCustomerNumber(customerNumber);
		map.put("business", businesses);
		map.put("foodcheck", foodChecks);
		String string = gson.toJson(map);
		out.print(string);

	}

}
