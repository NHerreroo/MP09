package Galetes;

public class PotGaletes {

    private int galetes;
    private boolean lliure;

    public PotGaletes(int galetes, boolean lliure) {
        this.galetes = galetes;
        this.lliure = lliure;
    }

    public synchronized void agafarPot(){
        lliure = false;
    }
    public synchronized void deixarPot(){
        lliure = false;
    }

    public synchronized void posarGaletes(){
        try {
            while (!lliure && galetes >=1 ) wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        galetes = 10;
        notifyAll();
    }

    public synchronized void agafarGaletes(){
        try {
            while (!lliure && galetes <= 0) wait();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        galetes--;
        notifyAll();
    }

    public synchronized int getGaletes() {
        return galetes;
    }

    public synchronized void setGaletes(int galetes) {
        this.galetes = galetes;
    }

    public synchronized boolean isLliure() {
        return lliure;
    }

    public synchronized void setLliure(boolean lliure) {
        this.lliure = lliure;
    }
}
