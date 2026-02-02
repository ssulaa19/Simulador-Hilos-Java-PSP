package psp.actividadCajeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static Banco miBanco;
    private static Cajero cajero1;
    private static Cajero cajero2;
    private static Cajero cajero3;
    private static List<Cliente> clientesList;
    private static Cliente individual;

    public static void main(String[] args) {
        inicializaVariables();
        System.out.println("Saldo inicial del banco: " + miBanco.getCantidadTotal()+"\n");
        cajero1.ejecuta(clientesList);

        cajero1.getTransacciones().forEach((x,y) ->{
            y.forEach(c -> {
                System.out.println(c.getNombre() +" ha sacado dinero: " + x );
            });
        });

        System.out.println("\nSaldo final del banco: " + miBanco.getCantidadTotal());
    }

    private static void inicializaVariables() {
        clientesList = new ArrayList<>(Arrays.asList(
                new Cliente(200, "Ana"),
                new Cliente(500, "Luis"),
                new Cliente(50, "Teo"),
                new Cliente(1500, "Sula")
        ));
        individual = new Cliente(100, "Juan");

        miBanco = new Banco();
        cajero1 = new Cajero(miBanco);
        cajero2 = new Cajero(miBanco);
        cajero3 = new Cajero(miBanco);

    }

}
