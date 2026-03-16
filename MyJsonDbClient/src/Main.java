import Connection.ClientConnection;

void main() {
    var connection = new ClientConnection("127.0.0.1", 23456);
    connection.StartClientConnection();
}
