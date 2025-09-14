package chatHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientChat {
	void ChatConnect (String ip, int port) {
		try {
			Socket s = new Socket(ip, port);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String msg = br.readLine();
			
			OutputStream os = s.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println(msg);
			
			InputStream receiver = s.getInputStream();
			InputStreamReader receiver_isr = new InputStreamReader(receiver);
			BufferedReader receiver_reader = new BufferedReader(receiver_isr);
			String receive_msg = receiver_reader.readLine();
			System.out.println(receive_msg);
//			while(!receive_msg.equals("exit") || !msg.equals("exit")) {
//				s.close();
//			}
			if(receive_msg.equals("exit") || msg.equals("exit")) s.close();
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
//	public static void main(String[] args) {
//		ChatConnect("127.0.0.1", 3000);
//	}
}