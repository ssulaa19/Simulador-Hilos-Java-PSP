package psp.actividadCajeros;

import java.util.*;

public class Main {

    private static Banco miBanco;
    private static List<Cliente> clientesList;
    private static List<Thread> hilos;
    private static List<Cajero> misCajeros;
    private static final Random r = new Random();

    public static void main(String[] args) {
        inicializaVariables();
        System.out.println("Saldo inicial del banco: " + miBanco.getCantidadTotal()+"\n");

        inicializaHilos();

        imprimirResultadoFinal();
    }

    private static Thread getThread(Cajero cajero) {

        return new Thread(()-> {
            cajero.ejecuta(clientesList);

            cajero.getTransacciones().forEach((x,y) ->{
                String operacion = x ? "aceptada" : "rechazada";
                y.forEach(c -> {
                    try {
                        int n = r.nextInt(200, 1201);
                        Thread.sleep(n);
                        System.out.printf("[%s] El cliente %s solicita -> %d€ | operación: %s | tiempo: %dms\n",cajero.getNombre(),c.getNombre(),c.getMonto(), operacion, n);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            });
        });
    }

    private static void inicializaVariables() {
        clientesList = new ArrayList<>(Arrays.asList(
                new Cliente(16, "Ana"),
                new Cliente(120, "Luis"),
                new Cliente(30, "Teo"),
                new Cliente(70, "Sula")
        ));

        miBanco = new Banco();
        Cajero cajero1 = new Cajero(miBanco, "Cajero 1");
        Cajero cajero2 = new Cajero(miBanco, "Cajero 2");

        Thread t1 = getThread(cajero1);
        Thread t2 = getThread(cajero2);
        hilos = new ArrayList<>(Arrays.asList(t1,t2));

        misCajeros = new ArrayList<>(Arrays.asList(cajero1,cajero2));

    }

    private static void inicializaHilos() {

        hilos.forEach(Thread::start);

        hilos.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

    }

    private static void imprimirResultadoFinal() {

        int saldoFinal = miBanco.getCantidadTotal();
        int operacionesCorrectas = misCajeros.stream().mapToInt(p -> p.getTransacciones().get(true).size()).sum();
        int operacionesDenegadas = misCajeros.stream().mapToInt(p -> p.getTransacciones().get(false).size()).sum();
        int totalRetirado = misCajeros.stream().mapToInt(Cajero::getTotalRetirado).sum();
        int clientesAtendidos = misCajeros.stream().mapToInt(c -> c.getTransacciones().get(true).size()).sum() +
                misCajeros.stream().mapToInt(c -> c.getTransacciones().get(false).size()).sum();

        System.out.println("\n \t === Resumen Final === \n");
        System.out.println("Saldo final: "+ saldoFinal+"€");
        System.out.println("Operaciones OK: " + operacionesCorrectas);
        System.out.println("Operaciones Denegadas: " + operacionesDenegadas);
        System.out.println("Total Retirado: " + totalRetirado+"€");
        System.out.println("Clientes Atendidos: " + clientesAtendidos);

    }

}
