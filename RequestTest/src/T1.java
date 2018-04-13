

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class T1
 */
public class T1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		ObjectInputStream in = new ObjectInputStream(request.getInputStream());
		PrintWriter out = response.getWriter();
		HashMap<String, String> map = null;
		String s = "login success";
		try {
			map = (HashMap<String, String>) in.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(map!=null&&!map.isEmpty())
		{
			String name = map.get("name");
			String pwd = map.get("pwd");
			System.out.println(name+": "+pwd);
			if(name.equals("123")&&pwd.equals("123"))
			{
				out.print(s);
			}
			else
			{
				out.print("file");
			}
		}
	
	}

}
