package TcpFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
public static void main(String[] args) throws Exception {
	OutputStream outputStream = null;
	InputStream io = null;
	File file = new File("Server\\hello.txt");
	ServerSocket serverSocket = new ServerSocket(7070);
	Socket socket = serverSocket.accept();
	io = socket.getInputStream();
	outputStream = new FileOutputStream(file);
	byte b = -1 ;
	while((b=(byte)io.read())!=-1)
	{
		outputStream.write(b);
	}
	serverSocket.close();
	outputStream.flush();
	outputStream.close();
}
}
