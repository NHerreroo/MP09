package Runable.ServidorStatus_Schedule;

public class ServerStatus implements Runnable {

    private String nombre;
    private boolean status;

    public ServerStatus(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isStatus() {
        return status;
    }


    public void saber_estado(){
        status = Math.random() < 0.5;
        System.out.println("El server: " + getNombre() + " esta en estado: " + status);
    }

    @Override
    public void run() {
        saber_estado();
    }
}
