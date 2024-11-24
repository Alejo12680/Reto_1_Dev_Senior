import java.util.Scanner;
import java.util.Random;

public class App {

    // Variables Globales
    static Scanner consola = new Scanner(System.in);
    static String[] planet = {"Mercurio", "Venus", "Marte", "Júpiter", "Saturno", "Urano", "Neptuno"};
    static double[] distance = {91.7, 42.4, 78.3, 628.9,  1284.4, 2721.4, 4345.4};
    static String[] naves = {"Orion", "Voyager", "Vostok", "Pandora", "Skywal"};
    static double[] speed = {900000.0, 100000.0, 500000.0, 700000.0, 1000000.0};
    static Random rm = new Random();
    static int porcentaje;
    static String[] events = {"Lluvia de Asteroides", "Daños en la Nave", "Desvio de la Nave", "Falta de Recursos"};
    static int indiceAleatorio;
    static int opcion1;
    static int opcion;
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
            System.out.println("░ 08. Salir..   ░");
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
        opcion1 = 0;

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
            opcion1 = consola.nextInt();

            if (opcion1 < 0 || opcion1 >= 6) {
                System.out.println("Saliendo del Menú Naves...\n");
                break;

            } else {
                System.out.printf("\n** Su nave es: (%s) con una velocidad de : (%s) Millones k/h **\n", naves[opcion1-1], speed[opcion1-1]);
            }
            startTrip();
            opcion1 = 6;
        } while (opcion1!=6);
    }



    public static void startTrip() throws InterruptedException {

        int porcentaje;
    
        for (porcentaje = 1; porcentaje <= 100; porcentaje++) {
            int mostrarEvento = rm.nextInt(10);
    
         if (mostrarEvento < 0.5) {
            indiceAleatorio = rm.nextInt(events.length);
            System.out.print("  .   -- The Travel " + porcentaje + "% " + events[indiceAleatorio] + "... --" + 
         "  .'.\r\n" + 
         "  |o|\r\n" + 
         " .'o'.\r\n" + 
         " |.-.|\r\n" + 
         " '   '\r\n" + 
         "  ( )\r\n" + 
         "   )\r\n" + 
         "  ( )\r\n");
        Thread.sleep(250);
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
        Thread.sleep(250);
        System.out.println();
       }
        System.out.println("*******************************"); 
        System.out.println("*                             *");
        System.out.println("*  VIAJE FINALIZADO CON ÉXITO *");
        System.out.println("*                             *"); 
        System.out.println("*******************************");
    
    }
    

//Metodos Auxiliares 

    public static void stopSpaceShip() throws InterruptedException {

        System.out.println("Ha ocurrido un evento");

        switch (events[indiceAleatorio]) {
            case "Lluvia de Asteroides":
                lluviaAsteroide();
                break;
            case "Daños en la Nave":
                dañosNave();
                break;
            case "Desvio de la Nave":
                desvioNave();
                break;
            default:
                break;
        }
        }

    public static void lluviaAsteroide () {
                    
                    System.out.println("Estamos pasando por una lluvia de asteroides.");
        
                    String[] random = {"Asteroide por abajo", "Asteroide por arriba", "Asteroide por la izquierda", "Asteroide por la derecha" };
                    int i = rm.nextInt(random.length);
                    
                    System.out.println("Atención " + random[i]);
        
                    System.out.println("Para esquivar presione: w: para arriba, s: para abajo, a: para la izquierda, d: para la derecha.");
                    String direccion = consola.next();                
                    
                    boolean a = true;
        
                 do {
                    switch (direccion) {
                        case "w":
                        if (i == 0) {
                           System.out.println("Subiendo");
                           System.out.println("Asteroide esquivado");
                        } else {System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);}
                           break;
                        case "s":
                        if (i == 1) {
                            System.out.println("Bajando");
                            System.out.println("Asteroide esquivado");
                        } else {System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);}
                            break;
                        case "a":
                        if (i == 3) {
                            System.out.println("Girando a la izquierda");
                            System.out.println("Asteroide esquivado");
                        } else {System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);}
                            break;
                        case "d":
                        if (i == 2) {
                            System.out.println("Girando a la derecha");
                            System.out.println("Asteroide esquivado");
                        } else {System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);}
                            break;
                        default:
                            System.out.println("Entrada no valida");
                            System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                            System.exit(0);
                            a = true;
                            break;
                       }   
                 } while (a = false);
        
                
       
        }
   
    public static void dañosNave () throws InterruptedException {
            System.out.println("Daños en la nave. Escaneando la estructura");
        for (int i = 0; i <= 100; i++) {
            Thread.sleep(100);
            System.out.println(i + "%");
        }
        System.out.println("Escaneo Completado");

        String[] damage = {"Daño en el propulsor", "Sobrecalentamiento del motor primario", "Daños en el sistema de comunicación"};
        int i = rm.nextInt(damage.length);
        System.out.println(damage[i]);

        String[] arrangement = {"Revisar el propulsor y cambiar las valvulas", "Revisar el sistema de refrigeramiento", "Arreglar la antena"};

        System.out.print("Debe arreglar los daños ");
        System.out.print("a: Revisar el propulsor y cambiar las valvulas \n" + " " +
                         "b: Revisar el sistema de refrigeramiento \n " + " " +
                         "c: Arreglar la antena" + " " );
        String a = consola.next();

        switch (a) {
            case "a":
            if (i == 0) {
                System.out.println("Revisando el propulsor");
                for (int e = 0; e <= 100; e++) {
                    Thread.sleep(100);
                    System.out.println(e + "%");
                }
                System.out.println("Cambiando las valvulas");
                for (int e = 0; e <= 100; e++) {
                    Thread.sleep(100);
                    System.out.println(e + "%");
                }
                System.out.println("Arreglo completado al 100%");
            } else { System.out.println("No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                System.exit(0);}
                break;
            case "b":
            if (i == 1) {
                System.out.println("Revisando el sistema de Refrigeración");
                for (int e = 0; e <= 100; e++) {
                    Thread.sleep(100);
                    System.out.println(e + "%");
                }
                System.out.println("Agregando liquido refrigerante");
                for (int e = 0; e <= 100; e++) {
                    Thread.sleep(100);
                    System.out.println(e + "%");
                }
                System.out.println("Arreglo completado al 100%");
            } else { System.out.println("No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
            System.exit(0);}
                break;
            case "c":
            if (i == 2) {
                System.out.println("Arreglando la antena de comunicación de la nave");
                for (int e = 0; e <= 100; e++) {
                    Thread.sleep(100);
                    System.out.println(e + "%");
                }
                System.out.println("Arreglo completado al 100%");
            }else { System.out.println("No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
            System.exit(0);}
                break;
            default:
                    System.out.println("Entrada no valida");
                    System.out.println("No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                System.exit(0);
                break;
        }

        }
   
    public static void desvioNave () throws InterruptedException {

        System.out.println("¡Atencion! La nave se está desviando de su rumbo");
        System.out.println("Dirigete a la cabina central y retoma el curso de la nave manualmente");
        System.out.println("*** ESTANDO EN LA CABINA ***");
        String[] lead = {"Redirigiendo rumbo de la nave", "No has redefinido el rumbo, estas perdido" };
        System.out.println("Presiona: a para redirijir el rumbo");
        String a = consola.next();

       switch (a) {
        case "a":
            System.out.println(lead[0]);
            for (int i = 0; i <= 100; i++) {
                System.out.println(i + "%");
                Thread.sleep(100);
            }
            System.out.println("Rumbo redefinido completado");
            break;
       
        default:
        System.out.println("Entrada no valida");
        System.out.println(lead[1]);
            System.exit(0);
            break;
       }
      

    }
}


        


    






        
    



