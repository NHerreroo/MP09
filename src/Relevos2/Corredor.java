package Relevos2;

public class Corredor extends Thread{
    private String nom;
    private Relevo relevo;
    private boolean acabat = false;

    @Override
    public void run() {
        while (acabat == false){
            relevo.agafar();
            System.out.println(getNom() + " Del Equipo: " + relevo.getEquipo() + " esta corriendo..");
            try {
                Thread.sleep((long) (Math.random()*800));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getNom() + " Del Equipo: " + relevo.getEquipo()  + " ha acabado");
            relevo.deixar();
            acabat = true;
        }
    }

    public Corredor(String nom, Relevo relevo) {
        this.nom = nom;
        this.relevo = relevo;
        acabat = false;
    }

    public String getNom() {
        return nom;
    }

    public Relevo getRelevo() {
        return relevo;
    }

    public boolean isAcabat() {
        return acabat;
    }
}
