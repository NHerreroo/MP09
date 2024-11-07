package Threads.Almacen;

public class Main {
    public static void main(String[] args) {

        Almacen a = new Almacen();

        Consumidor c = new Consumidor("NACHO", a);
        Productor p = new Productor("DAVIDE", a);

        p.start();
        c.start();
    }
}
