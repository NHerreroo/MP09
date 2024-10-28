package Callable.Examen;

//ejercico, alumnos entran a una clase y hacen un examen todos a la vez

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Alumne> alumneList = new ArrayList<Alumne>();

        int numAlumnes = 10;
        String modul = "MP09";

        for (int i = 0; i<numAlumnes; i++){
            Alumne a = new Alumne(modul + i);
            alumneList.add(a);
        }

        List <Future<Integer>> llistaResultats;

        llistaResultats = executor.invokeAll(alumneList);
        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++){
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println(alumneList.get(i).getNom() + ": " + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
                e.getStackTrace();
            }
        }
    }
}
