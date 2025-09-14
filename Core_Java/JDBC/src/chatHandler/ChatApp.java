package chatHandler;

//public class ChatApp {
//	public static void main(String[] args) {
//		ClientChat cc = new ClientChat();
//		ServerChat sc = new ServerChat();
//		
//		sc.ChatConnect(3000);
//		cc.ChatConnect("127.0.0.1", 3000);
//	}
//}

//package chatHandler;

public class ChatApp {
    public static void main(String[] args) {
        ServerChat sc = new ServerChat();
        ClientChat cc = new ClientChat();

        // Run server in a separate thread
        new Thread(() -> sc.ChatConnect(3000)).start();

        try {
            Thread.sleep(1000); // small delay to ensure server starts
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Now run client
        cc.ChatConnect("127.0.0.1", 3000);
    }
}
