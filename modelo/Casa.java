package modelo;

public class Casa extends Financiamento {
  public Casa (double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
  }

  public double calcularPagamentoMensal() {
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12)) + 80;
  }
}
