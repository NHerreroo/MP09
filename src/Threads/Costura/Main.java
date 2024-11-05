package Threads.Costura;

public class Main {
    public static void main(String[] args) {
        Cesta manigues = new Cesta(0,true);
        Cesta cos = new Cesta(0,true);

        Treballador t1 = new Treballador(manigues, "Costurer de manigues");
        Treballador t2 = new Treballador(cos, "Costurer de cos");
        Treballador2 t3 = new Treballador2(manigues, cos,"Costurer de cos", 0);

        t1.start();
        t2.start();
        t3.start();
    }

}
