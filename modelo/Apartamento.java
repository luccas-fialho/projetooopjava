package modelo;

public class Apartamento extends Financiamento {
  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
  }

  public double calcularPagamentoMensal() {
    double taxaMensal = this.taxaJurosAnual / 12;
    int mesesFinanciamento = this.prazoFinanciamento * 12;

    // return (this.valorImovel*Math.pow(1+taxaMensal, mesesFinanciamento))/(Math.pow(1+taxaMensal, mesesFinanciamento-1));
    
    /*  P = (PV * i) / (1 – (1 + i)^-n) fonte: https://investnews.com.br/ferramentas/calculadoras/calculadora-price/ */
    return (this.valorImovel*taxaMensal)/(1-Math.pow(1+taxaMensal,-mesesFinanciamento));
  }
}
