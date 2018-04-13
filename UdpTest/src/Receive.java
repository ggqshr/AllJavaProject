import java.awt.event.FocusEvent;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(9090);
		byte[] b = new byte[5];
		DatagramPacket packet = new DatagramPacket(b, b.length);
		socket.receive(packet);
		socket.close();
		for (byte c : b) {
			System.out.print((char)c);
		}
	}
	
}
