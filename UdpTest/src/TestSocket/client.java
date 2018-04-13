package TestSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class client {
public static void main(String[] args) throws IOException {
	Socket socket = new Socket("127.0.0.1",7070);
	String string = "hello";
	byte[] bs = string.getBytes();
	byte[] b1 = new byte[3];
	OutputStream op = socket.getOutputStream();
	InputStream ip = socket.getInputStream();
	op.write(bs);
	ip.read(b1);
	for (byte b : b1) {
		System.out.print((char)b);
	}
	socket.close();
}
}
