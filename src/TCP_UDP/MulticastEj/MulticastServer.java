package TCP_UDP.MulticastEj;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.nio.ByteBuffer;

public class MulticastServer {

    Paraules paraules = new Paraules();
    MulticastSocket socket;
    InetAddress multicastIP;
    int port;
    boolean continueRunning = true;


    public MulticastServer(int portValue, String strIp) throws IOException, IOException {
        socket = new MulticastSocket(portValue);
        multicastIP = InetAddress.getByName(strIp);
        port = portValue;

    }

    public void runServer() throws IOException {
        DatagramPacket packet;
        byte[] sendingData;
        while(continueRunning){

            //cambiar la data a mandar
            String randomWord = paraules.getRandomPalabra();

            System.out.println(randomWord);

            sendingData = randomWord.getBytes();
            packet = new DatagramPacket(sendingData, sendingData.length,multicastIP, port);
            socket.send(packet);

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
        socket.close();

    }

    public static void main(String[] args) throws IOException {
        MulticastServer ms = new MulticastServer(1111, "11");
        ms.runServer();
    }


}
