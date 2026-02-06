package psp.actividadCajeros;

public class Cliente {

    private final int montoRetirar;
    private final String nombre;

    public Cliente(int montoRetirar, String nombre){
        this.montoRetirar = montoRetirar;
        this.nombre = nombre;
    }

    public int getMonto(){ return this.montoRetirar; }

    public String getNombre(){ return this.nombre; }

    @Override
    public String toString() {
        return "[" +this.nombre+"] ";
    }
}
