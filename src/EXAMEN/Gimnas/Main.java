package Gimnas;

public class Main {
    public static void main(String[] args) {

        Gimnas g = new Gimnas();
        Sauna s = new Sauna();

        Persona p1 = new Persona("NACHO", s,g);
        Persona p2 = new Persona("EMMA", s,g);
        Persona p3 = new Persona("DAVIDE", s,g);
        Persona p4 = new Persona("JORDI", s,g);
        Persona p5 = new Persona("ALEX", s,g);

        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}
