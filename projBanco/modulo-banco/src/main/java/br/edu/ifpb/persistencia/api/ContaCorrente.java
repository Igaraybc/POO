package br.edu.ifpb.persistencia.api;

import java.util.ArrayList;

public class ContaCorrente {
    private int Numero;
    private String Titular;
    private double Saldo;
    private ArrayList<String> ListaOperacoes;

    public ContaCorrente()
    {
        setNumero(-1);
        setTitular("Inexistente");
        deposito(0);
        ListaOperacoes = new ArrayList<>();
    }


    public ContaCorrente(int num, String tit, double saldo)
    {
        if(num > 0 && tit != null && saldo >= 0) {
            setNumero(num);
            setTitular(tit);
            deposito(saldo);
            ListaOperacoes = new ArrayList<>();
        }
    }

    public void setTitular(String tit)
    {
        this.Titular = tit;
    }

    public String getTitular()
    {
        return Titular;
    }

    public double getSaldo()
    {
        return Saldo;
    }

    public void setNumero(int num)
    {
        this.Numero = num;
    }

    public int getNumero()
    {
        return Numero;
    }

    public boolean deposito(double valor)
    {
        if(valor > 0)
        {
            this.Saldo += valor;
            ListaOperacoes.add("Depósito: +R$ "+valor);
            ListaOperacoes.add("-Saldo: R$ "+this.Saldo);
            return true;
        }
        return false;
    }

    public double calculaCMPF(double valor)
    {
        return valor*0.01;
    }

    public boolean saque(double valor)
    {
        if(valor > 0 && valor <= this.Saldo-calculaCMPF(valor))
        {
            this.Saldo -= valor+calculaCMPF(valor);
            ListaOperacoes.add("Saque: -R$ "+valor+" (+taxa CPMF R$ "+calculaCMPF(valor)+")");
            ListaOperacoes.add("-Saldo: R$ "+this.Saldo);
            return true;
        }
        return false;
    }

    public void extrato(){
        if(ListaOperacoes.isEmpty()) System.out.println("Nenhuma operação realizada.");
        for(int i = 0; i < ListaOperacoes.size(); i++) {
            System.out.printf(ListaOperacoes.get(i) + "\n");
        }
    }

    public String toString(){
        return "Conta: "+getNumero()+
                "\nTitular: "+getTitular()+
                "\nSaldo: R$"+getSaldo();
    }

}
