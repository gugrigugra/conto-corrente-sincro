public class ContoCorrente {

    private int saldo;

    public ContoCorrente(int saldoIniziale) {
        this.saldo = saldoIniziale;
    }

    public void doOp(int v) {

        try {
            Thread.sleep(500);
            saldo += v;
            setSaldo(saldo);
        }
        catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
