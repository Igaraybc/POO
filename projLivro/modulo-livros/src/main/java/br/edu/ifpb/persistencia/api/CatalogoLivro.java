package br.edu.ifpb.persistencia.api;

import java.util.ArrayList;

public class CatalogoLivro {
    private ArrayList<Livro> ListaLivros;
    private int QuantLivros;

    public CatalogoLivro() {
        this.ListaLivros = new ArrayList<>();
        this.QuantLivros = 0;
    }

    public boolean adicionarLivro(int id, String titulo, String autor)
    {
        if(id >= 0 && titulo != null && autor != null) {
            Livro l = new Livro(id, titulo, autor);
            for( int i = 0; i < ListaLivros.size(); i++ ) {
                if (ListaLivros.get(i).getID() == id || ListaLivros.get(i).getTitulo() == titulo) {
                    return false;
                }
            }
            ListaLivros.add(l);
            return true;
        }
        return false;
    }

    public boolean removerLivro(int id)
    {
        if(!(ListaLivros.isEmpty())){
            for(Livro l: ListaLivros){
                if(l.getID() == id){
                    ListaLivros.remove(l);
                    return true;
                }
            }
        }
        return false;
    }

    public Livro BuscarLivro(int id){
        for(Livro l : ListaLivros){
            if(l.getID() == id){
                return l;
            }
        }
        return new Livro(id, "inexistente", "inexistente");
    }

    @Override
    public String toString() {
        return ListaLivros.toString();
    }
}
