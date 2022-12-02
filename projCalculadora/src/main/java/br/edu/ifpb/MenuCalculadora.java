package br.edu.ifpb;

import javax.swing.*;
import java.util.Scanner;

public class MenuCalculadora
{
    public void exibirMenu()
    {
        System.out.println();
        System.out.println("============================\n       Calculadora\n============================");
        System.out.println("1. Somar\n2. Subtrair\n3. Multiplicar\n4. Dividir\n5. Sobre a Calculadora\n6.Sair");
        System.out.print("Digite uma opção: ");
    }

    public int capturarNumeros()
    {
        Scanner opcao = new Scanner( System.in );
        int op = opcao.nextInt();
        while(!(op >= 1 && op <= 6))
        {
            System.out.print("Opção Inválida. Digite novamente: ");
            opcao = new Scanner( System.in );
            op = opcao.nextInt();
        }

        return op;
    }
}
