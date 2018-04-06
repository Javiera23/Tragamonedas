import java.util.Scanner;
import java.util.Calendar;

public class Tragamonedas {
    private static Maquina maquina;
    private static Pozo pozo;
    private static int apuesta;

    public Tragamonedas(){
        pozo = new Pozo();
        maquina = new Maquina();
        apuesta = -1;
    }

    /**
     * Comienza una partida en el tragamonedas.
     * **/
    public static void comenzar() {
        bienvenida();
        jugar();
        despedida();

    }
    /**
     * Despliega un mensaje de bienvenida.
     * **/
    public static void bienvenida() {
        System.out.println("Bienvenido al Tragamonedas de Programacion I\n============================================");

    }

    /**
     * Despliega un mensaje de despedida.
     */
    public static void despedida() {
        System.out.println("Muchas gracias por jugar. Mejor suerte la proxima vez.");
    }

    /**
     * Despliega el valor del premio obtenido.
     */
    public static void montoPremio() {
        System.out.println("Ud. Obtiene $" + maquina.getPremio() + "!");
    }

    /**
     * Metodo que simula el jugar en el tragamonedas.
     */
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

    /**
     * Metodo que simula el proceso de realizar una apuesta.
     * @return true si se realizo la apuesta, false en caso contrario.
     */
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

    /**
     * Verifica si la apuesta tiene el formato correcto.
     * @param numero valor de la apuesta.
     * @return true si es valida, false en caso contrario.
     */
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

    /**
     * Despliega un mensaje de despedida dependiendo de la hora en que se realize la jugada.
     */
    public static void salir() {
        Calendar fecha = Calendar.getInstance();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);

        if((hora >= 6 && hora <= 11) && (minuto >= 00 || minuto <= 59)){
            System.out.println("Buenos días, gracias por jugar. Su saldo final es de $" + pozo.getSaldo() + ".");
        }
        else if((hora >= 12 && hora <= 19) && (minuto >= 00 || minuto <= 59)){
            System.out.println("Buenos tardes, gracias por jugar. Su saldo final es de $" + pozo.getSaldo() + ".");
        }
        else if((hora >= 20 || hora <= 5) && (minuto >= 00 || minuto <= 59)){
            System.out.println("Buenos noches, gracias por jugar. Su saldo final es de $" + pozo.getSaldo() + ".");
        }

    }

    /**
     * Despliega los numeros, simulando un tragamonedas.
     */
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




