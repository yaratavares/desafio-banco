import lombok.Getter;

@Getter
public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double value) {
        this.saldo -= value;
    }

    @Override
    public void depositar(double value) {
        this.saldo += value;
    }

    @Override
    public void transferir(double value, Conta contaDeDestino) {
        this.sacar(value);
        contaDeDestino.depositar(value);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
