package com.Hotpot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.ComboDao;
import com.Hotpot.dao.impl.ComboDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Combo;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetComboName
 */
public class GetComboName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetComboName() {
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
		PrintWriter writer = response.getWriter();
		String ComboNumber = request.getParameter("comboNumber");
		ComboDao comboDao = new ComboDaoImpl();
		Combo combo = comboDao.queryComboAsNumber(ComboNumber);
		String json = gson.toJson(combo);
		writer.print(json);
	}

}
