package Relevos2;

public class Main {
    public static void main(String[] args) {

        Relevo r1 = new Relevo("MAD_LION");
        Corredor c1 = new Corredor("Nacho", r1);
        Corredor c2 = new Corredor("Davide", r1);
        Corredor c3 = new Corredor("Alex", r1);

        Relevo r2 = new Relevo("T1_TEAM");
        Corredor c4 = new Corredor("Faker", r2);
        Corredor c5 = new Corredor("Xinye", r2);
        Corredor c6 = new Corredor("Mari-Kong", r2);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();

    }
}
