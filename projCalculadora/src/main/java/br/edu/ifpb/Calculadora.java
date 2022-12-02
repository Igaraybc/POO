package br.edu.ifpb;

public class Calculadora
{
    private String descricao;
    private double memoria;

    public Calculadora()
    {
        gravarMemoria(0);
        alterarDescricao("É uma calculadora.");
    }

    public Calculadora(double mem, String des)
    {
        gravarMemoria(mem);
        alterarDescricao(des);
    }

    public double somar(double umNumero, double outroNumero)
    {
        return umNumero+outroNumero;
    }

    public double subtrair(double umNumero, double outroNumero)
    {
        return umNumero-outroNumero;
    }

    public double multiplicar(double umNumero, double outroNumero)
    {
        return umNumero*outroNumero;
    }

    public double dividir(double umNumero, double outroNumero) throws ArithmeticException
    {
        if(outroNumero == 0){
            throw new ArithmeticException();
        }
        return umNumero/outroNumero;
    }

    public void gravarMemoria(double umNumero)
    {
        this.memoria = umNumero;
    }

    public double lerMemoria() {
        return memoria;
    }

    public void alterarDescricao(String umaDescricao)
    {
        if( umaDescricao != null && umaDescricao.length() > 0 )
        {
            this.descricao = umaDescricao;
        }
    }

    public String consultarDescricao()
    {
        return descricao;
    }

}
