package Threads.Almacen;

public class Productor extends Thread {
    private String nom;
    private Almacen almacen;

    public Productor(String nom, Almacen almacen) {
        this.nom = nom;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for(;;){
            almacen.afegirProductes();
            System.out.println("El productor: " + nom + " Esta portant productes al Almacen. STOCK TOTAL: " + almacen.getProductes());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
