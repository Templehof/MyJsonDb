package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection {
    private final String SERVER_ADDRESS;
    private final int SERVER_PORT;

    public ClientConnection(String serverAddress, int serverPort) {
        SERVER_ADDRESS = serverAddress;
        SERVER_PORT = serverPort;
    }

    public void StartClientConnection () {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream())
        ) {
            System.out.println("Client started!");
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String msg = scanner.nextLine();
                output.writeUTF(msg);
                System.out.println("Sent: " + msg);
                String receivedMsg = input.readUTF();
                System.out.println("Received: " + receivedMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
