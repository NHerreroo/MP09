package EXAMEN.Bateria;

public class CarregarBateria extends Thread {
    private Bateria bateria;

    public CarregarBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run() {
        for (;;){
            while (bateria.getNivell() < 100){
                bateria.carregar();
                System.out.println("La bateria s'esta carregant");
            }
            System.out.println("BateriaPlena");
            break;
        }
    }
}

