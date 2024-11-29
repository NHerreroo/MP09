package TCP_UDP.MulticastEj;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MulticastClient {
    /* Client afegit al grup multicast SrvVelocitats.java que representa un velocímetre */

    private boolean continueRunning = true;
    private MulticastSocket socket;
    private InetAddress multicastIP;
    private int port;
    NetworkInterface netIf;
    InetSocketAddress group;


    public MulticastClient(int portValue, String strIp) throws IOException {
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;
        socket = new MulticastSocket(port);
        //netIf = NetworkInterface.getByName("enp1s0");
        netIf = socket.getNetworkInterface();
        group = new InetSocketAddress(strIp,portValue);
    }

    public void runClient() throws IOException{
        DatagramPacket packet;
        byte [] receivedData = new byte[4];

        socket.joinGroup(group,netIf);
        System.out.printf("Connectat a %s:%d%n",group.getAddress(),group.getPort());

        Map<String,Integer> contadorPalabras = new HashMap<>();

        while (continueRunning) {
            try {
                // Recibir datos
                packet = new DatagramPacket(receivedData, receivedData.length);
                socket.receive(packet);

                // Convertir los datos recibidos a una palabra (cadena)
                String palabraRecibida = new String(packet.getData(), 0, packet.getLength());

                // Actualizar el contador de la palabra en el mapa
                contadorPalabras.put(palabraRecibida, contadorPalabras.getOrDefault(palabraRecibida, 0) + 1);

                // Mostrar el mapa actualizado
                System.out.println("Mapa de palabras recibidas: " + contadorPalabras);

            } catch (SocketTimeoutException e) {
                System.out.println("Tiempo de espera agotado. No se recibieron datos.");
            }
        }

        socket.leaveGroup(group,netIf);
        socket.close();
    }




}