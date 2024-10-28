package Threads.Ascensor;

public class Motor extends Thread{

    private Ascensor ascensor;

    public Motor(Ascensor ascensor) {
        this.ascensor = ascensor;
    }
    @Override
    public void run() {
        while (true){

            System.out.println("El Threads.Ascensor esta subiendo. Piso actual: " + ascensor.getPisActual());
            ascensor.cambiarDePis();
            try {
                Thread.sleep((long) 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
