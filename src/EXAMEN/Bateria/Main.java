package EXAMEN.Bateria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Bateria b = new Bateria(100);
        DescarregarBat db = new DescarregarBat(b);
        CarregarBateria cb = new CarregarBateria(b);

        while(true) {
            System.out.println("Elije opcion");
            System.out.println("");
            System.out.println("1.CargarBateria");
            System.out.println("2.Jugar");
            System.out.println("3.Info Bat");
            System.out.println("4.Sortir");

            int opcion = s.nextInt();


            switch (opcion) {
                case 1:
                    cb.start(); //cargar
                    break;
                case 2: //juagr
                    if (b.getNivell() < 100) System.out.println("La bateria nno esta al 100%");
                    else db.start();

                    break;
                case 3: //info
                    System.out.println(b.getNivell());
                    break;
                case 4: // salir
                    System.out.println("Adios");
                    break;
            }
        }

    }
}