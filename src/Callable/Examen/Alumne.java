package Callable.Examen;

import java.util.concurrent.Callable;

public class Alumne implements Callable<Integer> {

    private String nom;

    public Alumne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int ferExamen(){
        try {
            Thread.sleep((long) (Math.random() * 2000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int nota = (int) (Math.random()*10);
        return nota;
    }
    @Override
    public Integer call() throws Exception {
        return ferExamen();
    }



}
