import java.util.Random;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {

        System.out.println("GESTIONE CONTO CORRENTE CONDIVISO\n");

        Random random = new Random();

        int i;
        ContoCorrente cc = new ContoCorrente(random.nextInt(1000) + 500);
        System.out.println("saldo generato = " + cc.getSaldo());

        do {

            i = random.nextInt(7) + 1;
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
                deposita.join();
                preleva.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("utente successivo in coda");

        } while (i!=5);
    }
}