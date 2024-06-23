package modelo;

public class Terreno extends Financiamento {

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
}
