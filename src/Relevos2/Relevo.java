package Relevos2;

public class Relevo {

    private String equipo;
    private boolean lliure;

    public Relevo(String equipo) {
        this.equipo = equipo;
        lliure = true;
    }

    public synchronized void agafar(){
        try {
            while (!lliure) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lliure = false;
        notifyAll();
    }
    public synchronized void deixar(){
        lliure = true;
        notifyAll();
    }

    public synchronized boolean isLliure() {
        return lliure;
    }

    public synchronized String getEquipo() {
        return equipo;
    }
}
