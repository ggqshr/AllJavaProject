package TcpFile;import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import TestSocket.client;

public class Client {
public static void main(String[] args) throws Exception, IOException {
	InputStream io = null;
	OutputStream out = null;
	File file = new File("Client\\hello.txt");
	io = new FileInputStream(file);
	Socket socket = new Socket("localhost", 7070);
	out = socket.getOutputStream();
	byte b = -1;
	while((b = (byte)io.read())!=-1)
	{
		out.write(b);
	}
//	byte[] b1 = io.toString().getBytes();
//	out.write(b1);
	socket.close();
	io.close();
}
}
