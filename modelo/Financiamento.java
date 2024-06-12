package modelo;

public class Financiamento {

  private int prazoFinanciamento;
  private double valorImovel;
  private double taxaJurosAnual;

  public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    this.prazoFinanciamento = prazoFinanciamento;
    this.valorImovel = valorImovel;
    this.taxaJurosAnual = taxaJurosAnual;
  }

  public int getPrazoFinanciamento() {
    return this.prazoFinanciamento;
  }

  public double getValorImovel() {
    return this.valorImovel;
  }

  public double getTaxaJurosAnual() {
    return this.taxaJurosAnual;
  }

  public double calcularPagamentoMensal() {
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
  }

  public double calcularTotalDoPagamento() {
    return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
  }

  public void mensagem() {
    System.out.println("Valor total do financiamento: " + calcularTotalDoPagamento());
    System.out.println("Valor do imóvel: " + this.valorImovel);
  }
}
