package SendFeiQ;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SocketSend {
public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		String str = "1.0:"+System.currentTimeMillis()+":gy:168.192.0.122:32:nihaogy";
		byte[] bs = str.getBytes();
		DatagramPacket datagramPacket = new DatagramPacket(bs, bs.length,InetAddress.getByName("127.0.0.1"),2425);
		socket.send(datagramPacket);
		socket.close();
}
}
