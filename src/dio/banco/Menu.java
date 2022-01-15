package dio.banco;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu extends Main {

    Scanner scan = new Scanner(System.in);

    List<String> operacoes = new ArrayList<>();
    {
        operacoes.add("");
        operacoes.add("criar conta");   operacoes.add("ver saldo");
        operacoes.add("depositar");     operacoes.add("sacar");
        operacoes.add("transferir");    operacoes.add("encerrar conta");
    }

    protected void menuPrincipalOpcoes() {
        System.out.println("Operações disponíveis:");
        for (int i = 1; i < 7; i++) {
            System.out.println("\n (" + i + ") " + operacoes.get(i));
        }
    }

         // validação

    protected void menuPrincipal() {

    int entrada = 0;
    boolean entradaInvalida = true;
        while (entradaInvalida) {
        menuPrincipalOpcoes();
        System.out.print("\n Digite o número da operação desejada: ");
        try {
            String entradaString = scan.nextLine();
            entrada = Integer.parseInt(entradaString);
            if (entrada >= 1 && entrada < operacoes.size()) { entradaInvalida = false; }
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
            System.out.println("Opção inválida");
            break;
    }

    }
}
