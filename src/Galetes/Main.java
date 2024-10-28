package Galetes;

public class Main {
    public static void main(String[] args) {
        PotGaletes pot = new PotGaletes(10,true);

        Fills f = new Fills("Nacho",pot);
        Pares p = new Pares("Davide",pot);

        p.start();
        f.start();
    }
}
