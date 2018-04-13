package ÍøÂç;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TEST {

	public static void main(String[] args) {
		try {
			InetAddress i=InetAddress.getLocalHost();
			System.out.println(i);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
