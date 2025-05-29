import java.util.Scanner;

public class EjercicioRA_1_2_3 {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String menu = """
                1.- Calcular Energia potencial.
                2.- Procesar palabras.
                3.- Operaciones aritméticas.
                4.- Averiguar número.
                5.- Salir.
                
                """;
        int opcion = -1;
        do {
            System.out.println(menu);
            opcion = scanner.nextInt();
            System.out.println("Introduce opción....");
            switch (opcion) {
                case 1 -> calcularEnergiaPotencial();
                case 2 -> procesarPalabras();
                case 3 -> operarMatematicament();
                case 4 -> averiguarNumero();
            }
        } while (opcion != 5);
        scanner.close();
        System.out.println("Fin de programa");
    }

    private static void averiguarNumero() {
    }

    private static void operarMatematicament() {
    }

    private static void procesarPalabras() {
        System.out.println("procesando palabras");
    }

    private static void calcularEnergiaPotencial() {
        System.out.println("calculando Ep");
    }

}
