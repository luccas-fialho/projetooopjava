/**
 * InterfaceUsuario
 */

import java.util.Scanner;

public class InterfaceUsuario {

  double valorImovel = 0.0;
  int prazoFinanciamento = 0;
  double taxaJurosAnual = 0.0;
  Scanner scanner = new Scanner(System.in);

  public double solicitarValorDoImovel(){
    System.out.println("Informe o valor do Imóvel:");
    this.valorImovel = this.scanner.nextDouble();
    this.scanner.nextLine();
    return valorImovel;
  }

  public int solicitarPrazoDoFinanciamento(){
   
    System.out.println("Informe o prazo do financiamento:");
    this.prazoFinanciamento = this.scanner.nextInt();
    this.scanner.nextLine();
    return prazoFinanciamento;
  }

  public double solicitarTaxaDeJuros(){
    System.out.println("Informe a taxa de Juros Anual:");
    double taxaJurosAnual = this.scanner.nextDouble();
    this.scanner.nextLine();

    return taxaJurosAnual;
  }
}