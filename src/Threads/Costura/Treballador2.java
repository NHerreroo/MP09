package Threads.Costura;

public class Treballador2 extends Thread{
    private Cesta cesta;
    private Cesta cesta2;
    private String nom;

    private int jerseisFets = 0;

    public Treballador2(Cesta cesta, Cesta cesta2,  String nom, int jerseisFets) {
        this.cesta = cesta;
        this.cesta2 = cesta2;
        this.nom = nom;
        this.jerseisFets = jerseisFets;
    }

    public Cesta getCesta() {
        return cesta;
    }

    public String getNom() {
        return nom;
    }

    public int getJerseisFets(){
        return jerseisFets;
    }


    @Override
    public void run() {
        for(;;){
            synchronized (cesta) {
                synchronized (cesta2) {
                    if (cesta.getPeces() >= 2 && cesta2.getPeces() >= 1) {
                        cesta.treureRoba(2);
                        cesta2.treureRoba(1);
                        jerseisFets += 1;
                        System.out.println("El treballador està fent un jersei PORTA: " + getJerseisFets());
                    }
                }
            }

            try {
                Thread.sleep((long) (Math.random()*800 + 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}












