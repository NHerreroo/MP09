package Callable.Enquesta;

import java.util.concurrent.Callable;

public class Enquesta implements Callable<Integer> {
    private int nota;
    private String nom;

    public Enquesta(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int ferEnquesta(){
        try {
            Thread.sleep((long) (Math.random() * 2000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        nota = (int) (Math.random() * 10);
        return nota;
    }

    @Override
    public Integer call() throws Exception {
        return ferEnquesta();
    }
}
