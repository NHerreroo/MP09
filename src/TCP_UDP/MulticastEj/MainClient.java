package TCP_UDP.MulticastEj;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException {
        MulticastClient mc = new MulticastClient(5557, "224.0.11.132");
        mc.runClient();
    }
}
