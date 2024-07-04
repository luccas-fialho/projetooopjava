package modelo;

public class Casa extends Financiamento {
  private static final long serialVersionUID = 1L;

  private double areaConstruida;
  private double tamanhoTerreno;

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida,
      double tamanhoTerreno) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.areaConstruida = areaConstruida;
    this.tamanhoTerreno = tamanhoTerreno;
  }

  public double getAreaConstruida() {
    return this.areaConstruida;
  }

  public double getTamanhoTerreno() {
    return this.tamanhoTerreno;
  }

  public void setAreaConstruida(double areaConstruida) {
    this.areaConstruida = areaConstruida;
  }

  public void setTamanhoTerreno(double tamanhoTerreno) {
    this.tamanhoTerreno = tamanhoTerreno;
  }

  public double calcularPagamentoMensal() {
    return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12)) + 80;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Casa - valor do imóvel: R$ "
        + String.format("%.0f", this.valorImovel)
        + ", valor do financiamento: R$ " + String.format("%.0f", this.calcularTotalDoPagamento())
        + ", taxa de juros: " + this.taxaJurosAnual * 100 + "%" + ", prazo de financiamento: " + this.prazoFinanciamento
        + ", tamanho do terreno: " + this.tamanhoTerreno + ", area construída: " + this.areaConstruida
        + "\n");
    return builder.toString();
  }
}
