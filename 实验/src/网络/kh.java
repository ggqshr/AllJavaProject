package ÍøÂç;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class kh {

	public static void main(String[] args) {
		try {
			Socket s=new Socket("192.168.233.1",5500);
			BufferedReader io=new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os=new PrintWriter(s.getOutputStream());
			BufferedReader sin=new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line=io.readLine();
			while (!line.equals("bye"))
			{
				os.println(line);
				os.flush();
				System.out.println("DPS£º"+line);
				System.out.println("GGQ:"+sin.readLine());
				line=io.readLine();
			}
			io.close();
			os.close();
			sin.close();
			s.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}

}
