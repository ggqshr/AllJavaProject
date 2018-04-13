package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.restaurant.dao.BusinessDao;
import cn.restaurant.dao.FoodDao;
import cn.restaurant.dao.impl.BusinessDaoImpl;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.entity.Business;
import cn.restaurant.entity.Food;
import cn.restaurant.util.WebUtil;

public class OrderFood extends HttpServlet {
	List<Food> foods=null;
	private  float countSubString(String arm,String waiterNumber){  
		BusinessDao businessDao=new BusinessDaoImpl();
		Business business=null;
		Food food=null;
		FoodDao foodDao=new FoodDaoImpl();
		foods=new ArrayList<>();
		float sumMoney=0;
		
        StringBuffer stringBuffer=new StringBuffer();  
        stringBuffer.append(arm).append(",");  
        String totalString=stringBuffer.toString();  
        System.out.println("组拼后的字符串为:"+totalString);  
          
        while (totalString.length()>0) {  
            //得到第一个字符串比如"香蕉、"  
            int index=totalString.indexOf(",");  
            String foodName=totalString.substring(0,index+1);  
              if(foodName.length()>0)
              {
            	  Pattern pattern = Pattern.compile(foodName);    
                  Matcher matcher = pattern.matcher(totalString);    
                  int count=0;  
                  while(matcher.find()){  
                      count++;  
                  }  
                  totalString= totalString.replaceAll(foodName, "");  
                  System.out.println("食品名字为:"+foodName+",出现次数为:"+count);  
                  String foodNumber=foodName.replace(",", "");
                  food=foodDao.foodQueryAsNumber(foodNumber);
                  food.setFoodBanlance(count);
                  foods.add(food);
                  business=new Business();
                  business.setWaiterNumber(waiterNumber);
                  business.setBusinessType("food");
                  business.setFoodNumber(foodNumber);
                  business.setFoodSum(count);
                  business.setBusinessMoney(food.getFoodPrice()*count);
                  sumMoney+=food.getFoodPrice()*count;
                 // businessDao.businessInsert(business);
                  System.out.println("统计删除后字符串为:totalString="+totalString);  
                  System.out.println("===============================");  
              }
           
        } 
        return sumMoney;
    } 

	/**
	 * Constructor of the object.
	 */
	public OrderFood() {
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
		String foodnameStrings=(String)request.getParameter("ggq");
		foodnameStrings=foodnameStrings.substring(1, foodnameStrings.length());
		System.out.println(foodnameStrings);
		String[] fStrings=foodnameStrings.split(",");
		String waiterNumber=(String)session.getAttribute("waiterNumber");
		Float money=countSubString(foodnameStrings,waiterNumber);
		session.setAttribute("money", money.toString());
		session.setAttribute("list", foods);
		session.setAttribute("foodIfm", foodnameStrings);
		WebUtil.forward(request, response, "foodCheck.jsp");
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
