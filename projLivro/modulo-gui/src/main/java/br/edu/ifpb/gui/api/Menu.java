package br.edu.ifpb.gui.api;

import br.edu.ifpb.persistencia.api.CatalogoLivro;

import java.util.Scanner;

public class Menu {
    public void exibirMenu(){
        System.out.println("\n\n===x========x=======x=====");
        System.out.println("    Catálogo de Livros\n===x========x=======x=====\nO que deseja fazer?");
        System.out.println("\n1.Adicionar um Livro\n2.Remover um livro\n3.Buscar Livro\n4.Sair");
    }
    public void capturaropcao(){
        CatalogoLivro cat = new CatalogoLivro();
        boolean verfificacao;
        Scanner IDS = new Scanner(System.in);
        Scanner opcoes = new Scanner(System.in);
        while(true){
            System.out.printf("Digite o número correspondente a opção desejada: ");
            int op = opcoes.nextInt();
            while(op < 1 || op >  4){
                System.out.printf("Opção Inválida. Digite novamente: ");
                op = opcoes.nextInt();
            }

            if(op == 4) break;

            else if(op == 1){
                System.out.println("\nDigite as informações do livro a ser adicionar");
                System.out.printf("Id: ");
                int id = IDS.nextInt();
                System.out.printf("Titulo: ");
                Scanner titulos = new Scanner(System.in);
                String titulo = titulos.nextLine();
                System.out.printf("Autor: ");
                String autor = titulos.nextLine();
                verfificacao = cat.adicionarLivro(id, titulo, autor);
                if(verfificacao){
                    System.out.println("\nLivro adicionado com sucesso!");
                }
                else{
                    System.out.println("\nNão foi possível adicionar o livro, verfique as informações");
                }
            }
            else if(op == 2 || op == 3) {
                System.out.printf("\nInforme o id do livro: ");
                int id = IDS.nextInt();
                if (op == 2) {
                    verfificacao = cat.removerLivro(id);
                    if (verfificacao) {
                        System.out.println("\nLivro removido com sucessso!");
                    } else {
                        System.out.println("\nNão foi possível remover");
                    }
                }
                else if (op == 3) {
                    System.out.println(cat.BuscarLivro(id));
                }

            }
            exibirMenu();

        }
    }
}
