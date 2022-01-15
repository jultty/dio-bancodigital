package dio.banco;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<String> operacoes = new ArrayList<>();

        operacoes.add("versão 0.1 de 14/01/2022");
        operacoes.add("criar conta");   operacoes.add("ver saldo");
        operacoes.add("depositar");     operacoes.add("sacar");
        operacoes.add("transferir");    operacoes.add("reabrir conta");

        System.out.println("Operações disponíveis:");
        for (int i = 1; i < 7; i++) {
            System.out.println("\n (" + i + ") " + operacoes.get(i));
        }

        // validação

        int entrada = 0;
        boolean entradaInvalida = true;
        while (entradaInvalida) {
            System.out.println("\n\n Digite o número da operação desejada: ");
            String entradaString = scan.nextLine();
            try {
                entrada = Integer.parseInt(entradaString);
                entradaInvalida = false;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
            // entrada válida

        String promptSelecao = "Você selecionou: " + operacoes.get(entrada);
        System.out.println(promptSelecao);

        switch(entrada) {
            case 1:
                // ...
                break;
            case 2:
                // ...
                break;
            case 3:
                // ...
                break;
            case 4:
                // ...
                break;
            case 5:
                // ...
                break;
            case 6:
                // ...
                break;
            default:
            System.out.println("Digite apenas o número da opção desejada");
                break;
        }

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
