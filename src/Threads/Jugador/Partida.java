package Threads.Jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Partida {
    public static void main(String[] args) {
        Player p1 = new Player("Nacho");
        Player p2 = new Player("Davide");
        MonitorPlayer Mp1 = new MonitorPlayer(p1);
        MonitorPlayer Mp2 = new MonitorPlayer(p2);


        ScheduledExecutorService schExService = Executors.newScheduledThreadPool(3);
        schExService.scheduleWithFixedDelay(p1, 2,1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(p2, 4,4, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(Mp1, 5,1, TimeUnit.SECONDS);
        schExService.scheduleWithFixedDelay(Mp2, 3,5, TimeUnit.SECONDS);
        try {
            schExService.awaitTermination(25,TimeUnit.SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        schExService.shutdownNow();

        List<Player> playerList = new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);
        Collections.sort(playerList);
        for (Player p : playerList){
            System.out.println(p);
        }

        System.out.println("TOTAL " + p1.getNom() + ":" + p1.getPunt());
        System.out.println("TOTAL " + p2.getNom() + ":" + p2.getPunt());
    }
}
