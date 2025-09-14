package chatHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChat {
	void ChatConnect(int port) {
		try {
			ServerSocket ss = new ServerSocket(port);
			Socket s = ss.accept();
			
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Client said :-"+br.readLine());
			
			InputStreamReader send_isr = new InputStreamReader(System.in);
			BufferedReader send_br = new BufferedReader(send_isr);
			String send_msg = send_br.readLine();
			OutputStream os = s.getOutputStream();
			PrintStream ps = new PrintStream(os);
			ps.println(send_msg);
			
//			while(!send_msg.equals("exit") || !br.readLine().equals("exit")) {
//				s.close();
//				ss.close();
//			}
			if(send_msg.equals("exit") || br.readLine().equals("exit")) {
				s.close();
				ss.close();
			}
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
//	public static void main(String[] args) {
//		ChatConnect( 3000);
//	}
}
