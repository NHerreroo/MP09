package Galetes;

public class Pares extends Thread {

    private String nom;
    private PotGaletes pot;

    public Pares (String nom, PotGaletes pot) {
        this.nom = nom;
        this.pot = pot;
    }

    @Override
    public void run() {
        for (;;){
            pot.agafarPot();
            pot.posarGaletes();
            System.out.println(getNom() + " esta posant galetes al pot, Num de galetes: " + pot.getGaletes());
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
