package Gimnas;

public class Persona extends Thread {
    private String nom;
    private Sauna sauna;
    private Gimnas gimnas;

    public Persona(String nom, Sauna sauna, Gimnas gimnas) {
        this.nom = nom;
        this.sauna = sauna;
        this.gimnas = gimnas;
    }

    @Override
    public void run() {
        while (true) {
            gimnas.entrarGimnas();
            System.out.println(nom + " ha entrado al gimnasio.");
            try {
                Thread.sleep((long) (Math.random() * 3000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sauna.entrarSauna();
            System.out.println(nom + " ha entrado a la sauna.");

            try {
                Thread.sleep((long) (Math.random() * 5000));  // Simula tiempo en la sauna
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            sauna.sortirSauna();
            System.out.println(nom + " ha salido de la sauna.");

            gimnas.sortirGimnas();
            System.out.println(nom + " ha salido del gimnasio.");

            try {
                Thread.sleep((long) (Math.random() * 3000));  // Simula tiempo fuera del gimnasio
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
