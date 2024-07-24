public interface IConta {
    void sacar(double value);

    void depositar(double value);

    void transferir(double value, Conta contaDeDestino);

    void imprimirExtrato();
}
