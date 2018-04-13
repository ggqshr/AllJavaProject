package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Book;
import util.Books;

/**
 * Servlet implementation class Cartservlet
 */
public class Cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartservlet() {
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
		HttpSession session = request.getSession();
		String  id = (String)request.getParameter("id");
		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		ArrayList<Book> cart = (ArrayList<Book>) session.getAttribute("cart");
		if(cart == null)
		{
			cart = new ArrayList<>();
			Books books = new Books();
			cart.add(books.getBookById(Integer.valueOf(id)));
			session.setAttribute("cart", cart);
		}
		else
		{
			Books books = new Books();
			cart.add(books.getBookById(Integer.valueOf(id)));
		}
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		response.sendRedirect("/CartTest/ResultServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
