package dio.banco;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    @Override
    public void extrato() {
        System.out.println("=== Extrato conta corrente ===");
        extratoComum();
    }
}
