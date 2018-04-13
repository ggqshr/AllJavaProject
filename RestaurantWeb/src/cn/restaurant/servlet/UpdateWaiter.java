package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Waiter;

public class UpdateWaiter extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateWaiter() {
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
		HttpSession session=request.getSession();
		
		Waiter waiter=(Waiter) session.getAttribute("waiterIfm");
		String waiterPhoneString=request.getParameter("waiterPhone");
		String pattern5="^[0-9]{11}$";
		if(!waiterPhoneString.matches(pattern5)){
			out.println("<script>alert('电话格式错误')</script>");
			out.println("<script>location.href='updateWaiter.jsp'</script>");
			return ;
		}
		waiter.setWaiterPhone(waiterPhoneString);
		WaiterDao waiterDao=new WaiterDaoImpl();
		if(waiterDao.waiterUpdate(waiter)==true)
		{
			out.println("<script>alert('修改成功')</script>");
			return ;
		}
		else
		{
			out.println("<script>alert('修改失败')</script>");
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
