package TCP_UDP.AdivinaNumero;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class AdivinaCliente {
    private InetAddress serverIP;
    private int serverPort;
    private DatagramSocket socket;

    private Scanner sc = new Scanner(System.in);

    public void init(String host, int port) throws SocketException, UnknownHostException {
        serverIP = InetAddress.getByName(host);
        serverPort = port;
        socket = new DatagramSocket();
    }

    public void runClient() throws IOException {
        byte[] receivedData = new byte[1024];
        byte[] sendingData;

        while (true) {
            // Pedir al usuario que introduzca un número
            System.out.print("Adivina el número: ");
            String userGuess = sc.nextLine();

            // Preparar el mensaje para el servidor
            sendingData = userGuess.getBytes();

            // Enviar el número al servidor
            DatagramPacket packet = new DatagramPacket(sendingData, sendingData.length, serverIP, serverPort);
            socket.send(packet);

            // Recibir respuesta del servidor
            packet = new DatagramPacket(receivedData, receivedData.length);
            socket.receive(packet);

            String response = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Respuesta del servidor: " + response);

            // Finalizar si el número es correcto
            if ("¡Correcto!".equals(response)) {
                System.out.println("¡Has ganado! Fin del juego.");
                break;
            }
        }

        socket.close();
    }
}
