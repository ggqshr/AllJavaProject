package TestSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws IOException {
	ServerSocket serverSocket = new ServerSocket(7070);
	Socket socket = serverSocket.accept();
	InputStream ip = socket.getInputStream();
	OutputStream op = socket.getOutputStream();
	String str = "hi";
	byte[] b = new byte[5];
	byte[] b1 = str.getBytes();
	ip.read(b);
	for (byte c : b) {
		System.out.print((char)c);
	}
	op.write(b1);
	serverSocket.close();
}
}
