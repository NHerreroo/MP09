package Callable.Enquesta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        System.out.println("Las persones que han adquirit el servei de Nacho Herrero estan fent una enquesta per valorar la seva satisfacció");

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Enquesta> enquestaList = new ArrayList<>();

        int numEnquestes = 10;
        String enquesta = "Enquesta: ";
        float suma = 0;

        for(int i = 0; i < numEnquestes; i++){
            Enquesta e = new Enquesta(enquesta + i);
            enquestaList.add(e);
        }

        List<Future<Integer>> llistaRes;

        llistaRes = executor.invokeAll(enquestaList);
        executor.shutdown();

        for (int i = 0; i<llistaRes.size(); i++){
            Future<Integer> resultat = llistaRes.get(i);
            try {
                System.out.println(enquestaList.get(i).getNom() + ": " + resultat.get());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            suma += resultat.get();

        }

        System.out.println("------ NOTA MITJANA DE LA ENQUESTA ---------");
        System.out.println(suma/numEnquestes);
    }
}
