package Threads.Galetes;

public class Fills extends Thread{

    private String nom;
    private PotGaletes pot;

    public Fills(String nom, PotGaletes pot) {
        this.nom = nom;
        this.pot = pot;
    }

    @Override
    public void run() {
        for (;;){
            pot.agafarPot();
            pot.agafarGaletes();
            System.out.println(getNom() + "esta agafant una Galeta. Num Threads.Galetes: " + pot.getGaletes());
            try {
                Thread.sleep((long) (Math.random()*800 + 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            pot.deixarPot();
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
