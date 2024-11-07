package Threads.CompteBancari;

public class Persona extends Thread{

    private String nom;
    private Compte compte;

    public Persona(String nom, Compte compte) {
        this.nom = nom;
        this.compte = compte;
    }

    @Override
    public void run() {
        for(;;){
            System.out.println(nom);
            compte.afegirDiners((float) (Math.random() * 1000));
            System.out.println("TOTAL: " + compte.getDiners());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            compte.deixarCompte();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nom);
            compte.retirarDiners((float) (Math.random() * 1000));
            System.out.println("TOTAL: " + compte.getDiners());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            compte.deixarCompte();
        }
    }
}
