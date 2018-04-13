package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Util;

import cn.restaurant.dao.BusinessDao;
import cn.restaurant.dao.ComboDao;
import cn.restaurant.dao.FoodCheckDao;
import cn.restaurant.dao.FoodDao;
import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.BusinessDaoImpl;
import cn.restaurant.dao.impl.ComboDaoImpl;
import cn.restaurant.dao.impl.FoodCheckDaoImpl;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Business;
import cn.restaurant.entity.Combo;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.FoodCheck;
import cn.restaurant.entity.Waiter;
import cn.restaurant.util.BaseDao;
import cn.restaurant.util.ComparatorCombo;
import cn.restaurant.util.ComparatorWaiter;
import cn.restaurant.util.WebUtil;



/**
 * <p>Title: BaseServlet</p>
 * <p>Description:基本页面转换Servlet </p>
 */
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {
	int test=1;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		//获取不同jsp上传的id
		
		String p = request.getParameter("p");
		String custNumber = request.getParameter("mis");
		String mos = request.getParameter("mos");
		String tms = request.getParameter("tms");
		String custNumber3 = request.getParameter("gbs");
		String custNumber4 = request.getParameter("cps");
		String q=request.getParameter("q");
		String af=request.getParameter("af");
		String df=request.getParameter("df");
		String dc=request.getParameter("dc");
		String dw=request.getParameter("dw");
		String of=request.getParameter("of");
		String oc=request.getParameter("oc");
		String tc=request.getParameter("tc");
		String wpc=request.getParameter("wpc");
		String uwp=request.getParameter("uwp");
		if(p!=null&&!p.equals("")){
			WebUtil.forward(request, response, "addWaiter.jsp");
		}
				
		else if(custNumber!=null&&!custNumber.equals("")){
			session.setAttribute("waiterNumber", custNumber);
			WebUtil.forward(request, response, "orderFood.jsp");
		}
		else if(df!=null&&!df.equals("")){
			FoodDao foodDao=new FoodDaoImpl();
			List<Food> foods=foodDao.foodQueryAsType("food");
			session.setAttribute("list", foods);
			WebUtil.forward(request, response, "deleteFood.jsp");
		}
		else if(dw!=null&&!dw.equals("")){
			String flagString=request.getParameter("ggq");
			if(flagString.equals("waiter"))
			{
				BusinessDao businessDao=new BusinessDaoImpl();
				ComparatorWaiter comparatorWaiter=new ComparatorWaiter();
				List<Waiter> resultWaiter=businessDao.businessQueryAsWaiterNumber();
				Collections.sort(resultWaiter,comparatorWaiter);
				session.setAttribute("list", resultWaiter);
				session.setAttribute("adr", "manCount.jsp");
				WebUtil.forward(request, response, "waiterDispaly.jsp");
			}
			else {
				BusinessDao businessDao=new BusinessDaoImpl();
				ComparatorCombo comparatorWaiter=new ComparatorCombo();
				List<Combo> combos=businessDao.businessQueryAsCombo();
				Collections.sort(combos,comparatorWaiter);
				session.setAttribute("list", combos);
				session.setAttribute("adr", "manCount.jsp");
				WebUtil.forward(request, response, "comboDispaly.jsp");
			}
		}
		else if(oc!=null&&!oc.equals("")){
			String flagString=request.getParameter("ggq");
			String waiterNumberString=(String) session.getAttribute("waiterNumber");
			ComboDao comboDao=new ComboDaoImpl();
			Combo combo=null;
			combo=comboDao.comboQueryAsNumber(flagString);
			session.setAttribute("comboIfm1", combo);
			session.setAttribute("adr1", "choseCombo.jsp");
			WebUtil.forward(request, response, "typeChose.jsp");
		}
		else if(tc!=null&&!tc.equals("")){
			String flagString=request.getParameter("ggq");
			String waiterNumberString=(String) session.getAttribute("waiterNumber");
			FoodDao foodDao=new FoodDaoImpl();
			BusinessDao businessDao=new BusinessDaoImpl();
			
			List<FoodCheck> foodChecks=null;
			 Combo combo=(Combo)session.getAttribute("comboIfm1");
			 FoodCheckDao foodCheckDao=new FoodCheckDaoImpl();
			 BaseDao baseDao=new BaseDao();
			 int sum=combo.getMeatNum()+combo.getVegetableNum()+combo.getNoodlesNum()+combo.getSoupNum();
			 if(flagString.equals("sub"))
			 {
				
				 foodChecks=(List<FoodCheck>) session.getAttribute("foodCheck");
				 if(foodChecks!=null)
				 {
					if(foodChecks.size()<sum)
					{
						out.println("<script>alert('没有构成套餐')</script>");
						out.println("<script>location.href='choseCombo.jsp'</script>");
					}
					else 
					{
						Business business=new Business();
						business.setWaiterNumber(waiterNumberString);
						business.setBusinessType("combo");
						business.setComboNumber(combo.getComboNumber());
						business.setFoodSum(1);
						business.setBusinessMoney(combo.getComboPrice());
						Object[] paramsObjects=businessDao.businessInsert(business);
						for (Object object : paramsObjects) {
							System.out.println(object);
						}
						try {
							
							baseDao.util.beginTran();
							
							
							for (FoodCheck foodcheck : foodChecks)  {
								foodcheck.setBusinessNumber((String) paramsObjects[0]);
								foodcheck.setWaiterNumber((String) paramsObjects[1]);
								
//								foodcheck.setCheckDate((String) paramsObjects[2]);
								foodCheckDao.FoodCheckInsert(foodcheck);
								
							}
							
							out.printf("<script>alert('结账成功,金额为：%f')</script>",combo.getComboPrice());
							baseDao.util.commitTran();
						} catch (Exception e) {
							out.println("<script>alert('结账失败')</script>");
							try {
								baseDao.util.rollBack();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								
								e1.printStackTrace();
							}
							// TODO: handle exception
						}
						
					}
				 }
			 }
			 else {
				 List<Food> foods=foodDao.foodQueryAsType(flagString);
				 if(flagString.equals("noodles"))
				 {
					 session.setAttribute("comboIfm", String.valueOf(combo.getNoodlesNum()));
				 }
				 else if(flagString.equals("meat")){
					session.setAttribute("comboIfm", String.valueOf(combo.getMeatNum()));
				}
				 else  if(flagString.equals("vegetable")){
					session.setAttribute("comboIfm", String.valueOf(combo.getVegetableNum()));
				}
				 else if(flagString.equals("soup"))
				 {
					 session.setAttribute("comboIfm", String.valueOf(combo.getSoupNum()));
				 }
				 session.setAttribute("adr2", "typeChose.jsp");
				 session.setAttribute("waiterNumber", waiterNumberString);
				 session.setAttribute("foodType", foods);
				 WebUtil.forward(request, response, "choseTypeFood.jsp");
			}
		}
		else if(of!=null&&!of.equals("")){
			String flagString=request.getParameter("ggq");
			String waiterNumberString=(String) session.getAttribute("waiterNumber");
			if(flagString.equals("food"))
			{
				FoodDao foodDao=new FoodDaoImpl();
				List<Food> foods=foodDao.foodQueryAsType("food");
				session.setAttribute("list", foods);
				session.setAttribute("adr", "orderFood.jsp");
				session.setAttribute("waiterNumber", waiterNumberString);
				WebUtil.forward(request, response, "choseFood.jsp");
			}
			else {
				BusinessDao businessDao=new BusinessDaoImpl();
				ComboDao comboDao=new ComboDaoImpl();
				ComparatorCombo comparatorWaiter=new ComparatorCombo();
				List<Combo> combos=comboDao.comboQueryAll();
				Collections.sort(combos,comparatorWaiter);
				session.setAttribute("list", combos);
				session.setAttribute("adr", "orderFood.jsp");
				WebUtil.forward(request, response, "choseCombo.jsp");
			}
		}
		else if(dc!=null&&!dc.equals("")){
			ComboDao comboDao=new ComboDaoImpl();
			List<Combo> foods=comboDao.comboQueryAll();
			session.setAttribute("list", foods);
			WebUtil.forward(request, response, "deleteCombo.jsp");
		}
		else if(af!=null&&!af.equals("")){
			WebUtil.forward(request, response, "addFood.jsp");
		}
		else if(wpc!=null&&!wpc.equals("")){
			Waiter waiter=(Waiter) session.getAttribute("waiterIfm");
			String waiterPassString=request.getParameter("waiterOldPass");
			
			if( waiter.getWaiterPass().equals(waiterPassString))
			{
				session.setAttribute("waiterIfm", waiter);
				WebUtil.forward(request, response, "updateWaiterPwd.jsp");
			}
			else {
				out.println("<script>alert('密码不正确，请重新输入')</script>");
				out.println("<script>location.href='waiterPwdCheck.jsp'</script>");
				return ;
			}
			
		}
		else if(q!=null&&!q.equals("")){
			WebUtil.forward(request, response, "reSetWaiterPass.jsp");
		}
				
		else if(mos!=null&&!mos.equals("")){
			WaiterDao waiterDao=new WaiterDaoImpl();
			Waiter waiter=waiterDao.waiterQueryAsNumber(mos);
			session.setAttribute("waiterIfm",waiter );
			WebUtil.forward(request, response, "updateWaiter.jsp");
		}
				
		else if(tms!=null&&!tms.equals("")){
			WaiterDao waiterDao=new WaiterDaoImpl();
			Waiter waiter=waiterDao.waiterQueryAsNumber(tms);
			session.setAttribute("waiterIfm", waiter);
			WebUtil.forward(request, response, "waiterPwdCheck.jsp");
		}
				
		else if(custNumber3!=null&&!custNumber3.equals("")){
			session.setAttribute("custNumber3", custNumber3);
			WebUtil.forward(request, response, "getBill.jsp");
		}	
		else if(uwp!=null&&!uwp.equals("")){
			Waiter waiter=(Waiter) session.getAttribute("waiterIfm");
			String pwdString=request.getParameter("waiterNewPwd");
			waiter.setWaiterPass(pwdString);
			WaiterDao waiterDao=new WaiterDaoImpl();
			if(waiterDao.waiterUpdate(waiter)==true)
			out.print("<script>top.location.href='login.jsp'</script>");
			else {
				out.print("<script>alert('修改失败')</script>");
			}
		}	
		
		else if(custNumber4!=null&&!custNumber4.equals("")){
			session.setAttribute("custNumber4", custNumber4);
			WebUtil.forward(request, response, "changePwd.jsp");
		}		
	}
}
