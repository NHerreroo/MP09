package Competició;

import java.util.concurrent.Callable;

public class Winsurfista implements Callable<Integer> {
    private String nom;

    public Winsurfista(String nom) {
        this.nom = nom;
    }

    public int competir() {

        //temps que triga a fer la regata
        int temps = (int) (Math.random()*2000)+1000;
        System.out.println("El winsurfista "+nom+" inicia la competició");
        try {
            Thread.sleep(temps);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return temps;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public Integer call() throws Exception {
        return competir();
    }
}
