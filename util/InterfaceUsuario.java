package util;

import java.util.Scanner;

public class InterfaceUsuario {

  Scanner scanner;

  public InterfaceUsuario() {
    this.scanner = new Scanner(System.in);
  }

  public double solicitarValorDoImovel() {
    double valorImovel;
    do {
      System.out.println("Informe o valor do Imóvel:");
      valorImovel = this.scanner.nextDouble();
      if (valorImovel <= 0.0) {
        System.out.println("O valor do imóvel deve ser um valor positivo!");
      }
      this.scanner.nextLine();
    } while (valorImovel <= 0);

    return valorImovel;
  }

  public int solicitarPrazoDoFinanciamento() {
    int prazoFinanciamento;
    do {
      System.out.println("Informe o prazo do financiamento (em anos):");
      prazoFinanciamento = this.scanner.nextInt();
      if (prazoFinanciamento <= 0) {
        System.out.println("O valor do prazo deve ser um valor positivo!");
      } else if (prazoFinanciamento >= 20) {
        System.out.println("Deve ter um prazo menor de financiamento!");
      }
      this.scanner.nextLine();
    } while (prazoFinanciamento <= 0 || prazoFinanciamento >= 20);

    return prazoFinanciamento;
  }

  public double solicitarTaxaDeJuros() {
    double taxaJurosAnual;
    do {
      System.out.println("Informe a taxa de Juros Anual:");
      taxaJurosAnual = this.scanner.nextDouble() / 100;
      if (taxaJurosAnual <= 0.0) {
        System.out.println("O valor da taxa de juros deve ser um valor positivo!");
      } else if (taxaJurosAnual >= 2.0) {
        System.out.println("Taxa de juros muito alta!");
      }
      this.scanner.nextLine();
    } while (taxaJurosAnual <= 0.0 || taxaJurosAnual >= 2.0);

    return taxaJurosAnual;
  }
}