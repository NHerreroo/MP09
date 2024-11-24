package TCP_UDP.AdivinaNumero;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        AdivinaCliente client = new AdivinaCliente();
        String host = "localhost"; // Dirección del servidor (puedes cambiarla a una IP específica)
        int port = 12345;           // Puerto en el que escucha el servidor

        client.init(host, port);
        System.out.println("Cliente UDP conectado al servidor en " + host + ":" + port);
        client.runClient();
    }
}
