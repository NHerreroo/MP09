package TCP_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Locale;

public class DatagramSocketServer {
    DatagramSocket socket;

    public void init(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void runServer() throws IOException {
        byte[] receivingData = new byte[1024];
        byte[] sendingData;
        InetAddress clientIP;
        int clientPort;

        // El servidor atiende en el puerto indefinidamente
        while (true) {
            // Creación del paquete para recibir los datos
            DatagramPacket packet = new DatagramPacket(receivingData, 1024);
            // Espera de los datos
            socket.receive(packet);

            // Conversión de los datos recibidos a String y lo imprimimos
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Mensaje recibido: " + receivedMessage);

            // Procesamiento de los datos recibidos (convertir a mayúsculas)
            sendingData = processData(packet.getData(), packet.getLength());

            // Obtención de la dirección del cliente
            clientIP = packet.getAddress();
            // Obtención del puerto del cliente
            clientPort = packet.getPort();
            // Creación del paquete para enviar la respuesta
            packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
            // Envío de la respuesta
            socket.send(packet);
        }
    }

    private byte[] processData(byte[] data, int length) {
        // Convertir los bytes a String y hacer upper case
        String mymssg = new String(data, 0, length).toUpperCase(Locale.ROOT);
        // Retornar la versión en mayúsculas en bytes
        return mymssg.getBytes();
    }
}