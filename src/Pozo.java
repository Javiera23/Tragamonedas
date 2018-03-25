public class Pozo {

    private int saldo;


    public Pozo(){
        saldo = 1000;
    }

    public int getSaldo(){
        return saldo;

    }

    public void setSaldo(int apuesta){
        saldo = saldo - apuesta;
    }


}
