package br.edu.ifpb.gui.api;

import br.edu.ifpb.persistencia.api.Banco;
import br.edu.ifpb.persistencia.api.ContaCorrente;

import java.util.Scanner;

public class Menu {

    public boolean validarConta()
    {
        Banco b = new Banco();
        Scanner numeros = new Scanner(System.in);
        Scanner palavras = new Scanner(System.in);
        System.out.println("---Banco---");
        System.out.println("\nDigite seus dados");
        while(true) {
            System.out.printf("\nNumero da conta: ");
            int numero = numeros.nextInt();
            System.out.printf("\nNome do titular: ");
            String titular = palavras.nextLine();
            boolean verificacao = b.cadastrarConta(numero, titular, 0);
            if(verificacao)
            {
                return true;
            }
            System.out.printf("\n\nDados Inválidos. Digite novamente\n");
        }

    }

    public void exibirMenu()
    {
            System.out.printf("\n    Bem vindo!\nO que deseja fazer?\n");
            System.out.printf("\n1.Depósito\n2.Saque\n3.Saldo\n4.Extrato\n5.Sair\n");

    }

    public void processardados(){
        ContaCorrente c = new ContaCorrente();
        Scanner opcoes = new Scanner(System.in);
        Scanner valores = new Scanner(System.in);
        while(true) {
            System.out.printf("Digite o número que corresponde a opção desejada: ");
            int op = opcoes.nextInt();
            while (!(op >= 1 && op <= 5)) {
                System.out.printf("\nOpção Inválida. Digite Novamente: ");
                op = opcoes.nextInt();
            }
            if (op == 5) break;

            else if(op == 1)
            {
                System.out.printf("\nQual o valor deseja depositar: ");
                double valor = valores.nextDouble();
                boolean validacao = c.deposito(valor);
                if(validacao)
                {
                    System.out.println("\n*Depósito realizado com sucesso!*");
                }
                else{
                    System.out.println("\n*Ocorreu um erro. Verifique as informações.*");
                }
            }

            else if(op == 2)
            {
                System.out.printf("\nQual o valor deseja sacar: ");
                double valor = valores.nextDouble();
                boolean validacao = c.saque(valor);
                if(validacao)
                {
                    System.out.println("\n*Saque realizado com sucesso!*");
                }
                else{
                    System.out.println("\n*Ocorreu um erro. Verifique as informações.*");
                }
            }
            else if(op == 3)
            {
                System.out.println("\nSaldo: R$ "+c.getSaldo());
            }
            else if(op == 4)
            {
                System.out.println();
                c.extrato();
            }
            exibirMenu();
        }

    }
}
