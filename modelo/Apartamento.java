package modelo;

public class Apartamento extends Financiamento {
  private static final long serialVersionUID = 1L;

  private int vagasGaragem;
  private int numeroAndar;

  public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem,
      int numeroAndar) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.vagasGaragem = vagasGaragem;
    this.numeroAndar = numeroAndar;
  }

  public int getVagasGaragem() {
    return this.vagasGaragem;
  }

  public int getNumeroAndar() {
    return this.numeroAndar;
  }

  public void setNumeroAndar(int numeroAndar) {
    this.numeroAndar = numeroAndar;
  }

  public void setVagasGaragem(int vagasGaragem) {
    this.vagasGaragem = vagasGaragem;
  }

  public double calcularPagamentoMensal() {
    double taxaMensal = this.taxaJurosAnual / 12;
    int mesesFinanciamento = this.prazoFinanciamento * 12;

    // return (this.valorImovel*Math.pow(1+taxaMensal,
    // mesesFinanciamento))/(Math.pow(1+taxaMensal, mesesFinanciamento-1));

    /*
     * P = (PV * i) / (1 – (1 + i)^-n) fonte:
     * https://investnews.com.br/ferramentas/calculadoras/calculadora-price/
     */
    return (this.valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -mesesFinanciamento));
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Apartamento - valor do imóvel: R$ "
        + String.format("%.0f", this.valorImovel)
        + ", valor do financiamento: R$ " + String.format("%.0f", this.calcularTotalDoPagamento())
        + ", taxa de juros: " + this.taxaJurosAnual * 100 + "%" + ", prazo de financiamento: " + this.prazoFinanciamento
        + ", vagas na garagem: " + this.vagasGaragem + ", número do andar: " + this.numeroAndar
        + "\n");
    return builder.toString();
  }
}
