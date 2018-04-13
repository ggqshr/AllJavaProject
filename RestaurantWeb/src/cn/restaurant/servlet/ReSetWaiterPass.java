package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Waiter;

public class ReSetWaiterPass extends HttpServlet {
	
	WaiterDao waiterDao=new WaiterDaoImpl();
	Waiter waiter=null;

	/**
	 * Constructor of the object.
	 */
	public ReSetWaiterPass() {
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
		
		String waiterName=request.getParameter("waiterName");
		waiter=waiterDao.waiterQueryAsName(waiterName);
		if(waiter!=null)
		{
			waiter.setWaiterPass("123456");
			waiterDao.waiterUpdate(waiter);
			out.println("<script>alert('密码重置成功')</script>");
		}
		else {
			out.println("<script>alert('不存在此员工，请重新输入')</script>");
			out.println("<script>location.href='reSetWaiterPass.jsp'</script>");
			return ;
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
