package Ascensor;

public class Ascensor {
    private int persones;
    private boolean pujar; //true para subir false para bajar
    private int capacitat = 10;
    private int pisActual = 0;

    public Ascensor(int persones, boolean pujar, int capacitat, int pisActual) {
        this.persones = persones;
        this.pujar = pujar;
        this.capacitat = capacitat;
        this.pisActual = pisActual;
    }


    public synchronized void agafarAscensor(){
        try {
            while (persones >= capacitat) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        persones++;
    }
    public synchronized void baixarAscensor(){
        persones--;

    }
    public synchronized void cambiarDePis(){
        if (pisActual <= 0) pujar = true;
        if (pisActual >= 10) pujar = false;

        if (pujar){
            pisActual++;
        }if (!pujar){
            pisActual--;
        }
        notifyAll();
    }

    public synchronized int getPersones() {
        return persones;
    }

    public synchronized void setPersones(int persones) {
        this.persones = persones;
    }

    public synchronized boolean isPujar() {
        return pujar;
    }

    public synchronized void setPujar(boolean pujar) {
        this.pujar = pujar;
    }

    public synchronized int getCapacitat() {
        return capacitat;
    }

    public synchronized void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public synchronized int getPisActual() {
        return pisActual;
    }

    public synchronized void setPisActual(int pisActual) {
        this.pisActual = pisActual;
    }



}
