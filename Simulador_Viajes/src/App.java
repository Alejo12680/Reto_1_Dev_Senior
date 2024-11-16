import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Menu();
    }

    // Metodos
    public static void Menu() {

        var consola = new Scanner(System.in);
        int opc = 0;

        do {
            System.out.println("*** BIENVENIDO A VIAJES INTERESTELAR ***");
            System.out.println("Donde desea viajar: ");
            System.out.println("01. Marte");
            System.out.println("02. Mercurio");
            System.out.println("03. Saturno");
            System.out.println("04. Salir..");
            opc = consola.nextInt();

            switch (opc) {
                case 1:
                    // Metodo
                    System.out.println("Marte bienvenido\n");
                    break;

                case 2:
                    // Metodo
                    System.out.println("Mercurio bienvenido\n");
                    break;

                case 3:
                    // Metodo
                    System.out.println("Saturno bienvenido\n");
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

}
