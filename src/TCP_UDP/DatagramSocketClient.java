package TCP_UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramSocketClient {
    InetAddress serverIP;
    int serverPort;
    DatagramSocket socket;

    Scanner sc = new Scanner(System.in);

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte[] receivedData = new byte[1024];
        byte[] sendingData;

        // Al inicio
        sendingData = getFirstRequest(sc);
        // El cliente atiende hasta que decida finalizar
        while (mustContinue(sendingData)) {
            DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
            // Envío del mensaje al servidor
            socket.send(packet);

            // Creación del paquete para recibir la respuesta del servidor
            packet = new DatagramPacket(receivedData, 1024);
            // Espera de la respuesta
            socket.receive(packet);

            // Mostrar la respuesta del servidor
            String response = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Respuesta del servidor: " + response);

            // Pide al usuario que introduzca un nuevo mensaje
            System.out.println("Escribe tu siguiente mensaje:");
            String newMessage = sc.nextLine();

            // Prepara el siguiente mensaje
            sendingData = newMessage.getBytes();
        }
        socket.close();
        System.out.println("Cliente desconectado.");
    }

    private byte[] getFirstRequest(Scanner sc) {
        // Proceso diferente para cada aplicación
        System.out.println("Escribe tu mensaje:");
        byte[] text = sc.nextLine().getBytes();
        return text;
    }

    private boolean mustContinue(byte[] sendingData) {
        // Convierte sendingData a String antes de comparar
        String message = new String(sendingData).trim();

        // Compara el contenido del mensaje
        return !message.equalsIgnoreCase("Adeu");
    }
}