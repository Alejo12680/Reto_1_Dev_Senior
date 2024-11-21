import java.util.Scanner;
import java.util.Random;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planet = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
    static double[] distance = {91.7, 42.4, 78.3, 628.9,  1284.4, 2721.4, 4345.4};
    static String[] naves = {"Orion", "Voyager", "Vostok", "Pandora", "Skywal"};
    static double[] speed = {900000.0, 100000.0, 50000.0};
    static Random rm = new Random();
    static int porcentaje;
    static String[] events = {"Lluvia de Asteroides", "Daños en la Nave", "Desvio de la Nave", "Falta de Recursos"};
    static int indiceAleatorio;

    public static void main(String[] args) throws Exception {
        Menu();
    }

    // Metodos
    public static void Menu() throws InterruptedException {

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
                    SelectNave();
                    break;

                case 3:
                    // Metodo
                        startTrip();

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
            } SelectNave();
            opcion = 9;
        } while (opcion!=9);

    }

    public static void SelectNave() throws InterruptedException {
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
             System.out.println("** SELECCIONE LA NAVE **");
            System.out.println("╔═..═════════..═╗");
            System.out.println("░ 01. Orion     ░");
            System.out.println("░ 02. Voyager   ░");
            System.out.println("░ 03. Vostok    ░");
            System.out.println("░ 04. Pandora   ░");
            System.out.println("░ 05. Skywal    ░");
            System.out.println("░ 06. Salir..   ░");
            System.out.println("╚═..═════════..═╝");
            System.out.print("Digita una Opcion: ");
            opcion = consola.nextInt();

            if (opcion < 0 || opcion >= 6) {
                System.out.println("Saliendo del Menú Naves...\n");
                break;

            } else {
                System.out.printf("\n** Su nave es: (%s) **\n", naves[opcion-1]);
            }
            Resour();
            opcion = 9;
        } while (opcion!=9);
    }

    public static void Resour() throws InterruptedException {
        System.out.println("Desea modificar los recusrsos a tu gusto? 0: Si. 1: No");
        int calculo = consola.nextInt();
       
        if (calculo == 0) {
            userResour();
        } else {
             startTrip();
    
    }



}

    public static void userResour() throws InterruptedException {
        System.out.println("Cuanto es la cantidad de oxigeno que desea agregar?");
        double oxygen = consola.nextDouble();
        System.out.println("Cuanto es la cantidad de combustible que desea agregar?");
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
         System.out.println("   .   -- The Travel " + porcentaje + "%" +  "... --\r\n" + 
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
        // parar la nave
    }

}


