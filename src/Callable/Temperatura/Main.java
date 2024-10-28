package Callable.Temperatura;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Ciudad> ciudadList = new ArrayList<Ciudad>();

        int ciudades = 10;

        for (int i = 0; i < ciudades; i++){
            Ciudad ciudad = new Ciudad("Ciudad");
            ciudadList.add(ciudad);
        }

        List<Future<Integer>> futureList;

        futureList = executor.invokeAll(ciudadList);
        executor.shutdown();

        for (int i = 0; i < futureList.size(); i++){
            Future<Integer> temp = futureList.get(i);
            try {
                System.out.println(ciudadList.get(i).getCiudad() + ": " + temp.get()+"º");
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
