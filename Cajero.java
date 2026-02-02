package psp.actividadCajeros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cajero {

    private Banco miBanco;
    private Map<Boolean, List<Cliente> > transacciones = new HashMap<>();

    public Cajero (){}

    public Cajero (Banco miBanco) {
        this.miBanco = miBanco;
        this.transacciones.put(true, new ArrayList<>());
        this.transacciones.put(false, new ArrayList<>());

    }

    // Si le paso varios clientes
    protected void ejecuta(List<Cliente> clientes){
        for (Cliente c : clientes) {

            if (this.miBanco.retirarCantidad(c.getMonto())){
                transacciones.get(true).add(c);
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
        }
        else {
            transacciones.get(true).add(cliente);
        }
    }

    protected  Map<Boolean, List<Cliente>> getTransacciones(){return this.transacciones;}


}
