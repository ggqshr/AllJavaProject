package ÍøÂç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class fw {
	public static void main(String []args)
	{
	try {
		ServerSocket s=new ServerSocket(5500);
		Socket con=s.accept();
		BufferedReader io=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter os=new PrintWriter(con.getOutputStream());
		BufferedReader sin=new BufferedReader(new InputStreamReader(con.getInputStream()));
		String line=io.readLine();
		while (!line.equals("bye"))
		{
			os.println(line);
			os.flush();
			System.out.println("Ë§¸ç£º"+line);
			System.out.println("áó×Ó:"+sin.readLine());
			line=io.readLine();
		}
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	}

}
