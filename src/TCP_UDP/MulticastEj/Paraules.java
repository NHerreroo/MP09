package TCP_UDP.MulticastEj;

public class Paraules {

    // Inicialización del array con palabras
    String[] paraules = {"Nacho", "Davide", "Alex", "Jordi", "Ignasi"};

    // Método para obtener una palabra aleatoria
    public String getRandomPalabra() {
        int i = (int) (Math.random() * paraules.length - 1); // Índice aleatorio
        return paraules[i];
    }

    public Paraules() {

    }
}
