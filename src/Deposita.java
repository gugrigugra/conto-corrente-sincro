import java.util.Random;

public class Deposita implements Runnable{

    private ContoCorrente cc;

    public Deposita(ContoCorrente cc){
        this.cc = cc;
    }

    public synchronized void run() {

        Random random = new Random();
        int importo = random.nextInt(500) + 1;

        cc.doOp(importo);
        System.out.println("Deposito di " + importo + " euro. \nSaldo totale: " + cc.getSaldo() + " euro.");

    }
}
