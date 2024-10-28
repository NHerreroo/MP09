package Runable.Paletas;

public class Paleta implements Runnable{

    private String nom;

    @Override
    public void run() {
        ponerLadrillo();
    }

    public Paleta(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void ponerLadrillo(){
        try {
            Thread.sleep((long) (Math.random()*2000)+1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getNom() + "Ha puesto un ladrillo");
    }



}
