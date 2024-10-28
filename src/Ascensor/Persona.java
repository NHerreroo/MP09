package Ascensor;

public class Persona extends Thread{

    private String nom;
    private Ascensor ascensor;
    private int pis;
    private int pisAct;

    private boolean haBaixat = false;

    public Persona(String nom, Ascensor ascensor, int pis, int pisAct) {
        this.nom = nom;
        this.ascensor = ascensor;
        this.pis = pis;
        this.pisAct = pisAct;
    }

    @Override
    public void run() {
        while (!haBaixat) {
            try {
                Thread.sleep(1000);
                if (pis == ascensor.getPisActual() && ascensor.getPersones() > 0) {
                    System.out.println(nom + " ha bajado del ascensor en el piso " + pis);
                    ascensor.baixarAscensor();
                    haBaixat = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (pisAct == ascensor.getPisActual() && !haBaixat) {
                ascensor.agafarAscensor();
                System.out.println(nom + " ha subido al ascensor en el piso " + pisAct + " y quiere ir al piso " + pis);
            }
        }
    }
}
