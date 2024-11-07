package Threads.CompteBancari;

public class Main {
    public static void main(String[] args) {

        Compte c = new Compte(); //def 5000 eruos

        Persona p1 = new Persona("NACHO", c);

        p1.start();
    }
}
