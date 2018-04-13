package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.restaurant.dao.FoodDao;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.entity.Food;

public class AddFood extends HttpServlet {

	Food food=null;
	FoodDao foodDao=new FoodDaoImpl();
	/**
	 * Constructor of the object.
	 */
	public AddFood() {
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
		
		String foodName=request.getParameter("foodName");
		String foodType=request.getParameter("foodType");
		String foodPrice=request.getParameter("foodPrice");
		String foodBanlanceString=request.getParameter("foodBanlance");
		
		food=foodDao.foodQueryAsName(foodName);
		if(food!=null)
		{
			out.println("<script>alert('此食物已存在，请重新输入')</script>");
			out.println("<script>location.href='addFood.jsp'</script>");
			return ;
		}
		if(foodType.equals("noodles")&&!(Float.valueOf(foodPrice)>=1&&Float.valueOf(foodPrice)<=2))
		{
			out.println("<script>alert('价格输入错误，面点应该在1-2元之间')</script>");
			out.println("<script>location.href='addFood.jsp'</script>");
			return ;
		}
		else if(foodType.equals("meat")&&!(Float.valueOf(foodPrice)>=7&&Float.valueOf(foodPrice)<=8))
		{
			out.println("<script>alert('价格输入错误，荤菜应该在7-8元之间')</script>");
			out.println("<script>location.href='addFood.jsp'</script>");
			return ;
		}
		else if(foodType.equals("vegetable")&&!(Float.valueOf(foodPrice)>=3&&Float.valueOf(foodPrice)<=4))
		{
			out.println("<script>alert('价格输入错误，素菜应该在3-4元之间')</script>");
			out.println("<script>location.href='addFood.jsp'</script>");
			return ;
		}
		else if(foodType.equals("soup")&&!(Float.valueOf(foodPrice)>=1&&Float.valueOf(foodPrice)<=2))
		{
			out.println("<script>alert('价格输入错误，汤菜应该在1-2元之间')</script>");
			out.println("<script>location.href='addFood.jsp'</script>");
			return ;
		}
		food=new Food();
		food.setFoodName(foodName);
		food.setFoodType(foodType);
		food.setFoodPrice(Float.valueOf(foodPrice));
		food.setFoodBanlance(Integer.valueOf(foodBanlanceString));
		if(foodDao.foodInsert(food)==true)
			{
			out.println("<script>alert('添加成功')</script>");
			out.println("<script>location.href='manFood.jsp'</script>");
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
