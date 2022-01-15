package dio.banco;

public class Main {
    public static void main(String[] args) {

        // versão 0.1 de 14/01/2022

        Menu principal = new Menu();
        principal.menuPrincipal();

        /*Cliente ccCliente = new Cliente();
        Cliente cpCliente = new Cliente();
        cpCliente.setNome("Joaquina");
        ccCliente.setNome("Mariana");

        Conta cc = new ContaCorrente(ccCliente);
        Conta cp = new ContaPoupanca(cpCliente);

        cc.extrato();
        cp.extrato();

        cc.depositar(200);

        cc.extrato();

        cc.transferir(100,cp);

        cp.extrato();
        cc.extrato();

        System.out.printf("Cliente: %s%n",ccCliente.getNome());
        System.out.printf("Cliente: %s%n",cc.getCliente().getNome());*/

    }
}
