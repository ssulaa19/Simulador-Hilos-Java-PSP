package psp.actividadCajeros;

import java.util.Random;

public class Banco {

    private int cantidadTotal;

    public Banco() {
        Random r = new Random();
        this.cantidadTotal = r.nextInt(200,801);
    }

    public int getCantidadTotal(){
        return cantidadTotal;
    }

    public boolean retirarCantidad(int retirada){
        if (retirada <= 0 || retirada > cantidadTotal) return false;

        cantidadTotal -= retirada;
        return true;
    }

}
