package TCP_UDP;

import java.io.IOException;
import java.net.SocketException;

public class MainServer {
    public static void main(String[] args) {
        DatagramSocketServer server = new DatagramSocketServer();
        try {
            int port = 12345; // Puerto en el que escucha el servidor
            server.init(port);
            System.out.println("Servidor UDP escuchando en el puerto " + port);
            server.runServer();
        } catch (SocketException e) {
            System.out.println("Error al iniciar el servidor: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error durante la comunicación: " + e.getMessage());
        }
    }
}
