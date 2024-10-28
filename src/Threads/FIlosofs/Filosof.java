package Threads.FIlosofs;

public class Filosof extends Thread {

    private String nom;
    private Forquilla forquillaDreta;
    private Forquilla forquillaEsquerra;

    public Filosof(String nom, Forquilla forquillaDreta, Forquilla forquillaEsquerra) {
        this.nom = nom;
        this.forquillaDreta = forquillaDreta;
        this.forquillaEsquerra = forquillaEsquerra;
    }

    @Override
    public void run() {
        super.run();
    }

    public void menjar(){
        
    }
}