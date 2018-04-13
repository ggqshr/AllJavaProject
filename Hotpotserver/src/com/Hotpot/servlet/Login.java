package com.Hotpot.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.CustomerDao;
import com.Hotpot.dao.impl.CustomerDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Customer;
import com.google.gson.Gson;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		CustomerDao customerDao = new CustomerDaoImpl();
		Customer customer = customerDao.queryCustomerAsNumber(username);
		if(customer!=null)
		{
			if(password.equals(customer.getCustomerPass()))
			{
				String cust = gson.toJson(customer);
				writer.print(cust);
			}
			else
			{
				writer.print("error");
			}
		}
		else
		{
			writer.print("null");
		}
		System.out.println(username+"   "+password);
	}

}
