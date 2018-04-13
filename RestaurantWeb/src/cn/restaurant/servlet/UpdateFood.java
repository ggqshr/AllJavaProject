package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.restaurant.dao.FoodDao;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.entity.Food;

public class UpdateFood extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateFood() {
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
		FoodDao foodDao=new FoodDaoImpl();
		String foodName=request.getParameter("foodName");
		Food food1=null;
		food1=foodDao.foodQueryAsName(foodName);


			
	
			
			String foodPrice=request.getParameter("foodPrice");
			String foodBanlance=request.getParameter("foodBanlance");
			Food food=(Food)session.getAttribute("foodIfm");
			if(food.getFoodName().equals(foodName))
			{
				food.setFoodName(foodName);
				food.setFoodPrice(Float.valueOf(foodPrice));
				food.setFoodBanlance(Integer.valueOf(foodBanlance));
				if(foodDao.foodUpdate(food)==true)
				{
					out.println("<script>alert('修改成功')</script>");
					out.println("<script>location.href='manFood.jsp'</script>");
				}
				else {
					out.println("<script>alert('修改失败')</script>");
					out.println("<script>location.href='manFood.jsp'</script>");
					return ;
				}
			}
			else {
				if(food1!=null)
				{
					out.println("<script>alert('对应食物名已存在，请重新输入')</script>");
					out.println("<script>location.href='updateFood.jsp'</script>");
					return ;
				}
				else {
					food.setFoodName(foodName);
					food.setFoodPrice(Float.valueOf(foodPrice));
					food.setFoodBanlance(Integer.valueOf(foodBanlance));
					if(foodDao.foodUpdate(food)==true)
					{
						out.println("<script>alert('修改成功')</script>");
						out.println("<script>location.href='manFood.jsp'</script>");
						return ;
					}
					else {
						out.println("<script>alert('修改失败')</script>");
						out.println("<script>location.href='manFood.jsp'</script>");
					}
				}
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
