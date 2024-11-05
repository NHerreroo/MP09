package Threads.Costura;

public class Cesta {
    private int peces = 10;
    private boolean disponible;

    public Cesta(int peces, boolean disponible) {
        this.peces = peces;
        this.disponible = disponible;
    }

    public synchronized void posarRoba(){
        try{
            while (peces >= 10) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        peces += 1;
        disponible = true;
        notifyAll(); // Notifica a todos los hilos para que verifiquen las condiciones nuevamente.
    }
    public synchronized void treureRoba(int pecesPerAgafar){
        try{
            while (pecesPerAgafar > peces) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        peces -= pecesPerAgafar;
        if (peces < 10) disponible = true; // Habilita la cesta si hay menos de 10 piezas.
        notifyAll(); // Notifica después de cada extracción.
    }

    public synchronized void agafarcesta(){
        while (!disponible) { // Espera a que la cesta esté disponible.
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        disponible = false; // Marcar como no disponible.
    }

    public synchronized void deixarcesta(){
        disponible = true; // Marcar como disponible.
        notifyAll(); // Notificar a otros hilos para que puedan tomar la cesta.
    }

    public synchronized int getPeces() {
        return peces;
    }

    public synchronized boolean isDisponible() {
        return disponible;
    }

}
