package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    private final int PORT;

    public Connection(int PORT) {
        this.PORT = PORT;
    }

    public void StartConnection() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
