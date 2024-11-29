package TCP_UDP.MulticastEj;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        MulticastServer ms = new MulticastServer(5557, "224.0.11.132");
        ms.runServer();
    }
}
