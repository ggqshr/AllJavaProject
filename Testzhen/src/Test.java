

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		wirteToFile wirteToFile = new wirteToFile();
		ArrayList<Integer> rssis = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		PrintWriter out = response.getWriter();
		out.print("ok");
		String data = request.getParameter("data");
		String delimter = "\1";
		int startp = data.indexOf(delimter);
		if(startp!=1)
		{
			int endp = data.lastIndexOf(delimter);
			if((endp-startp)-1>12)
			{
				String datatrimed = data.substring(startp+1, endp);
				String[] datasplits = datatrimed.split(delimter);
				for (int i = 0 ; i < datasplits.length;i++)
				{
					if(datasplits[i].length()>12)
					{
						map.clear();
						String mac = datasplits[i].substring(0, 12);
						map.put("mac", mac);
//						System.out.println(mac);
						byte[] datasplitbyte = datasplits[i].getBytes();
						rssis.clear();
						for (int j = 12; j < datasplitbyte.length;j++)
						{
							int rssi = datasplitbyte[j];
							rssis.add(rssi);
//							System.out.println(rssi);
						}
						map.put("rssi", rssis);
						wirteToFile.writeTo(map);
					}
				}
			}
		}
	}

}
