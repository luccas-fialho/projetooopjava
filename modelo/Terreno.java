package modelo;

public class Terreno extends Financiamento {
  private static final long serialVersionUID = 1L;

  private String tipoZona;

  public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
    super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    this.tipoZona = tipoZona;
  }

  public String getTipoZona() {
    return this.tipoZona;
  }

  public void setTipoZona(String tipoZona) {
    this.tipoZona = tipoZona;
  }

  public double calcularPagamentoMensal() {
    double parcela = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));

    double acrescimo = 0.02;

    return (parcela + (parcela * acrescimo));
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Terreno - valor do imóvel: R$ "
        + String.format("%.0f", this.valorImovel)
        + ", valor do financiamento: R$ " + String.format("%.0f", this.calcularTotalDoPagamento())
        + ", taxa de juros: " + this.taxaJurosAnual * 100 + "%" + ", prazo de financiamento: " + this.prazoFinanciamento
        + ", tipo da zona: " + this.tipoZona
        + "\n");
    return builder.toString();
  }
}
