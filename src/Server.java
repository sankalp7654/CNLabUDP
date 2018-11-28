import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		try {
		while(true) {
			System.out.println("Enter the message to be sent");
			String string = scanner.nextLine();
			
			
			byte [] buffer = string.getBytes();
			InetAddress address = InetAddress.getLocalHost();
			int port = 6969;
			DatagramSocket datagramSocket = new DatagramSocket();
			DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, port);
			datagramSocket.send(datagramPacket);
			if(string.equalsIgnoreCase("exit")) {
				datagramSocket.close();
				break;
			}
				
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		DatagramSocket serverSocket = new DatagramSocket(9999);
//		
//		System.out.println("Server is up and running");
//		
//		byte [] receivedByte = new byte[1024];
//		DatagramPacket receivedPacket = new DatagramPacket(receivedByte, receivedByte.length);
//		serverSocket.receive(receivedPacket);
//		
//		String receivedData = new String(receivedByte, 0, receivedByte.length);
//		System.out.println("Packet received from Client: " + receivedData);
//		
//		int number = Integer.parseInt(receivedData.trim());
//		
//		byte[] square = ((number*number) + "").toString().trim().getBytes();
//		
//		InetAddress serverAddress = InetAddress.getLocalHost();
//		DatagramPacket sendPacket = new DatagramPacket(square, square.length, serverAddress, receivedPacket.getPort());
//		serverSocket.send(sendPacket);
//		
//		System.out.println("Square has been sent to Client");
//		serverSocket.close();
	}

}
