package Threads.Comandament;

public class Main {
    public static void main(String[] args) {

        Comandament c = new Comandament();

        Persona p1 = new Persona("NACHO", c);
        Persona p2 = new Persona("EMMA", c);

        p1.start();
        p2.start();
    }
}
