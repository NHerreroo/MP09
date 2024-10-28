package Callable.Temperatura;

import java.util.concurrent.Callable;

public class Ciudad implements Callable<Integer> {
    private String ciudad;

    public Ciudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public Integer call() throws Exception {
        return (int)(Math.random()*40);
    }
}
