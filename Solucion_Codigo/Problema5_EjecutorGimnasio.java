import java.util.ArrayList;
import java.util.Scanner;

public class Problema5_EjecutorGimnasio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gimnasio gimnasio = new Gimnasio();

        System.out.print("¿Cuántos clientes deseas registrar? ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("\nCliente #" + (i + 1));

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Tipo de ejercicio (Cardio/Fuerza/Estiramiento): ");
            String tipo = sc.nextLine();

            System.out.print("Duración (en minutos): ");
            int duracion = Integer.parseInt(sc.nextLine());

            System.out.print("¿Completó la rutina? (s/n): ");
            String respuesta = sc.nextLine();
            boolean completo = respuesta.equalsIgnoreCase("s");

            Cliente c = new Cliente(nombre, tipo, duracion, completo);
            gimnasio.registrarCliente(c);
        }

        gimnasio.mostrarClientes();
        gimnasio.mostrarResumen();

        sc.close();
    }
}


class Cliente {
    public String nombre;
    public String tipoEjercicio;
    public int duracion;
    public boolean completo;

    public Cliente(String nombre, String tipoEjercicio, int duracion, boolean completo) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.completo = completo;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean esCompleto() {
        return completo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
               "\nEjercicio: " + tipoEjercicio +
               "\nDuración: " + duracion + " minutos" +
               "\n¿Completado?: " + (completo ? "Sí" : "No");
    }
}


class Gimnasio {
    public ArrayList<Cliente> clientes;

    public Gimnasio() {
        clientes = new ArrayList<>();
    }

    public void registrarCliente(Cliente c) {
        clientes.add(c);
    }

    public void mostrarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println("---------------------------");
            System.out.println(c);
        }
    }

    public void mostrarResumen() {
        if (clientes.isEmpty()) {
            System.out.println("No se puede calcular resumen sin clientes.");
            return;
        }

        int totalDuracion = 0;
        int completaron = 0;

        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            totalDuracion += c.getDuracion();
            if (c.esCompleto()) {
                completaron++;
            }
        }

        double promedio = (double) totalDuracion / clientes.size();

        System.out.println("Clientes que completaron su rutina: " + completaron);
        System.out.printf("Tiempo promedio invertido: %.2f minutos\n", promedio);
    }
}