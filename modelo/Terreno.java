package modelo;

public class Terreno extends Financiamento {
  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
  }

  public double calcularPagamentoMensal() {
    double parcela = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));

    double acrescimo = 0.02;

    return (parcela + (parcela * acrescimo));
  }
}
