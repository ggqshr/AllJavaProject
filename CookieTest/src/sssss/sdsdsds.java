package sssss;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LastAccessServlet
 */
public class sdsdsds extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sdsdsds() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String lastac = null;
		Cookie[] cookies = request.getCookies();
		for(int i=0; cookies!=null&& i < cookies.length;i++)
		{
			if("lastac".equals(cookies[i].getName()))
			{
				lastac = cookies[i].getValue();
				break;
			}
		}
		if ( lastac == null)
		{
			response.getWriter().print("this is your frist time to acess this web");
		}
		else
		{
			response.getWriter().print("last time your acess this web is :"+lastac);
		}
		String cuString = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		Cookie cookie = new Cookie("lastac", cuString);
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
