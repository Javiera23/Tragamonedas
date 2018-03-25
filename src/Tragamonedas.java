import java.util.Scanner;
public class Tragamonedas {
    private static Maquina maquina;
    private static Pozo pozo;
    private static int apuesta;

    public Tragamonedas(){
        pozo = new Pozo();
        maquina = new Maquina();
    }
    public static void comenzar() {
        bienvenida();
        jugar();
        despedida();

    }

    public static void bienvenida() {
        System.out.println("Bienvenido al Tragamonedas de Programacion I\n============================================");

    }

    public static void despedida() {
        System.out.println("Muchas gracias por jugar. Mejor suerte la proxima vez.");
    }

    public static void montoPremio() {
        System.out.println("Ud. Obtiene $" + maquina.getPremio() + "!");
    }

    public static void jugar() {
        while (pozo.getSaldo() > 0) {
            if (realizarApuesta()) {
                maquina.generarNumero();
                mostrarNumeros();
                maquina.calcularPremio(apuesta);
                montoPremio();
                if (maquina.getPremio() > 0) {
                    pozo.actualizarSaldo(maquina.getPremio());
                }
            }
            if (apuesta == 0) {
                salir();
                break;
            }
        }
    }

    public static boolean realizarApuesta() {
        System.out.println("Su saldo actual es de $" + pozo.getSaldo() + ".  ¿Cuanto desea apostar?");
        String numero = "";
        Scanner entradaEscaner = new Scanner(System.in);
        numero = entradaEscaner.nextLine();
        numero = numero.replaceAll(" ", "");
        if (apuestaEsValida(numero)) {
            pozo.setSaldo(apuesta);
            return true;
        }
        return false;
    }

    public static boolean apuestaEsValida(String numero) {
        try {
            apuesta = Integer.parseInt(numero);
            if(apuesta > pozo.getSaldo() || apuesta < 0) {
                System.out.println("Ingrese un monto valido para apostar.");
                return false;
            }
            return (apuesta <= pozo.getSaldo() && apuesta > 0);

        } catch (NumberFormatException nfe) {
            System.out.println("Ingrese un monto valido para apostar.");
            return false;
        }
    }

    public static void salir() {
        System.out.println("Gracias por jugar. Su saldo final es de $" + pozo.getSaldo() + ".");

    }

    public static void mostrarNumeros() {
        System.out.println("+--+--+--+");
        for (int i = 0; i < maquina.getNumeros().length; i++) {
            if(maquina.getNumeros()[i] == 0) {
                System.out.print("*\t");
            }else{
                System.out.print(maquina.getNumeros()[i] + "\t");
            }
        }

        System.out.println();
        System.out.println("+--+--+--+");
    }
}



