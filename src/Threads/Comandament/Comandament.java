package Threads.Comandament;

public class Comandament {
    private boolean lliure;

    public Comandament() {
        lliure = true;
    }

    public synchronized boolean isLliure() {
        return lliure;
    }

    public synchronized void agafarComandament(){
        try{
            while (!lliure) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lliure = false;
        notifyAll();
    }

    public synchronized void deixarComandament(){
        lliure = true;
        notifyAll();
    }

}
