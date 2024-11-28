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
    static int days = 0;

    static int cantPerson = 0;
    static String selectedPlanet = "Ninguno";
    static double selectedDistence = 0.0;
    static String selectedDescription = "";
    static double selectedSpeed = 0.0;
    static int selectedPassengers = 0;
    static boolean planetSelected = false;
    static String selectedShip = "Ninguno";
    static boolean naveSelected = false;

    static String[] events = { "Lluvia de Asteroides", "Daños en la Nave", "Desvio de la Nave" };
    static String[] states = { "Inicio del viaje", "Mitad del camino", "Llegada al destino" };
    static Random rm = new Random();
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
        opcion1 = 0;

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

        // formula para sacar el tiempo es Tiempo = Distancia/Velocidad
        double result = selectedDistence / selectedSpeed;
        days = (int) Math.floor(result);

        if (planetSelected && naveSelected) {
            System.out.println("\n** GESTOR DE CAPACIDAD DE LA NAVE **");
            System.out.println("╔═..═══════════════════════════════════════════════..═╗");
            System.out.println(
                    " Su nave es " + selectedShip + " y su capacidad es de " + selectedPassengers + " pasajeros");
            System.out.println(" con una velocidad de " + selectedDistence + " Millones de Km/H");
            System.out.printf(" el viaje dura aproximadamente %d dias.\n", days);
            System.out.println("╚═..═══════════════════════════════════════════════..═╝");
            System.out.print("Cuantos pasajeros van a viajar? ");
            cantPerson = consola.nextInt();

            System.out.println(cantPerson);
            System.out.println(selectedPassengers);
            System.out.println(cantPerson > selectedPassengers || cantPerson <= 0);

            if (cantPerson > selectedPassengers || cantPerson <= 0) {
                System.out.println(
                        "\n╔═..══════════════════════════════════════════════════════════════════════════════..═╗");
                System.out.println(
                        " Error excede la capacidad de la nave o esta vacia , sera redirigido al menu de naves.");
                System.out.println(
                        "╚═..══════════════════════════════════════════════════════════════════════════════..═╝");
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
        System.out.println("╔═..══════════════════════════════════════════..═╗");
        System.out.print("░ Cuantas unidades de oxigeno va llevar? ");
        double oxygen = consola.nextDouble();
        System.out.printf("░ El oxigeno para el viaje es de %.1f unidades    ░\n\n", oxygen);

        System.out.print("░ Cuantos galones va llevar para el viaje? ");
        double fuel = consola.nextDouble();
        System.out.printf("░ El combustible para el viaje es de %.1f galones ░\n", fuel);
        System.out.println("╚═..══════════════════════════════════════════..═╝");

        System.out.println("Presione 'Enter' para iniciar el viaje...");
        // Limpiamos el Buffer
        consola.nextLine();
        consola.nextLine();
        StartTrip(oxygen, fuel);

    }

    public static void StartTrip(double oxigeno, double combustible) throws InterruptedException {

        // Calcula para la cantidad necesaria para llegar al destino
        var totalOxigen = cantPerson * days * oxigenPorDayPerson;
        /* System.out.println(totalOxigen); */

        // Calculo necesario para el combustible alcance y llegue a su destino
        var totalFuel = selectedDistence * fuelConsumptionPorKm;
        /* System.out.println(totalFuel); */

        double oxigenoSeleccionado = oxigeno;
        double combustibleSeleccionado = combustible;

        int porcentaje;

        for (porcentaje = 1; porcentaje <= 100; porcentaje++) {

            if (porcentaje == 1) {
                System.out.println("\n.=====================================.\r\n" +
                        "|| * " + states[0] + "              * ||\r\n" +
                        "`=====================================`\r\n");
            }

            if (porcentaje == 50) {
                System.out.println("\n.=====================================.\r\n" +
                        "|| * " + states[1] + "             * ||\r\n" +
                        "`=====================================`\r\n");
            }

            if (porcentaje == 100) {
                System.out.println("\n.=====================================.\r\n" +
                        "|| * " + states[2] + "            * ||\r\n" +
                        "`=====================================`\r\n");
            }

            // Calcular y mostrar el tiempo restante estimado (asumimos que cada iteración
            // representa el 1% del tiempo total)
            int tiempoRestante = (int) Math.round(days * (100 - porcentaje) / 100.0);

            // Para mostrar el evento de los metodos auxiliares
            int mostrarEvento = rm.nextInt(10);

            // Calcular reducción de recursos del usuario a medida que avanza el viaje y se
            // reducen
            oxigeno -= oxigenoSeleccionado / 100;
            combustible -= combustibleSeleccionado / 100;

            System.out.printf("         Tiempo restante: %d días\n", tiempoRestante);
            System.out.printf("         Oxígeno restante: %.1f\n", oxigeno);
            System.out.printf("         Combustible restante: %.1f\n", combustible);

            if (mostrarEvento < 0.3) {

                indiceAleatorio = rm.nextInt(events.length);

                System.out.print("   . -- The Travel " + porcentaje + "% " + events[indiceAleatorio] + "... --\r\n" +
                        "  .'. \r\n" +
                        "  |o| \r\n" +
                        " .'o'.\r\n" +
                        " |.-.|\r\n" +
                        " '   '\r\n" +
                        "  ( )\r\n" +
                        "   )\r\n" +
                        "  ( )\r\n");

                // Sirve para pausar la simulacion y el avance del viaje
                Thread.sleep(250);

                // Metodos Auxiliares
                stopSpaceShip();

            } else {

                System.out.print("   . -- The Travel " + porcentaje + "%" + "... --\r\n" +
                        "  .'. \r\n" +
                        "  |o| \r\n" +
                        " .'o'.\r\n" +
                        " |.-.|\r\n" +
                        " '   '\r\n" +
                        "  ( )\r\n" +
                        "   )\r\n" +
                        "  ( )\r\n");

                // Sirve para pausar la simulacion y el avance del viaje
                Thread.sleep(250);
            }

            if (oxigeno <= 0 || combustible <= 0) {
                System.out.println("*  Recursos totales restantes para completar el viaje: *");
                System.out.printf("   Oxígeno restante del total: %.1f\n",
                        totalOxigen - (totalOxigen * porcentaje / 100));
                System.out.printf("   Combustible restante del total: %.1f\n",
                        totalFuel - (totalFuel * porcentaje / 100));
                System.out.println("**********************************");
                System.out.println("*  Los recursos se han agotado   *");
                System.out.println("*  La nave se ha quedado varada  *");
                System.out.println("**********************************");
                System.exit(0);
            }

        }

        System.out.println("*\n=================================*");
        System.out.println("*  VIAJE FINALIZADO CON ÉXITO...  *");
        System.out.println("*=================================*");

    }

    // Metodos Auxiliares
    public static void ResourConsumo() {
        
    }

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

    public static void lluviaAsteroide() {

        System.out.println("Estamos pasando por una lluvia de asteroides.");

        String[] random = { "Asteroide por abajo", "Asteroide por arriba", "Asteroide por la izquierda",
                "Asteroide por la derecha" };
        int i = rm.nextInt(random.length);

        System.out.println("Atención " + random[i]);

        System.out.println(
                "Para esquivar presione: w: para arriba, s: para abajo, a: para la izquierda, d: para la derecha.");
        String direccion = consola.next();

        boolean a = true;

        do {
            switch (direccion) {
                case "w":
                    if (i == 0) {
                        System.out.println("Subiendo");
                        System.out.println("Asteroide esquivado");
                    } else {
                        System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);
                    }
                    break;
                case "s":
                    if (i == 1) {
                        System.out.println("Bajando");
                        System.out.println("Asteroide esquivado");
                    } else {
                        System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);
                    }
                    break;
                case "a":
                    if (i == 3) {
                        System.out.println("Girando a la izquierda");
                        System.out.println("Asteroide esquivado");
                    } else {
                        System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);
                    }
                    break;
                case "d":
                    if (i == 2) {
                        System.out.println("Girando a la derecha");
                        System.out.println("Asteroide esquivado");
                    } else {
                        System.out.println("Te has estrellado con el asteroide, estas MUERTO");
                        System.exit(0);
                    }
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

    public static void dañosNave() throws InterruptedException {
        System.out.println("Daños en la nave. Escaneando la estructura");
        for (int i = 20; i <= 100; i+=20) {
            Thread.sleep(50);
            System.out.println(i + "%");
        }

        System.out.println("Escaneo Completado");

        String[] damage = { "Daño en el propulsor", "Sobrecalentamiento del motor primario",
                "Daños en el sistema de comunicación" };
        int i = rm.nextInt(damage.length);
        System.out.println(damage[i]);

        String[] arrangement = { "Revisar el propulsor y cambiar las valvulas", "Revisar el sistema de refrigeramiento",
                "Arreglar la antena" };

        System.out.println("Debe arreglar los daños ");
        System.out.println("a: Revisar el propulsor y cambiar las valvulas \n" +
                "b: Revisar el sistema de refrigeramiento \n " +
                "c: Arreglar la antena" + " ");
        String a = consola.next();

        switch (a) {
            case "a":
                if (i == 0) {
                    System.out.println("Revisando el propulsor");
                    for (int e = 20; e <= 100; e+=20) {
                        Thread.sleep(50);
                        System.out.println(e + "%");
                    }
                    System.out.println("Cambiando las valvulas");
                    for (int e = 20; e <= 100; e+=20) {
                        Thread.sleep(50);
                        System.out.println(e + "%");
                    }
                    System.out.println("Arreglo completado al 100%");
                } else {
                    System.out.println(
                            "No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                    System.exit(0);
                }
                break;

            case "b":
                if (i == 1) {
                    System.out.println("Revisando el sistema de Refrigeración");
                    for (int e = 20; e <= 100; e+=20) {
                        Thread.sleep(50);
                        System.out.println(e + "%");
                    }
                    System.out.println("Agregando liquido refrigerante");
                    for (int e = 20; e <= 100; e+=20) {
                        Thread.sleep(50);
                        System.out.println(e + "%");
                    }
                    System.out.println("Arreglo completado al 100%");
                } else {
                    System.out.println(
                            "No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                    System.exit(0);
                }
                break;

            case "c":
                if (i == 2) {
                    System.out.println("Arreglando la antena de comunicación de la nave");
                    for (int e = 20; e <= 100; e+=20) {
                        Thread.sleep(50);
                        System.out.println(e + "%");
                    }
                    System.out.println("Arreglo completado al 100%");
                } else {
                    System.out.println(
                            "No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                    System.exit(0);
                }
                break;

            default:
                System.out.println("Entrada no valida");
                System.out
                        .println("No arreglaste los daños, la nave no pude seguir, te has barado en mitad de la nada");
                System.exit(0);
                break;
        }

    }

    public static void desvioNave() throws InterruptedException {

        System.out.println("¡Atencion! La nave se está desviando de su rumbo");
        System.out.println("Dirigete a la cabina central y retoma el curso de la nave manualmente");
        System.out.println("*** ESTANDO EN LA CABINA ***");
        String[] lead = { "Redirigiendo rumbo de la nave", "No has redefinido el rumbo, estas perdido" };
        System.out.println("Presiona: (a), para redirijir el rumbo");
        String a = consola.next();

        switch (a) {
            case "a":
                System.out.println(lead[0]);
                for (int i = 0; i <= 100; i++) {
                    System.out.println(i + "%");
                    Thread.sleep(50);
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
