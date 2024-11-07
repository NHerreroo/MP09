package Threads.Comandament;

public class Persona extends Thread{
    private String nom;
    private Comandament comandament;

    public Persona(String nom, Comandament comandament) {
        this.nom = nom;
        this.comandament = comandament;
    }

    @Override
    public void run() {
        for (;;){
            comandament.agafarComandament();
            System.out.println(nom + " Ha agafat el comandament y esta veient la TV...");
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(nom + " Ha parat de veure la TV y va a descansar");
            comandament.deixarComandament();
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
