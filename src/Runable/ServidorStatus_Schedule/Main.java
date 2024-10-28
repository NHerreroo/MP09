package Runable.ServidorStatus_Schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        ServerStatus s1 = new ServerStatus("server_1");
        ServerStatus s2 = new ServerStatus("server_2");

        ScheduledExecutorService schExSer = Executors.newScheduledThreadPool(3);
        schExSer.scheduleWithFixedDelay(s1,0 ,2, TimeUnit.SECONDS);
        schExSer.scheduleWithFixedDelay(s2,2 ,1, TimeUnit.SECONDS);


        try {
            schExSer.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        schExSer.shutdownNow();
    }
}
