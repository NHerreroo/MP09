package Threads.Almacen;

public class Almacen {
    private int productes;
    private final int MAX_PRODUCTES = 10;
    private final int MIN_PRODUCTES = 0;

    public Almacen() {
        productes = 0;
    }

    public synchronized int getProductes() {
        return productes;
    }

    public synchronized void afegirProductes(){
        try {
            while (productes > MAX_PRODUCTES) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productes++;
        notifyAll();
    }

    public synchronized void retirarProductes(){
        try {
            while (productes <= MIN_PRODUCTES) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        productes--;
        notifyAll();
    }
}
