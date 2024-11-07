package Competició;

//ejercico, alumnos entran a una clase y hacen un examen todos a la vez

import Callable.Examen.Alumne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Regata {
    public static void main(String[] args) throws InterruptedException {

        int numParticipants = 10;
        String nom = "Winsurfista";
        int temps[] = new int[numParticipants];

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<Winsurfista> winsurfistaList = new ArrayList<Winsurfista>();

        for (int i = 0; i<numParticipants; i++){
            Winsurfista w = new Winsurfista(nom + i);
            winsurfistaList.add(w);
        }

        List <Future<Integer>> llistaResultats;

        llistaResultats = executor.invokeAll(winsurfistaList);
        executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++){
            Future<Integer> resultat = llistaResultats.get(i);
            try {
                System.out.println(winsurfistaList.get(i).getNom() + ": " + resultat.get());
            } catch (InterruptedException | ExecutionException e) {
                e.getStackTrace();
            }
        }
    }
}
