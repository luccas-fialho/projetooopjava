package modelo;

public class Casa extends Financiamento {
  private double areaConstruida;
  private double tamanhoTerreno;

  public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
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
}
