import java.util.*;

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
            System.out.println("Introduce opción....");
            try {
                opcion = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.err.println("Solo admite números");
                scanner.nextLine();  //limpiando la salida del scanner
            }

            switch (opcion) {
                case 1 -> calcularEnergiaPotencial(); //COMENTARIOS
                case 2 -> procesarPalabras();
                case 3 -> operarMatematicament();
                case 4 -> averiguarNumero(); //DOCUMENTACION
            }
        } while (opcion != 5);
        scanner.close();
        System.out.println("Fin de programa");
    }

    private static void averiguarNumero() {
        final int DATOS = 20;
        Random random = new Random();
        //definimos un List de enteros
        List<Integer> numeros = new ArrayList<>();
        //llenamos con nº aleatorios de 0(in) a 10(ex)
        //bucle hasta que el tamaño de Set sea 10
        do {
            int numero = random.nextInt(DATOS);
            if (numeros.contains(numero))
                continue;
            numeros.add(numero);
        } while (numeros.size() != DATOS);
        System.out.println(numeros);
        //seleccionamos el nº a averiguar, random por posicio de 0 a 10 del Set
        int posicionRandom = random.nextInt(numeros.size());
        int numeroAveriguar = numeros.get(posicionRandom);
        int numeroIntentos = 0;
        int numeroSupuesto = -1;
        System.out.println("Introduce nº a averiguar");
        do {
            numeroSupuesto = scanner.nextInt();
            numeroIntentos++;
        } while (numeroAveriguar != numeroSupuesto);
        System.out.printf("El nº a averiguar era: %d, estaba en la posición %d y has necesitado %d intentos%n%n",
                numeroAveriguar, posicionRandom, numeroIntentos);
        //solicitas número hasta que aciertes el nº de esa posición
        //mostramos el nº a averiguar y el nº de intentos
    }

    private static void operarMatematicament() {
        String sNumero1 = "", sNumero2 = "", operacion ="";
        System.out.println("Introduce el primer número entero");
        do {
            sNumero1 = scanner.nextLine();
        } while (!sNumero1.matches("[0-9]+"));
        System.out.println("Introduce la operación aritmética ( + - / x )");
        do {
            operacion = scanner.nextLine();
        } while (!operacion.matches("[-+/x]"));
        System.out.println("Introduce el segundo número entero");
        do {
            sNumero2 = scanner.nextLine();
        } while (!sNumero2.matches("[0-9]+"));
        int numero1 = Integer.parseInt(sNumero1);
        int numero2 = Integer.parseInt(sNumero2);
        int resultado = 0;
        switch (operacion) {
            case "+" -> resultado = numero1 + numero2;
            case "-" -> resultado = numero1 - numero2;
            case "/" -> resultado = numero1 / numero2;
            case "x" -> resultado = numero1 * numero2;
        }
        System.out.printf("%d %s %d = %d%n%n", numero1, operacion, numero2, resultado);
    }

    private static void procesarPalabras() {
        int contadorEmpiezaPorVocal = 0, contadorAcabanEnVocal = 0, contadorPalabrasConTilde = 0;
        int numeroPalabras = 0;
        System.out.println("Introduce el nº de palabras a analizar");
        do {
            try {
                numeroPalabras = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Formato incorrecto");
                scanner.nextLine();
            }
        } while (numeroPalabras < 3 || numeroPalabras > 10);
        System.out.printf("Introduce %d palabras%n", numeroPalabras);

        for (int i = 0; i <= numeroPalabras; i++) {
            String palabra = scanner.nextLine();
            if (palabra.toLowerCase().matches("[aeiouáéíóú].*"))
                contadorEmpiezaPorVocal++;
            if (palabra.toLowerCase().matches(".*[aeiouáéíóú]"))
                contadorAcabanEnVocal++;
            if (palabra.toLowerCase().matches(".*[áéíóú].*"))
                contadorPalabrasConTilde++;
        }
        System.out.printf("Leídas %d palabras. Palabras que empiezan por vocal %d. Palabras que acaban en vocal %d. Palabras con tilde %d%n%n",
                    numeroPalabras, contadorEmpiezaPorVocal, contadorAcabanEnVocal, contadorPalabrasConTilde);

    }

    private static void calcularEnergiaPotencial() {
        String regexNumerosDecimales = "[0-9]+\\.[0-9]+";  //2,3  0,8  78,89 ...
        String regexNumerosEnteros   = "[0-9]+";
        //Ep = m·g·h
        final float GRAVEDAD = 9.8f;
        float masa, altura = 0, energiaPotencial;
        String sMasa, sAltura;
        System.out.println("Introduce la masa en kg, ejemplos 25  2.25  66.666:");
        do {
            sMasa = scanner.nextLine();
        } while (! sMasa.matches(regexNumerosDecimales + "|" + regexNumerosEnteros));
        masa = Float.parseFloat(sMasa);

        System.out.println("Introduce la altura en m, ejemplos: 5,5  5  65 6,8798");
        while (true) {
            try {
                altura = scanner.nextFloat();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Formato incorrecto");
                scanner.nextLine(); //limpiamos la entrada del scanner
            }
        }
        energiaPotencial = masa * GRAVEDAD * altura;
        System.out.printf("La energía potencial de un cuerpo de %.2f kg. que cae de una altura de %.2f m. vales %.2f J%n",
                masa, altura, energiaPotencial);
        System.out.printf("La energía potencial de un cuerpo de %d kg. que cae de una altura de %d m. vales %d J%n%n",
                (int) masa, (int) altura, (int) energiaPotencial);
    }

}
