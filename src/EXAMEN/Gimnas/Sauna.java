package Gimnas;

public class Sauna {

    private boolean disponible;

    public Sauna() {
        disponible = true;
    }

    public synchronized boolean isDisponible() {
        return disponible;
    }

    public synchronized void entrarSauna(){
        try{
            while (disponible == false) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        disponible = false;
        notifyAll();
    }

    public synchronized void sortirSauna(){
        try{
            while (disponible == true) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        disponible = true;
        notifyAll();
    }
}
