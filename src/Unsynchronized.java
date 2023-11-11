import java.util.Random;

import static java.lang.Thread.sleep;

public class Unsynchronized {
    public static void main(String[] args) {

        System.out.println("GESTIONE CONTO CORRENTE CONDIVISO\n");

        int i = 0;
        Random random = new Random();
        ContoCorrente cc = new ContoCorrente(random.nextInt(1000) + 500);
        System.out.println("saldo generato = " + cc.getSaldo());

        do {

            System.out.println("\nUN UTENTE STA ACCEDENDO AL CONTO");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Thread deposita = new Thread(new Deposita(cc));
            Thread preleva = new Thread(new Preleva(cc));

            int scelta = random.nextInt(2);

            if (scelta == 0) {
                deposita.start();
            } else {
                preleva.start();
            }

            try {

                sleep(random.nextInt(1000));
                //deposita.join();
                //preleva.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        } while (i!=5);
    }
}