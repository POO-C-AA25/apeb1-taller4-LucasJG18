import java.util.Scanner;

public class Problema4_EjecutorParque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parque parqueX = new Parque();
        String seguir;

        do {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(sc.nextLine());

            System.out.print("Altura (en metros): ");
            double altura = Double.parseDouble(sc.nextLine());

            Visitante visitanteX = new Visitante(nombre, edad, altura);

            System.out.println("\n--- Datos del Visitante ---");
            System.out.println(visitanteX);

            System.out.println("\n--- Juegos disponibles ---");
            System.out.println(parqueX.verificarJuegos(visitanteX));

            System.out.print("¿Deseas registrar otro visitante? (s/n): ");
            seguir = sc.nextLine();
        } while (seguir.equalsIgnoreCase("s"));

        parqueX.mostrarResumen();
    }
}

class Visitante {
    public String nombre;
    public int edad;
    public double altura;
    
    public Visitante(){}

    public Visitante(String nombre, int edad, double altura) {
        this.nombre = this.nombre;
        this.edad = this.edad;
        this.altura = this.altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Edad: " + edad + " | Altura: " + altura + "m";
    }
}

class Parque {
    public int totalVisitantes;
    public int totalQueCumplenTodos;
    
    public Parque() {
        totalVisitantes = 0;
        totalQueCumplenTodos = 0;
    }

    public String verificarJuegos(Visitante v) {
        String juegos = "";
        int cumple = 0;

        if (v.getEdad() >= 12 && v.getAltura() >= 1.40) {
            juegos += "- Montaña Rusa\n";
            cumple++;
        }
        if (v.getEdad() >= 15 && v.getAltura() >= 1.50) {
            juegos += "- Casa del Terror\n";
            cumple++;
        }
        if (v.getEdad() >= 5 && v.getAltura() >= 1.00) {
            juegos += "- Carrusel\n";
            cumple++;
        }
        if (v.getEdad() >= 13 && v.getAltura() >= 1.45) {
            juegos += "- Torre de Caída\n";
            cumple++;
        }

        if (cumple == 4) {
            totalQueCumplenTodos++;
        }

        totalVisitantes++;

        if (cumple == 0) {
            juegos += "No puede acceder a ningún juego.\n";
        }

        return juegos;
    }

    public void mostrarResumen() {
        System.out.println("\n===== RESUMEN =====");
        System.out.println("Total visitantes registrados: " + totalVisitantes);
        System.out.println("Visitantes que cumplen con TODOS los juegos: " + totalQueCumplenTodos);
    }
}