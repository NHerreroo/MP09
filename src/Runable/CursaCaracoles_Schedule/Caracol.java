package Runable.CursaCaracoles_Schedule;

public class Caracol implements Runnable{

    private String nombre;
    private int metres;

    public Caracol(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMetres() {
        return metres;
    }

    public void addMetres(int m){
        metres += m;
    }
    @Override
    public void run() {
        int sprint = (int) (Math.random()*50);
        addMetres(sprint);
        System.out.println(nombre + ": Ha hecho " + sprint + " Metros");
    }
}
