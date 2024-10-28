package Runable.CursaCaracoles_Schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Caracol c1 = new Caracol("Caracol_1");
        Caracol c2 = new Caracol("Caracol_2");

        ScheduledExecutorService schExSer = Executors.newScheduledThreadPool(3);
        schExSer.scheduleWithFixedDelay(c1,0 ,2, TimeUnit.SECONDS);
        schExSer.scheduleWithFixedDelay(c2,2 ,1, TimeUnit.SECONDS);

        try {
            schExSer.awaitTermination(25,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        schExSer.shutdownNow();

        System.out.println(c1.getNombre() + "Ha hecho en total: " + c1.getMetres());
        System.out.println(c2.getNombre() + "Ha hecho en total: " + c2.getMetres());

    }
}
