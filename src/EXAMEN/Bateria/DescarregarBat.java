package EXAMEN.Bateria;

public class DescarregarBat extends Thread{

    private Bateria bateria;
    public DescarregarBat(Bateria bateria) {
        this.bateria = bateria;
    }

    @Override
    public void run() {
        for (;;){
            while (bateria.getNivell() > 0){
                bateria.descarregar();
                System.out.println("La bateria s'esta descarregant");
            }

            break;

        }

    }
}
