package br.edu.ifpb;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ContaCorrente {
    private int Numero;
    private String Titular;
    private BigDecimal Saldo = new BigDecimal(0);
    private ArrayList<String> ListaOperacoes = new ArrayList<>();

    public ContaCorrente()
    {
        setNumero(-1);
        setTitular("Inexistente");
        deposito(BigDecimal.TEN.setScale(2));

    }


    public ContaCorrente(int num, String tit, BigDecimal saldo)
    {
        if(num > 0 && tit != null && saldo.doubleValue() >= 0) {
            setNumero(num);
            setTitular(tit);
            deposito(saldo);

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

    public BigDecimal getSaldo()
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

    public boolean deposito(BigDecimal valor)
    {

        try{
            if(valor.doubleValue() < 0) throw new QuantiaNegativaException();
            else if(valor.doubleValue() == 0) throw new EntradaInvalidaException("Zero não é válido para a operação");

            this.Saldo = Saldo.add(valor);
            ListaOperacoes.add("Depósito: +R$ " + valor.setScale(2));
            ListaOperacoes.add("-Saldo: R$ " + this.Saldo.setScale(2));

            return true;
        } catch (QuantiaNegativaException qne){
            System.err.println(qne.getMessage());
        }catch (EntradaInvalidaException eie){
            System.err.println(eie.getMessage());
        }
        return false;
    }

    public BigDecimal calculaCMPF(BigDecimal valor)
    {
        return valor.multiply(BigDecimal.valueOf(0.01));
    }

    public boolean saque(BigDecimal valor)
    {
        try {
            if(valor.doubleValue() > this.Saldo.subtract(calculaCMPF(valor)).doubleValue()) throw new SaldoInsuficienteException();
            else if(valor.doubleValue() < 0) throw new QuantiaNegativaException();
            else if(valor.doubleValue() == 0) throw new EntradaInvalidaException("Zero não é válido para a operação");

            this.Saldo = Saldo.subtract(valor.add(calculaCMPF(valor)));
            ListaOperacoes.add("Saque: -R$ " + valor.setScale(2) + " (+taxa CPMF R$ " + calculaCMPF(valor).setScale(2) + ")");
            ListaOperacoes.add("-Saldo: R$ " + this.Saldo.setScale(2));
            System.out.println("Saque realizado com sucesso!");
            return true;

        } catch (SaldoInsuficienteException sie){
            System.err.println(sie.getMessage());
        } catch (QuantiaNegativaException qne){
            System.err.println(qne.getMessage());
        } catch (EntradaInvalidaException eie){
            System.err.println(eie.getMessage());
        }
        return false;
    }

    public ContaCorrente criarConta(int numero, String nome) {
        return new ContaCorrente(numero, nome, BigDecimal.TEN);
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

class SaldoInsuficienteException extends Exception{
    public SaldoInsuficienteException() {
        super("Saldo Insuficiente para saque.");
    }

    public SaldoInsuficienteException(String msg){
        super(msg);
    }
}

class QuantiaNegativaException extends Exception{
    public QuantiaNegativaException(){
        super("Valor Negativo Inválido.");
    }

    public QuantiaNegativaException(String msg){
        super(msg);
    }
}

class EntradaInvalidaException extends Exception{
    public EntradaInvalidaException(){
        super("Entradas Inválidas");
    }

    public EntradaInvalidaException(String msg){
        super(msg);
    }
}

