package Connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
            System.out.println("Server Started on port " + PORT);
            while (true) {
                try (
                        Socket socket = server.accept();
                        DataInputStream input = new DataInputStream(socket.getInputStream());
                        DataOutputStream output = new DataOutputStream(socket.getOutputStream())
                ) {
                    try {
                        System.out.println("Connection Established: " + socket.getInetAddress() + ", " + socket.getPort());
                        while (true) {
                            var msg = input.readUTF();
                            System.out.println("Message Received: " + msg);
                            output.writeUTF(msg);
                        }
                    } catch (Exception e) {
                        System.out.println("Connection closed");
                    }
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
