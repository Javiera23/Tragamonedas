import java.lang.Math;
import java.lang.String;

public class Maquina {
    int montoPorAsteriscos[] = {50,300,500,1000,2000}; //En el caso de que la maquina tuviera mas de 3 numeros, modificar el monto por la cantidad de asteriscos
    int cantidadNumeros = 5; //En el caso de que fueran mas numeros, bastaria modificar el 3 por el numero deseado;
    int[] numeros = new int[cantidadNumeros];
    //int[] numeros = {5,5,5};

    public Maquina() {
    }

    public void generarNumero(){
        for(int i=0; i<numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 10);
            System.out.println(numeros[i]);
            //String numero = Integer.toString(num1);
            //if (numero.equals("0")) {
                //numeros[i] = "*";
            //} else {
                //numeros[i] = numero;

        }
    }

    public int calcularPremio(int apuesta){
        int premio = 0;
        int asteriscos = 0;
        boolean iguales = true;
        int numeroIgual = 0;
        for(int i=1; i < numeros.length ; i++) {
            if (numeros[i] == numeros[i - 1]) {
                numeroIgual = numeros[i];
            } else {
                iguales = false;
                break;
            }
        }
        for(int i=0; i < numeros.length ; i++){
           if(numeros[i] == 0){
               asteriscos+=1;
           }
        }
        if(iguales){
            premio = apuesta * numeroIgual;
        }
        if(asteriscos >= 1){
            premio = montoPorAsteriscos[asteriscos - 1];
        }
        return premio;
    }

}
