package modelo;

public abstract class Financiamento {

  protected int prazoFinanciamento;
  protected double valorImovel;
  protected double taxaJurosAnual;

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

  public abstract double calcularPagamentoMensal();

  public double calcularTotalDoPagamento() {
    return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
  }

  public void mensagem() {
    System.out.println("Valor total do financiamento: " + calcularTotalDoPagamento());
    System.out.println("Valor do imóvel: " + this.valorImovel);
  }
}
