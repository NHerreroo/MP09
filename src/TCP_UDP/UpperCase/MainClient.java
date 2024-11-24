package TCP_UDP.UpperCase;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args) {
        DatagramSocketClient client = new DatagramSocketClient();
        try {
            String host = "localhost"; // Dirección del servidor (puedes cambiarla a una IP específica)
            int port = 12345;           // Puerto en el que escucha el servidor

            client.init(host, port);
            System.out.println("Cliente UDP conectado al servidor en " + host + ":" + port);
            client.runClient();
        } catch (SocketException e) {
            System.out.println("Error al iniciar el cliente: " + e.getMessage());
        } catch (UnknownHostException e) {
            System.out.println("Servidor desconocido: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error durante la comunicación: " + e.getMessage());
        }
    }
}
