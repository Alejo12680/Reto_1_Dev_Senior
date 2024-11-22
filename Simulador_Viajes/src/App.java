import java.util.Scanner;
import java.util.Random;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planet = { "Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno" };
    static double[] distance = { 91.7, 42.4, 78.3, 628.9, 1284.4, 2721.4, 4345.4 };
    static String[] naves = { "Orion", "Voyager", "Vostok", "Pandora", "Skywal" };
    static double[] speed = { 900000.0, 100000.0, 50000.0 };
    static String selectedPlanet = "Ninguno";
    static double selectedDistence = 0.0;
    static boolean planetSelected = false;
    static String selectedNave = "Ninguno";
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
            System.out.println("░█▀█░█░░░█▀█░█▀█░█▀▀░▀█▀░░░░█▀▀░█░█░█▀█░█▀▄░█▀▀░█▀▀░█▀▀\r\n" +
                    "░█▀▀░█░░░█▀█░█░█░█▀▀░░█░░░░░█▀▀░▄▀▄░█▀▀░█▀▄░█▀▀░▀▀█░▀▀█\r\n" +
                    "░▀░░░▀▀▀░▀░▀░▀░▀░▀▀▀░░▀░░▀░░▀▀▀░▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀\r\n");
            System.out.println("     ** MENU PRINCIPAL **");
            System.out.println("╔═..════════════════════════════..═╗");

            // Seleccion de Planeta
            if (selectedPlanet.equals("Ninguno")) {
                System.out.println(" 01. Seleccione el Destino      ");
            } else {
                System.out.printf("Planeta Seleccionado: %s   \n", selectedPlanet);
                System.out.printf("con una distancia de %s    \n", selectedDistence);
            }

            // Seleccion de Nave
            if (selectedNave.equals("Ninguno")) {
                System.out.println(" 02. Seleccione la Nave Espacial   ");
            } else {
                System.out.printf("Su nave es: %s     \n", selectedNave);
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
                    Resour();
                    break;

                case 4:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Digita la Opcion Correcta!!!\n");
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
            planetSelected = true;
        }
    }

    public static void SelectNave() throws InterruptedException {
        int opcion = 0;

        System.out.println("\n         ,\r\n" + //
                "       _=|_\r\n" + //
                "     _[_## ]_\r\n" + //
                "_  +[_[_+_]P/    _    |_       ____      _=-\r\n" +
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
            selectedNave = naves[opcion - 1];
            naveSelected = true;
        }
    }

    public static void Resour() throws InterruptedException {

        if (planetSelected && naveSelected) {
            System.out.println("\n** MODIFICAR RECURSOS **");
            System.out.println("╔═..═════..═╗");
            System.out.println("░ 0. No     ░");
            System.out.println("░ 1. Si     ░");
            System.out.println("╚═..═════..═╝\n");
            int calculo = consola.nextInt();

            if (calculo == 0) {
                userResour();
            } else {
                startTrip();
            }
        } else {
            System.out.println("\n╔═..══════════════════════════════════════════════..═╗");
            System.out.println(" Debes Elegir una Nave y un Planeta para viajar.");
            System.out.println("╚═..══════════════════════════════════════════════..═╝\n");
        }

    }

    public static void userResour() throws InterruptedException {
        System.out.println("╔═..══════════════════════════════════════════════..═╗");
        System.out.println(" Cuanto es la cantidad de Oxigeno que desea agregar?");
        System.out.println("╚═..══════════════════════════════════════════════..═╝\n");
        double oxygen = consola.nextDouble();

        System.out.println("╔═..══════════════════════════════════════════════════..═╗");
        System.out.println(" Cuanto es la cantidad de Combustible que desea agregar?");
        System.out.println("╚═..══════════════════════════════════════════════════..═╝\n");
        double fuel = consola.nextDouble();

        startTrip();

    }

    public static void startTrip() throws InterruptedException {

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
