package dio.banco;

import java.util.*;

public class Menu extends Main {

    Scanner scan = new Scanner(System.in);

    Banco banco = new Banco();
    List<Conta> contas = banco.getContas();

    Cliente clienteTeste = new Cliente("Teste");
    Conta contaTeste = new ContaCorrente(clienteTeste);

    public Conta buscaConta(int conta) { // não consegue retornar a conta 1
        Iterator<Conta> it = contas.iterator();
        Conta atual = it.next();
        Conta proximo = it.next(); // NoSuchElementException

        while (it.hasNext()) {
            if (atual.getNumero() == conta) {
                return atual;
            }
            atual = proximo;
            proximo = it.next();
        }
        return atual;
    }

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
            System.out.println("Contas: " + banco.getContas());

            int entrada = 0;
            boolean entradaInvalida = true;
            while (entradaInvalida) {
                menuPrincipalOpcoes();
                System.out.print("\n Digite o número da operação desejada: ");
                try {
                    String stringEntrada = scan.nextLine();
                    entrada = Integer.parseInt(stringEntrada);
                    if (entrada >= 0 && entrada < operacoes.size()) {
                        entradaInvalida = false;
                    }
                } catch (InputMismatchException | NumberFormatException e) {
                    System.out.println("[Erro] Valor fornecido não é um número: " + e.getLocalizedMessage());
                } catch (NullPointerException e) {
                    System.out.println("[Erro] Nenhum valor fornecido: " + e.getLocalizedMessage());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("[Erro] Digite um valor do menu: " + e.getLocalizedMessage());
                }
            }


            String promptSelecao = "\n Você selecionou: " + operacoes.get(entrada);
            System.out.println(promptSelecao);

            // demais entradas abaixo não tratadas
            switch (entrada) {
                case 1: // criar conta
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
                    Cliente novoCliente = new Cliente(nome);
                    Conta novaConta = new ContaCorrente(novoCliente);
                    banco.addConta(novaConta);
                    break;
                case 2: // ver saldo
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = scan.nextInt();
                    Conta contaExtrato = buscaConta(numeroConta);
                    contaExtrato.extrato();
                    break;
                case 3: // depositar
                    System.out.println("Digite o valor a depositar: ");
                    double valorDeposito = scan.nextDouble();
                    System.out.println("Digite o número da conta de destino: ");
                    int numeroDeposito = scan.nextInt();
                    Conta contaDeposito = buscaConta(numeroDeposito);
                    if (contaDeposito.isEncerrada()) System.out.println("Esta conta está encerrada");
                        else { contaDeposito.depositar(valorDeposito); }
                    break;
                case 4: // sacar
                    System.out.println("Digite o valor a sacar: ");
                    double valorSaque = scan.nextDouble();
                    System.out.println("Digite o número da conta: ");
                    int numeroSaque = scan.nextInt();
                    Conta contaSaque = buscaConta(numeroSaque);
                    contaSaque.sacar(valorSaque);
                    break;
                case 5: // transferir
                    System.out.println("Digite o valor a transferir: ");
                    double valorTransferencia = scan.nextDouble();
                    System.out.println("Digite o número da conta de origem: ");
                    int numeroOrigem = scan.nextInt();
                    System.out.println("Digite o número da conta de destino: ");
                    int numeroDestino = scan.nextInt();
                    Conta contaDestino = buscaConta(numeroDestino);
                    Conta contaOrigem = buscaConta(numeroOrigem);
                    if (contaDestino.isEncerrada()) System.out.println("A conta de destino está encerrada");
                        else if (contaOrigem.isEncerrada()) System.out.println("A conta de origem está encerrada");
                        else contaOrigem.transferir(valorTransferencia, contaDestino);
                    break;
                case 6: // encerrar conta
                    System.out.println("Digite o número da conta: ");
                    int numeroContaEncerrar = scan.nextInt();
                    Conta contaEncerrar = buscaConta(numeroContaEncerrar);
                    if (contaEncerrar.isEncerrada()) System.out.println("Esta conta já foi encerrada");
                    else {
                        contaEncerrar.setEncerrada(true);
                        System.out.println("Conta encerrada.");
                    }
                    break;
                case 0: // sair
                    loopPrincipal = 0;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            } // fecha switch
            System.out.println("Pressione ENTER para continuar: ");
            String retornarMenu = scan.nextLine(); // pega caracteres newline dos nextInt()
        } // fecha loopPrincipal
        scan.close();
    } // fecha menuPrincipal
}