import java.lang.Math;

public class Maquina {
    private int montoPorAsteriscos[] = {50,300,500}; //En el caso de que la maquina tuviera mas de 3 numeros, modificar el monto por la cantidad de asteriscos
    private int cantidadNumeros = 3; //En el caso de que fueran mas numeros, bastaria modificar el 3 por el numero deseado;
    private int premio;
    private int[] numeros;


    public Maquina() {
        numeros = new int[cantidadNumeros];

    }

    public void generarNumero(){
        for(int i=0; i<numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 10);
        }
    }

    public int calcularPremio(int apuesta){
        premio = 0;
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

    public int getPremio(){
        return premio;
    }

    public int[] getNumeros(){
        return numeros;
    }

}
