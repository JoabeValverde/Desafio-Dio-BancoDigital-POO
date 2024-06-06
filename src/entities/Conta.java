package entities;

public abstract class Conta implements Iconta {

    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numConta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numConta = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Iconta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    //metodos acessor get

    public int getAgencia() {
        return agencia;
    }

    public int getNumConta() {
        return numConta;
    }

    public double getSaldo() {
        return saldo;
    }
    protected void ImprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numConta));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}