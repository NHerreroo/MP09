package Ascensor;

public class Main {
    public static void main(String[] args) {

        Ascensor ascensor = new Ascensor(0, true, 10,0);
        Motor motor = new Motor(ascensor);

        Persona p = new Persona("nacho", ascensor,6,2);
        Persona p1 = new Persona("davide", ascensor,7,5);
        Persona p2 = new Persona("alex", ascensor,4,6);
        Persona p3 = new Persona("marc", ascensor,2,4);
        Persona p4= new Persona("adr", ascensor,1,3);
        Persona p5= new Persona("alex", ascensor,9,2);
        Persona p6= new Persona("isam", ascensor,4,2);


        motor.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();


    }
}
