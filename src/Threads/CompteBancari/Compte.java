package Threads.CompteBancari;

public class Compte {
    private float diners;
    private boolean disponible;

    public Compte() {
        diners = 5000;
        disponible = true;
    }
    public float getDiners() {
        return diners;
    }

    public synchronized void afegirDiners(float dinersAfegits){
        try {
            while (!disponible) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        disponible = false;
        diners += dinersAfegits;
        System.out.println("S'han afegit " + dinersAfegits + "€");
        notifyAll();
    }

    public synchronized void retirarDiners(float dinersRetirar){
        try {
            while (!disponible && diners <= dinersRetirar) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        disponible = false;
        diners -= dinersRetirar;
        System.out.println("S'han retirat " + dinersRetirar + "€");
        notifyAll();
    }

    public synchronized void deixarCompte(){
        disponible = true;
        notifyAll();
    }


}
