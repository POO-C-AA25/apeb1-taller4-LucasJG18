import java.util.ArrayList;
import java.util.Scanner;

public class Problema2_EjecutorNomina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int opcion;

        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Calcular aumento salarial");
            System.out.println("4. Salir");
            System.out.print("Ingrese opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Salario: ");
                    double salario = sc.nextDouble();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    gestor.agregarEmpleado(nombre, salario, edad);
                    break;
                case 2:
                    gestor.mostrarEmpleados();
                    break;
                case 3:
                    System.out.print("Porcentaje de aumento (%): ");
                    double porcentaje = sc.nextDouble();
                    gestor.calcularAumento(porcentaje);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
    }
}

class Empleado {
    public String nombre;
    public double salario;
    public int edad;

    public Empleado(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: $" + salario);
        System.out.println("Edad: " + edad + " años");
        System.out.println("-----------------------------");
    }
}

class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    public void agregarEmpleado(String nombre, double salario, int edad) {
        empleados.add(new Empleado(nombre, salario, edad));
    }

    public void mostrarEmpleados() {
        for (int i = 0; i < empleados.size(); i++) {
            empleados.get(i).mostrarInformacion();
        }
    }

    public void calcularAumento(double porcentaje) {
        double sumaSalarios = 0;
        for (int i = 0; i < empleados.size(); i++) {
            sumaSalarios += empleados.get(i).getSalario();
        }

        double promedio = sumaSalarios / empleados.size();

        System.out.println("Salarios ajustados:");
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            if (e.getSalario() < promedio) {
                double nuevoSalario = e.getSalario() * (1 + porcentaje / 100);
                e.setSalario(nuevoSalario);
                e.mostrarInformacion();
            }
        }
    }
}