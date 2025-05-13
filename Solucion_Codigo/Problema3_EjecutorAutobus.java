import java.util.ArrayList;
import java.util.Scanner;

public class Problema3_EjecutorAutobus{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutobusEscolar autobus = new AutobusEscolar();

        System.out.print("¿Cuántos estudiantes desea registrar? ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nEstudiante " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Grado: ");
            int grado = sc.nextInt();
            System.out.print("¿Tiene permiso? (true/false): ");
            boolean permiso = sc.nextBoolean();
            sc.nextLine();
            autobus.registrarEstudiante(nombre, grado, permiso);
        }

        System.out.println("\nSimulación de ingreso:");
        autobus.simularIngreso();
    }
}

class Estudiante {
    public String nombre;
    public int grado;
    public boolean tienePermiso;

    public Estudiante(String nombre, int grado, boolean tienePermiso) {
        this.nombre = nombre;
        this.grado = grado;
        this.tienePermiso = tienePermiso;
    }

    public boolean puedeSubir() {
        return tienePermiso;
    }

    public String toString() {
        return "Nombre: " + nombre +
               "\nGrado: " + grado +
               "\nPermiso vigente: " + (tienePermiso ? "Sí" : "No") +
               "\n------------------------";
    }
}

class AutobusEscolar {
    public ArrayList<Estudiante> estudiantes;

    public AutobusEscolar() {
        estudiantes = new ArrayList<>();
    }

    public void registrarEstudiante(String nombre, int grado, boolean permiso) {
        estudiantes.add(new Estudiante(nombre, grado, permiso));
    }

    public void simularIngreso() {
        int aceptados = 0;
        int rechazados = 0;

        for (int i = 0; i < estudiantes.size(); i++) {
            Estudiante e = estudiantes.get(i);
            System.out.println(e);
            if (e.puedeSubir()) {
                System.out.println("SI Puede subir al autobús.");
                aceptados++;
            } else {
                System.out.println("NO puede subir al autobús.");
                rechazados++;
            }
            System.out.println();
        }

        System.out.println("Resumen final:");
        System.out.println("Estudiantes aceptados: " + aceptados);
        System.out.println("Estudiantes rechazados: " + rechazados);
    }
}