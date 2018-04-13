package com.Hotpot.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hotpot.dao.CustomerDao;
import com.Hotpot.dao.impl.CustomerDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Customer;
import com.google.gson.Gson;

/**
 * Servlet implementation class SignServlet
 */
public class SignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignServlet() {
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
//		response.setCharacterEncoding("text/html;charset=utf-8");
//		request.setCharacterEncoding("utf8");
			response.setContentType("application/json; charset=utf-8");
			
			Gson gson = new Gson();
			PrintWriter out = null;
				out = response.getWriter();
			//用这个才能正常显示中文
			BufferedReader br = null;
				br = new BufferedReader(new InputStreamReader(  
				        (ServletInputStream) request.getInputStream(), "utf-8"));
				// TODO Auto-generated catch block
			StringBuffer sb = new StringBuffer("");  
	        String temp;  
				while ((temp = br.readLine()) != null) {  
				    sb.append(temp);  
				// TODO Auto-generated catch block
			
			CustomerDao customerDao = new CustomerDaoImpl();
			Customer customer = gson.fromJson(sb.toString(), Customer.class);
			Customer jCustomer = customerDao.queryCustomerAsNumber(customer.getCustomerNumber());
			if(jCustomer==null){
				customerDao.insertCustomer(customer);
				out.print("ok");
				out.flush();
			}else {
				out.print("cz");
				out.flush();
			}
			
		}
	}
}

		

