package TCP_UDP.AdivinaNumero;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class AdivinaServer {

    private DatagramSocket socket;
    private int numberToGuess;

    public void init(int port) throws SocketException {
        numberToGuess = generateNumber();
        System.out.println("Número generado: " + numberToGuess); // Solo para pruebas
        socket = new DatagramSocket(port);
    }

    public void runServer() throws IOException {
        byte[] receivingData = new byte[1024];
        byte[] sendingData;
        InetAddress clientIP;
        int clientPort;

        while (true) {
            // Recibir datos del cliente
            DatagramPacket packet = new DatagramPacket(receivingData, receivingData.length);
            socket.receive(packet);

            String receivedMessage = new String(packet.getData(), 0, packet.getLength()).trim();
            System.out.println("Número recibido: " + receivedMessage);

            // Procesar el número recibido
            String response = processGuess(receivedMessage);

            // Preparar la respuesta
            sendingData = response.getBytes();
            clientIP = packet.getAddress();
            clientPort = packet.getPort();

            // Enviar la respuesta
            packet = new DatagramPacket(sendingData, sendingData.length, clientIP, clientPort);
            socket.send(packet);

            // Finalizar si el número es correcto
            if ("¡Correcto!".equals(response)) {
                System.out.println("Cliente adivinó el número. Reiniciando juego...");
                numberToGuess = generateNumber();
                System.out.println("Nuevo número generado: " + numberToGuess);
            }
        }
    }

    private String processGuess(String guess) {
        int guessedNumber;
        try {
            guessedNumber = Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            return "Por favor, envía un número válido.";
        }

        if (guessedNumber < numberToGuess) {
            return "Más alto";
        } else if (guessedNumber > numberToGuess) {
            return "Más bajo";
        } else {
            return "¡Correcto!";
        }
    }

    private int generateNumber() {
        return (int) (Math.random() * 50) + 1; // Número entre 1 y 50
    }
}
