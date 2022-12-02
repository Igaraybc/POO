package br.edu.ifpb;

import java.util.Scanner;

public class TestarMenu
{
    public static void main( String[] args ){
        MenuCalculadora menu = new MenuCalculadora();
        Calculadora cal = new Calculadora();
        menu.exibirMenu();
        int opcao = menu.capturarNumeros();

        while(opcao != 6) {
            if (opcao >= 1 && opcao <= 4) {
                Scanner Num = new Scanner(System.in);
                System.out.print("Digite o primeiro número da operação: ");
                double prim = Num.nextDouble();
                cal.gravarMemoria(prim);

                System.out.print("Digite o segundo número da operação: ");
                double seg = Num.nextDouble();
                cal.gravarMemoria(seg);

                double resultado = 0;
                try {
                    if (opcao == 1) {
                        resultado = cal.somar(prim, seg);

                    } else if (opcao == 2) {
                        resultado = cal.subtrair(prim, seg);
                    } else if (opcao == 3) {
                        resultado = cal.multiplicar(prim, seg);
                    } else {
                        resultado = cal.dividir(prim, seg);
                    }
                    System.out.println("Resultado: " + resultado);
                }
                catch (ArithmeticException e) {
                    System.err.println("Divisão por zero não é válido.");
                }
            }
            else{
                String desc = cal.consultarDescricao();
                System.out.println("Descrição: "+desc+"\n");
                System.out.print("Alterar descrição (sim/nao):");
                Scanner sel = new Scanner( System.in );
                String selecao = sel.next();
                if(selecao.equals("sim")) {
                    System.out.print("Digite uma nova descrição: ");
                    Scanner novadesc = new Scanner( System.in );
                    String nova = novadesc.nextLine();
                    cal.alterarDescricao(nova);
                    System.out.println("Descrição atualizada.");
                }
                else if(!selecao.equals("nao"))
                {
                    System.out.println("Opção Inválida.");
                }
            }
            menu.exibirMenu();
            opcao = menu.capturarNumeros();
        }
    }

}
