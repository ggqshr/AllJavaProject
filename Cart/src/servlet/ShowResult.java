package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Book;

/**
 * Servlet implementation class ShowResult
 */
public class ShowResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Book> cart = null;
		HttpSession session = request.getSession();
		int flag = 0;
		if(session == null)
			flag = 1;
		else
		{
			cart = (List<Book>) session.getAttribute("cart");
			if(cart == null)
			{
				flag = 1;
			}
		}
		if(flag==1)
		{
			out.print("对不起！您没有购买任何图书<a href='ShowBook'>点击回到购买页面</a><br>");
		}
		else
		{
			for (Book book : cart) {
				out.print(book.getNum()+book.getName()+book.getPrice()+"<br>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
