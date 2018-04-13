import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		String string = "hello";
		byte[] b = string.getBytes();
		DatagramPacket packet = new DatagramPacket(b, b.length,InetAddress.getByName("localhost"),9090);
		socket.send(packet);
		socket.close();
	}



}
