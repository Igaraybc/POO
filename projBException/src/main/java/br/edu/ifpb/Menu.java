package br.edu.ifpb;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Scanner;



public class Menu {

    public void exibirMenu()
    {
        System.out.printf("\n    Bem vindo!\nO que deseja fazer?\n");
        System.out.printf("\n1.Criar uma conta\n2.Depósito\n3.Saque\n4.Extrato\n5.Saldo atual\n6.Sair\n");

    }

    public void processardados() {
        ContaCorrente c = new ContaCorrente();
        Scanner inteiros = new Scanner(System.in);
        Scanner valores = new Scanner(System.in);
        Scanner palavras = new Scanner(System.in);

        boolean dadosOK = false;
        do {

            try {
                System.out.printf("\nDigite o número que corresponde a opção desejada: ");
                int op = inteiros.nextInt();
                if (!(op >= 1 && op <= 6)) {
                    throw new EntradaInvalidaException("Opção Inválida. Tente Novamente");
                }

                if (op == 6) {
                    dadosOK = true;
                    break;
                }
                else if (op == 1) {
                    System.out.printf("\nDigite o nome: ");
                    String nome = palavras.nextLine();
                    if (!StringUtils.isAlphaSpace(nome) || StringUtils.isBlank(nome))
                        throw new EntradaInvalidaException("Nome inválido.Tente novamente!");

                    System.out.printf("\nDigite o número da conta:");
                    int numero = inteiros.nextInt();
                    if (numero <= 0) throw new EntradaInvalidaException("Número Inválido. Tente novamente!");
                    c.criarConta(numero, nome);
                    System.out.println("Dados cadastrados com sucesso!");
                }

                else if (op == 2) {
                    System.out.printf("\nQual o valor deseja depositar: ");
                    BigDecimal valor = valores.nextBigDecimal();
                    if(c.deposito(valor)) System.out.println("Depósito realizado com sucesso!");

                } else if (op == 3) {
                    System.out.printf("\nQual o valor deseja sacar: ");
                    BigDecimal valor = valores.nextBigDecimal();
                    c.saque(valor);
                } else if (op == 4) {
                    System.out.println();
                    c.extrato();
                } else if (op == 5) {
                    System.out.println("\nSaldo: R$ " + c.getSaldo());
                }

            } catch (EntradaInvalidaException eie) {
                System.err.println(eie.getMessage());
            } catch(NumberFormatException nfe){
                System.err.println("Dados Inválidos. Tente novamente!");
            }
            exibirMenu();

        }while(!(dadosOK));
    }
    public static void main(String[] args) {
        Menu m = new Menu();
        m.exibirMenu();
        m.processardados();
    }
}