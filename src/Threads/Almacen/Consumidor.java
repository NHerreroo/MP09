package Threads.Almacen;

public class Consumidor extends Thread {
    private String nom;
    private Almacen almacen;

    public Consumidor(String nom, Almacen almacen) {
        this.nom = nom;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        for(;;){
            almacen.retirarProductes();
            System.out.println("El Consumidor: " + nom + " Esta retirant productes del Almacen. STOCK TOTAL: " + almacen.getProductes());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

