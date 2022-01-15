package dio.banco;

import lombok.Getter;

@Getter
public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected boolean encerrada;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void extratoComum() {
        System.out.printf("Cliente: %s%n", this.cliente.getNome());
        System.out.printf("Agência: 00%d%n", this.getAgencia());
        System.out.printf("Número: %d%n", this.getNumero());
        System.out.printf("Saldo: %.2f%n", this.getSaldo());
    }
}
