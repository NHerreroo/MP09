package Threads.Costura;

public class Treballador extends Thread{
    private Cesta cesta;
    private String nom;

    public Treballador(Cesta cesta, String nom) {
        this.cesta = cesta;
        this.nom = nom;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public void run() {
        for(;;){
            cesta.agafarcesta();
            cesta.posarRoba();
            System.out.println("El trebllador: " + nom + " Ha posat 1 peca. TOTAL: " + cesta.getPeces());
            try {
                Thread.sleep((long) (Math.random()*800 + 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            cesta.deixarcesta();
        }
    }
}












