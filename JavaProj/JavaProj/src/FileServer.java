import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	private static ServerSocket serverSocket, serverSocket1;
	private static Socket clientSocket = null;
	private static Socket clientSocket1 = null;

	public static void main(String[] args) throws IOException {

		try {
			serverSocket = new ServerSocket(8888);
			serverSocket1 = new ServerSocket(8080);
			System.out.println("Server started...Waiting for Connection");
			} catch (Exception e) {
			 System.err.println("Port already in use.");
			 System.exit(1);
			 }

			while (true) {
			 try {
				if (serverSocket.getLocalPort()==8888) {
					clientSocket = serverSocket.accept();

					System.out.println("Accepted connection : " + clientSocket);
					Thread t = new Thread(new CLIENTConnection(clientSocket));
					t.start();
				} else {
					clientSocket1 = serverSocket1.accept();
					System.out
							.println("Accepted connection : " + clientSocket1);

					Thread t1 = new Thread(new CLIENTConnection1(clientSocket1));
					 t1.start();
				}

				// t.start();

			}
		 catch (Exception e) {
			System.err.println("Error in connection attempt.");
		}
	}
  }
}
