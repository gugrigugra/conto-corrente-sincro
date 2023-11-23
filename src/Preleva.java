import java.util.Random;

public class Preleva implements Runnable{


    private ContoCorrente cc;
    public Preleva(ContoCorrente cc){
        this.cc = cc;
    }

    public synchronized void run() {

        Random random = new Random();
        int importo = random.nextInt(500) + 1;

        if (cc.getSaldo() >= importo) {

            cc.doOp(-importo);
            System.out.println("Prelievo di " + importo + " euro. \nSaldo totale: " + cc.getSaldo() + " euro.");
        } else {

            System.out.println("Saldo insufficiente per il prelievo di " + importo + " euro.");
        }

    }
}
