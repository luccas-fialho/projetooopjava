/**
 * Financiamento
 */
public class Financiamento {

  private int prazoFinanciamento;
  private double valorImovel;
  private double taxaJurosAnual;

  public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
    this.prazoFinanciamento = prazoFinanciamento;
    this.valorImovel = valorImovel;
    this.taxaJurosAnual = taxaJurosAnual;
  }

  public double calcularPagamentoMensal(){
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
  }

  public double calcularTotalDoPagemento(){
    return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
  }
}
