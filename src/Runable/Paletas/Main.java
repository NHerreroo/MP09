package Runable.Paletas;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        int numPaletas = 5;

        Paleta[] paletas = new Paleta[numPaletas];

        for (int i = 0; i < paletas.length; i++){
            paletas[i] = new Paleta("Paleta-" + i);
            executor.execute(paletas[i]);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        System.out.println("Acabo");
    }
}
