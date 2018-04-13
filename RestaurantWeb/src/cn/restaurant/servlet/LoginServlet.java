package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Waiter;
import cn.restaurant.service.AdminService;
import cn.restaurant.service.WaiterService;
import cn.restaurant.service.impl.AdminServiceImpl;
import cn.restaurant.service.impl.WaiterServiceImpl;

public class LoginServlet extends HttpServlet {
	
	AdminService adminService=new AdminServiceImpl();
	WaiterService waiterService=new WaiterServiceImpl();
	WaiterDao waiterDao=new WaiterDaoImpl();
	Waiter waiter=null;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String userNumber = request.getParameter("userNumber");
		String userPwd = request.getParameter("password");
		if(adminService.adminLogIn(userNumber, userPwd)==true)
		{
			String adminNameString="冯文哲";
			//System.out.println("管理员登陆成功");
			session.setAttribute("adminName",adminNameString);
			RequestDispatcher rt=request.getRequestDispatcher("adminIndex.jsp");
			rt.forward(request, response);
		}
		else if(waiterDao.waiterLogin(userNumber, userPwd)==true)
		{
			waiter=waiterDao.waiterQueryAsNumber(userNumber);
			//System.out.println("服务员登陆成功");
			session.setAttribute("waiterName",waiter);
			RequestDispatcher rt=request.getRequestDispatcher("userIndex.jsp");
			rt.forward(request, response);
		}
		else {
			RequestDispatcher rt=request.getRequestDispatcher("loginFiled.jsp");
			rt.forward(request, response);
		}
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
