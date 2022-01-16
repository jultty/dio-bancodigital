package dio.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Main {

    Scanner scan = new Scanner(System.in);

    Cliente clienteTeste = new Cliente("Teste");
    Conta contaTeste = new ContaCorrente(clienteTeste);

    List<String> operacoes = new ArrayList<>();
    {
        operacoes.add("Sair");
        operacoes.add("criar conta");   operacoes.add("ver saldo");
        operacoes.add("depositar");     operacoes.add("sacar");
        operacoes.add("transferir");    operacoes.add("encerrar conta");
    }

    protected void menuPrincipalOpcoes() {
        System.out.println("Operações disponíveis:");
        for (int i = 0; i < 7; i++) {
            System.out.println("\n (" + i + ") " + operacoes.get(i));
        }
    }

         // validação

    protected void menuPrincipal() {

    int loopPrincipal = 1;
        while (loopPrincipal != 0) {

            int entrada = 0;
            boolean entradaInvalida = true;
            while (entradaInvalida) {
                menuPrincipalOpcoes();
                System.out.print("\n Digite o número da operação desejada: ");
                try {
                    String entradaString = scan.nextLine();
                    entrada = Integer.parseInt(entradaString);
                    if (entrada >= 0 && entrada < operacoes.size()) {
                        entradaInvalida = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("[Erro] Valor fornecido não é um número: " + e.getLocalizedMessage());
                } catch (NullPointerException e) {
                    System.out.println("[Erro] Nenhum valor fornecido: " + e.getLocalizedMessage());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("[Erro] Digite um valor do menu: " + e.getLocalizedMessage());
                }
            }

            // entrada válida

            String promptSelecao = "Você selecionou: " + operacoes.get(entrada);
            System.out.println(promptSelecao);

            switch (entrada) {
                case 1: // criar conta
                    System.out.println("Digite seu nome: ");
                    String nome = scan.nextLine();
                    Cliente novoCliente = new Cliente(nome);
                    Conta novaConta = new ContaCorrente(novoCliente);
                    novaConta.extrato();
                    break;
                case 2: // ver saldo
                    contaTeste.extrato();
                    break;
                case 3: // depositar
                    System.out.println("Digite o valor a depositar: ");
                    double valorDeposito = scan.nextDouble();
                    contaTeste.depositar(valorDeposito);
                    break;
                case 4: // sacar
                    System.out.println("Digite o valor a sacar: ");
                    double valorSaque = scan.nextDouble();
                    contaTeste.depositar(valorSaque);
                    break;
                case 5: // transferir
                    System.out.println("Digite o valor a transferir: ");
                    double valorTransferencia = scan.nextDouble();
                    contaTeste.transferir(valorTransferencia, contaTeste);
                    break;
                case 6: // encerrar conta
                    if (contaTeste.isEncerrada()) System.out.println("Esta conta já foi encerrada");
                    else
                        contaTeste.setEncerrada(true);
                    break;
                case 0: // sair
                    loopPrincipal = 0;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            } // fecha switch
        } // fecha loopPrincipal
    } // fecha menuPrincipal
}
