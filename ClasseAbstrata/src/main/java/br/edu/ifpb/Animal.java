package br.edu.ifpb;

public abstract class Animal {
    public String nome;

    public String getNome() {
        return nome;
    }

    public abstract String emitirSom();
}
