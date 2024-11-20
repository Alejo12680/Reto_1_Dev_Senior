import java.util.Scanner;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planet = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
    static double[] distance = {91.7, 42.4, 78.3, 628.9,  1284.4, 2721.4, 4345.4};
    static String[] naves = {"Nave Leviatan", "Nave Olimpus", "Nave Pandora"};
    static double[] speed = {900000.0, 100000.0, 50000.0};

    public static void main(String[] args) throws Exception {
        Menu();
    }

    // Metodos
    public static void Menu() {

        int opc = 0;

        do {
            System.out.println( "░█▀█░█░░░█▀█░█▀█░█▀▀░▀█▀░░░░█▀▀░█░█░█▀█░█▀▄░█▀▀░█▀▀░█▀▀\r\n" + 
                                "░█▀▀░█░░░█▀█░█░█░█▀▀░░█░░░░░█▀▀░▄▀▄░█▀▀░█▀▄░█▀▀░▀▀█░▀▀█\r\n" + 
                                "░▀░░░▀▀▀░▀░▀░▀░▀░▀▀▀░░▀░░▀░░▀▀▀░▀░▀░▀░░░▀░▀░▀▀▀░▀▀▀░▀▀▀\r\n");
            System.out.println("     ** MENU PRINCIPAL **");
            System.out.println("╔═..══════════════════════════..═╗");
            System.out.println("░ 01. Seleccione el Destino      ░");
            System.out.println("░ 02. Seleccione la Nave Espacial░");
            System.out.println("░ 03. Inicio del Viaje           ░");
            System.out.println("░ 04. Salir..                    ░");
            System.out.println("╚═..══════════════════════════..═╝");
            System.out.print("Digita una Opcion: ");
            opc = consola.nextInt();

            switch (opc) {
                case 1:
                    // Metodo:
                    SelectPlanet();
                    break;

                case 2:
                    // Metodo
                    System.out.println("Mercurio bienvenido\n");
                    break;

                case 3:
                    // Metodo
                    System.out.println("   .   -- The Travel 12% ... --\r\n" + 
                                       "  .'.\r\n" + 
                                       "  |o|\r\n" + 
                                       " .'o'.\r\n" + 
                                       " |.-.|\r\n" + 
                                       " '   '\r\n" + 
                                       "  ( )\r\n" + 
                                       "   )\r\n" + 
                                       "  ( )\r\n");
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

    public static void SelectPlanet() {
        int opcion = 0;

        do {
            System.out.println("         ,\r\n" + //
                               "       _=|_\r\n" + //
                               "     _[_## ]_\r\n" + //
                               "_  +[_[_+_]P/    _    |_       ____      _=-\r\n" + 
                               " ~---\\_I_I_[=\\--~ ~~--[o]--==-|##==]-=-~~ \r\n" + 
                               "-~ /[_[_|_]_]\\\\  -_  [[=]]    |====]  __  \r\n" + 
                               "  /    \"|\"    \\      ^U-U^  - |    - ~ .~\r\n" + 
                               " ~~--__~~~--__~~-__   H_H_    |_     --     \r\n" + 
                               "-. _  ~~~  ~~~=~~  -~~--~~  ~~~-    ~~--  ._\r\n" + 
                               "             _     . -      _ _ ");
             System.out.println("** SELECCIONE EL PLANETA **");
            System.out.println("╔═..═════════..═╗");
            System.out.println("░ 01. Mercurio  ░");
            System.out.println("░ 02. Venus     ░");
            System.out.println("░ 03. Marte     ░");
            System.out.println("░ 04. Júpiter   ░");
            System.out.println("░ 05. Saturno   ░");
            System.out.println("░ 06. Urano     ░");
            System.out.println("░ 07. Neptuno   ░");
            System.out.println("░ 09. Salir..   ░");
            System.out.println("╚═..═════════..═╝");
            System.out.print("Digita una Opcion: ");
            opcion = consola.nextInt();

            if (opcion < 0 || opcion >= 9) {
                System.out.println("Saliendo del Menú Planeta...\n");
                break;

            } else {
                System.out.printf("\n** Su destino es el planeta (%s) con una distancia de (%s) Millones de Kilometros **\n", planet[opcion-1], distance[opcion-1]);
            }

        } while (opcion!=9);

    }

    public static void SelectNave() {

    }

    public static void calculateResour() {

    }



}
