package cn.restaurant.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.restaurant.entity.Waiter;
import cn.restaurant.service.AdminService;
import cn.restaurant.service.impl.AdminServiceImpl;

/**
 * <p>Title: AddCustServlet</p>
 * <p>Description:增加用户Servlet</p>
 */
@SuppressWarnings("serial")
public class AddWaiter extends HttpServlet {
	Waiter waiter=new Waiter();
	AdminService adminService=new AdminServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	
		String pattern1 = "^[a-zA-Z\u4e00-\u9fa5]{1,}$";
  		String pattern = "^[0-9]{6}$";
  		String pattern3 ="男";
  		String pattern4="女";
  		String pattern5="^[0-9]{11}$";
  		String waiterName = request.getParameter("waiterName");
  		String waiterPwd = request.getParameter("waiterPwd");
  		String waiterSex = request.getParameter("waiterSex");
  		String waiterPhone=request.getParameter("waiterPhone");
		if (!waiterName.matches(pattern1)) {
			out.println("<script>alert('员工姓名格式错误')</script>");
			out.println("<script>location.href='addWaiter.jsp'</script>");
			return ;
		}
		if (!waiterPwd.matches(pattern)) {
			out.println("<script>alert('员工密码格式错误')</script>");
			out.println("<script>location.href='addWaiter.jsp'</script>");
			return ;
		}
		if (!waiterSex.equals(pattern3)&&!waiterSex.equals(pattern4)) {
			out.println("<script>alert('员工性别格式错误')</script>");
			out.println("<script>location.href='addWaiter.jsp'</script>");
			return ;
		}
		if(!waiterPhone.matches(pattern5)){
			out.println("<script>alert('员工电话格式错误')</script>");
			out.println("<script>location.href='addWaiter.jsp'</script>");
			return ;
		}
  		waiter.setWaiterName(waiterName);
  		waiter.setWaiterSex(waiterSex);
  		waiter.setWaiterPass(waiterPwd);
  		waiter.setWaiterPhone(waiterPhone);
	
		if(adminService.addWaiter(waiter)==true){
			out.println("<script>alert('添加成功')</script>");
		}else{
			out.println("<script>alert('添加失败')</script>");
		}
	}
}
