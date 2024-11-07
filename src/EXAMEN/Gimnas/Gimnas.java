package Gimnas;

public class Gimnas {

    private int capacitat;


    public Gimnas() {
        capacitat = 0;
    }

    public synchronized  int getCapacitat() {
        return capacitat;
    }

    public synchronized void entrarGimnas(){
        try{
            while (capacitat >= 10) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        capacitat ++;
        notifyAll();
    }


    public synchronized void sortirGimnas(){
        try{
            while (capacitat <= 0) wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        capacitat --;
        notifyAll();
    }

}
