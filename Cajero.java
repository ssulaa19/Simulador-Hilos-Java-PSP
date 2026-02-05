package psp.actividadCajeros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cajero {

    private Banco miBanco;
    private final Map<Boolean, List<Cliente> > transacciones = new HashMap<>();
    private String nombre;
    private int totalRetirado;


    public Cajero (){}

    public Cajero (Banco miBanco, String nombre) {
        this.miBanco = miBanco;
        this.nombre = nombre;
        this.transacciones.put(true, new ArrayList<>());
        this.transacciones.put(false, new ArrayList<>());

    }

    // Si le paso varios clientes
    protected void ejecuta(List<Cliente> clientes){
        for (Cliente c : clientes) {

            if (this.miBanco.retirarCantidad(c.getMonto())){
                transacciones.get(true).add(c);
                totalRetirado += c.getMonto();
            }
            else {
                transacciones.get(false).add(c);
            }

        }
    }

    // Si le paso un único cliente
    protected void ejecuta(Cliente cliente){

        if (this.miBanco.retirarCantidad(cliente.getMonto())){
            transacciones.get(true).add(cliente);
            totalRetirado += cliente.getMonto();
        }
        else {
            transacciones.get(false).add(cliente);
        }
    }

    protected String getNombre(){
        return this.nombre;
    }

    protected  Map<Boolean, List<Cliente>> getTransacciones(){return this.transacciones;}

    protected int getTotalRetirado() {return this.totalRetirado;}


}
