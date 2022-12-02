package br.edu.ifpb.persistencia.api;

import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaCorrente> listaContas;

    public Banco()
    {
        listaContas = new ArrayList<>();
    }

    public boolean cadastrarConta(int num, String tit, double saldoInicial)
    {
        if(buscarConta(num)) return false;

        return listaContas.add(new ContaCorrente(num, tit, saldoInicial));
    }

    public int quantContas()
    {
        return listaContas.size();
    }

    public boolean buscarConta(int num)
    {
        if(quantContas() > 0)
        {
            for(ContaCorrente conta: listaContas)
            {
               if(conta.getNumero() == num) return true;
            }
        }
        return false;
    }
}
