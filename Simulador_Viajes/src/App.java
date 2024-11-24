import java.util.Scanner;
import java.util.Random;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planet = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double[] distance = { 910.7, 780.3, 420.4, 628.9, 1284.4, 2721.4, 4345.4 };
    // Unidad de oxígeno que gasta 1 pasajero por 1 dia
    static double oxigenPorDayPerson = 1.0;
    // Unidad de combustible que gasta una nave por millon de kilometros
    static double fuelConsumptionPorKm = 10.0;
    static String[] description = {
            "Es el planeta más pequeño del Sistema Solar y el más cercano al Sol, \nrico para un viaje solitario.",
            "Es el planeta del amor, tarda más tiempo en dar una vuelta sobre sí\nmismo, el tiempo suficiente para ir con tu amante.",
            "Es el segundo planeta más pequeño del sistema solar y tiene dos\nlunas, perfecto para una tarde de asado.",
            "Es un planeta gigante referente a Zeus, con demasiadas lunas para\nun viaje tranquilo y en calma.",
            "Es el planeta de los esposos, con unas hermosas lunas y anillos al\nrededor, especial para una luna de miel.",
            "Este planeta por ser tan alejado del sol conserva una temperatura baja\n, para un viaje frio.",
            "El plante del mar congelado, el planeta de la noche eterna, son las\nvegas, que el frio no acabe tu diversión." };

    static String[] ship = { "Orion", "Voyager", "Vostok", "Pandora", "Skywal" };
    static double[] speed = { 90.0, 10.0, 5.0, 80.0, 50.0 };
    static int[] passengers = { 5, 85, 90, 15, 45 };

    static String selectedPlanet = "Ninguno";
    static double selectedDistence = 0.0;
    static String selectedDescription = "";
    static double selectedSpeed = 0.0;
    static int selectedPassengers = 0;
    static boolean planetSelected = false;
    static String selectedShip = "Ninguno";
    static boolean naveSelected = false;

    static Random rm = new Random();
    static int porcentaje;
    static String[] events = { "Lluvia de Asteroides", "Daños en la Nave", "Desvio de la Nave", "Falta de Recursos" };
    static int indiceAleatorio;

    public static void main(String[] args) throws Exception {
        Menu();
    }

    // Metodos
    public static void Menu() throws InterruptedException {

        int opc = 0;

        do {
            System.out.println(
                    "\n░█▀█░█░░░█▀█░█▀█░█▀▀░▀█▀░░░░█▀▀░█░█░█▀█░█▀▄░█▀▀░█▀▀░█▀▀\r\n" +
                            "░█▀▀░█░░░█▀█░█░█░█▀▀░░█░░░░░█▀▀░▄▀▄░█▀▀░█▀▄░█▀▀░▀▀█░▀▀█\r\n" +
                            "░▀░░░▀▀▀░▀░▀░▀░▀░▀▀▀░░▀░░▀░░▀▀▀░▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀\r\n");
            System.out.println("     ** MENU PRINCIPAL **");
            System.out.println("╔═..════════════════════════════..═╗");

            // Seleccion de Planeta
            if (selectedPlanet.equals("Ninguno")) {
                System.out.println(" 01. Seleccione el Destino      ");
            } else {
                System.out.println("Planeta Seleccionado: " + selectedPlanet);
                System.out.println(selectedDescription);
                System.out.println("con una Distancia de " + selectedDistence + " Millones Kilometros");
                System.out.println(); // Aseguramos un salto de línea extra
            }

            // Seleccion de Nave
            if (selectedShip.equals("Ninguno")) {
                System.out.println(" 02. Seleccione la Nave Espacial   ");
            } else {
                System.out.println("Su nave es: " + selectedShip);
                System.out.println("con una velocidad de " + selectedSpeed + " Millones de Km/H");
                System.out.println("y su capacidad es de " + selectedPassengers + " pasajeros");
                System.out.println(); // Aseguramos otro salto de línea extra
            }

            System.out.println(" 03. Inicio del Viaje              ");
            System.out.println(" 04. Salir..                       ");
            System.out.println("╚═..════════════════════════════..═╝");
            System.out.print("Digita una Opcion: ");
            opc = consola.nextInt();

            switch (opc) {
                case 1:
                    // Metodo:
                    if (!planetSelected) {
                        SelectPlanet();
                    } else {
                        System.out.println("\n╔═..══════════════════════════════════════════════..═╗");
                        System.out.println(" Ya has seleccionado un destino y no puedes cambiarlo.");
                        System.out.println("╚═..══════════════════════════════════════════════..═╝\n");
                    }
                    break;

                case 2:
                    // Metodo
                    if (!naveSelected) {
                        SelectNave();
                    } else {
                        System.out.println("\n╔═..══════════════════════════════════════════════..═╗");
                        System.out.println(" Ya has seleccionado una nave para el viaje.");
                        System.out.println("╚═..══════════════════════════════════════════════..═╝\n");
                    }
                    break;

                case 3:
                    // Metodo
                    Capacity();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Digito una opcion incorrecta!!!\n");
                    break;
            }

        } while (opc != 4);

        consola.close();
    }

    public static void SelectPlanet() throws InterruptedException {
        int opcion = 0;

        System.out.println("\n    .    _     *           .       .      -*-       +\r\n" +
                "      .' \\\\`.     +    -*-     *   .      '     .   *\r\n" +
                "   .  |__''_|  .        +     .    +     .     |\r\n" +
                "      |     | .         .       -*-            \r\n" +
                "      |     |    .         *      .    +      '\r\n" +
                "    _.'-----'-._     *                  .\r\n" +
                "  /             \\__.__.--._           \r\n");
        System.out.println("** SELECCIONE EL PLANETA **");
        System.out.println("╔═..═════════..═╗");
        System.out.println("░ 01. Mercurio  ░");
        System.out.println("░ 02. Venus     ░");
        System.out.println("░ 03. Marte     ░");
        System.out.println("░ 04. Júpiter   ░");
        System.out.println("░ 05. Saturno   ░");
        System.out.println("░ 06. Urano     ░");
        System.out.println("░ 07. Neptuno   ░");
        System.out.println("╚═..═════════..═╝");
        System.out.print("Digita una Opcion: ");
        opcion = consola.nextInt();

        if (opcion < 0 || opcion >= 8) {
            System.out.println("Saliendo del Menú Planeta...\n");

        } else {
            selectedPlanet = planet[opcion - 1];
            selectedDistence = distance[opcion - 1];
            selectedDescription = description[opcion - 1];
            planetSelected = true;
        }
    }

    public static void SelectNave() throws InterruptedException {
        int opcion = 0;

        System.out.println("\n         ,\r\n" + //
                "       _=|_\r\n" + //
                "     _[_## ]_\r\n" + //
                "_  +[_[_+_]_/    _    |_       ____      _=-\r\n" +
                " ~---\\_I_I_[=\\--~ ~~--[o]--==-|##==]-=-~~ \r\n" +
                "-~ /[_[_|_]_]\\\\  -_  [[=]]    |====]  __  \r\n" +
                "  /    \"|\"    \\      ^U-U^  - |    - ~ .~\r\n" +
                " ~~--__~~~--__~~-__   H_H_    |_     --     \r\n" +
                "-. _  ~~~  ~~~=~~  -~~--~~  ~~~-    ~~--  ._\r\n" +
                "             _     . -      _ _ ");
        System.out.println("** SELECCIONE LA NAVE **");
        System.out.println("╔═..═════════..═╗");
        System.out.println("░ 01. Orion     ░");
        System.out.println("░ 02. Voyager   ░");
        System.out.println("░ 03. Vostok    ░");
        System.out.println("░ 04. Pandora   ░");
        System.out.println("░ 05. Skywal    ░");
        System.out.println("╚═..═════════..═╝");
        System.out.print("Digita una Opcion: ");
        opcion = consola.nextInt();

        if (opcion < 0 || opcion >= 6) {
            System.out.println("Saliendo del Menú Naves...\n");

        } else {
            selectedShip = ship[opcion - 1];
            selectedSpeed = speed[opcion - 1];
            selectedPassengers = passengers[opcion - 1];
            naveSelected = true;
        }
    }

    public static void Capacity() throws InterruptedException {

        double result = selectedDistence / selectedSpeed;
        int days = (int) Math.floor(result);

        if (planetSelected && naveSelected) {
            System.out.println("\n** GESTOR DE CAPACIDAD DE LA NAVE **");
            System.out.println("╔═..══════════════════════════════════════════════════..═╗");
            System.out.println(
                    " Su nave es " + selectedShip + " y su capacidad es de " + selectedPassengers + " pasajeros");
            System.out.println(" con una velocidad de " + selectedDistence + " Millones de Km/H");
            System.out.printf(" el viaje dura aproximadamente %d dias.\n", days);
            System.out.println("╚═..══════════════════════════════════════════════════..═╝");
            System.out.print("Cuantos pasajeros van a viajar? ");
            int person = consola.nextInt();

            if (person > selectedPassengers && person <= 0) {
                System.out.println("\n╔═..══════════════════════════════════════════════════════════..═╗");
                System.out.println(" Excede la capacidad de la nave, sera redirigido al menu de naves.");
                System.out.println("╚═..══════════════════════════════════════════════════════════..═╝");
                System.out.println("Presione 'Enter' para continuar...");
                // Este fracmento sirve para que el usuario de Enter, toco dos
                // consola.nextLine(); porque toca Limpia el buffer de entrada, porque
                // anteriormente se utilizo consola.nextInt(); que es un entero.
                consola.nextLine();
                consola.nextLine();
                SelectNave();

            } else {
                Resour();
            }

        } else {
            System.out.println("\n╔═..══════════════════════════════════════════════..═╗");
            System.out.println(" Debes Elegir una Nave y un Planeta para viajar.");
            System.out.println("╚═..══════════════════════════════════════════════..═╝\n");
        }

    }

    public static void Resour() throws InterruptedException {

        System.out.println(
                "\n           ___\r\n" + //
                        "     |     | |\r\n" + //
                        "    / \\    | |\r\n" + //
                        "   |--o|===|-|\r\n" + //
                        "   |---|   |p|\r\n" + //
                        "  /     \\  |w|\r\n" + //
                        " | C     | |d|\r\n" + //
                        " | O     |=| |\r\n" + //
                        " | L     | | |\r\n" + //
                        " |_______| |_|\r\n" + //
                        "  |@| |@|  | |\r\n" + //
                        "___________|_|_\r\n");

        System.out.println("\n** GESTOR DE RECURSOS DE LA NAVE **");
        System.out.println("╔═..════════════════════════════════════════════════..═╗");
        System.out.println("░ Ingrese la cantidad de Oxigeno que desea llevar?     ░");
        double oxygen = consola.nextDouble();
        System.out.printf(" El oxigeno para el viaje es de %.1f unidades\n", oxygen);

        System.out.println("░ Ingrese la cantidad de Combustible que desea llevar? ░");
        double fuel = consola.nextDouble();
        System.out.printf(" El combustible para el viaje es de %.1f unidades\n", fuel);
        System.out.println("╚═..════════════════════════════════════════════════..═╝");

        System.out.println("Presione 'Enter' para iniciar el viaje...");
        // Limpiamos el Buffer
        consola.nextLine();
        consola.nextLine();
        StartTrip();
        
    }

    public static void StartTrip() throws InterruptedException {

        int porcentaje;

        for (porcentaje = 1; porcentaje <= 100; porcentaje++) {
            int mostrarEvento = rm.nextInt(10);

            if (mostrarEvento < 0.5) {
                indiceAleatorio = rm.nextInt(events.length);
                System.out.print("\\r  .   -- The Travel " + porcentaje + "% " + events[indiceAleatorio] + "... --" +
                        "  .'.\r\n" +
                        "  |o|\r\n" +
                        " .'o'.\r\n" +
                        " |.-.|\r\n" +
                        " '   '\r\n" +
                        "  ( )\r\n" +
                        "   )\r\n" +
                        "  ( )\r\n");
                Thread.sleep(200);
                stopSpaceShip();
                System.out.println();
            } else
                System.out.println("   .   -- The Travel " + porcentaje + "%" + "... --\r\n" +
                        "  .'.\r\n" +
                        "  |o|\r\n" +
                        " .'o'.\r\n" +
                        " |.-.|\r\n" +
                        " '   '\r\n" +
                        "  ( )\r\n" +
                        "   )\r\n" +
                        "  ( )\r\n");
            Thread.sleep(200);
            System.out.println();
        }
        System.out.println("Viaje Finalizado con Exito");

    }

    public static void stopSpaceShip() {
        // parar la nave espacial
    }

}
