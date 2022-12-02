package br.edu.ifpb.persistencia.api;

public class Livro {
    private String Titulo;
    private String Autor;
    private int ID = 0;

    public Livro(){
        setAutor("nenhum");
        setID(-1);
        setTitulo("nenhum");
    }

    public Livro(int id, String titulo, String autor)
    {
        setAutor(autor);
        setTitulo(titulo);
        setID(id);
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        this.Titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        this.Autor = autor;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Livro{" +"ID=" + getID() + ", Titulo =" +getTitulo()
                + ", Autor=" + getAutor() + "}";
    }
}
