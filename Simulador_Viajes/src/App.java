import java.util.Scanner;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planetas = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};

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
                    // Metodo
                    System.out.println("Seleccion de planeta");
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

    }

    public static void SelectNave() {

    }

    public static void calculateResour() {

    }



}
