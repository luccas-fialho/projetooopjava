package util;

import java.util.InputMismatchException;
import java.util.Scanner;

import exception.ValoresForaDoRangeException;

public class InterfaceUsuario {

  Scanner scanner;
  double valorImovel;
  int prazoFinanciamento;
  double taxaJurosAnual;

  public InterfaceUsuario() {
    this.scanner = new Scanner(System.in);
    this.valorImovel = 0.0;
    this.prazoFinanciamento = 0;
    this.taxaJurosAnual = 0.0;
  }

  public double solicitarValorDoImovel() throws ValoresForaDoRangeException {
    try {
      do {
        System.out.println("Informe o valor do Imóvel:");
        valorImovel = this.scanner.nextDouble();
        if (valorImovel <= 0.0) {
          throw new ValoresForaDoRangeException("Deve ser um valor positivo!");
          // System.out.println("O valor do imóvel deve ser um valor positivo!");
        }
      } while (valorImovel <= 0);
    } catch (InputMismatchException e) {
      System.out.println("Valor deve ser um número");
    } finally {
      this.scanner.nextLine();
    }
    return valorImovel;
  }

  public int solicitarPrazoDoFinanciamento() throws ValoresForaDoRangeException {
    try {
      do {
        System.out.println("Informe o prazo do financiamento (em anos):");
        prazoFinanciamento = this.scanner.nextInt();
        if (prazoFinanciamento <= 0) {
          throw new ValoresForaDoRangeException("Deve ser um valor positivo!");
          //System.out.println("O valor do prazo deve ser um valor positivo!");
        } else if (prazoFinanciamento >= 20) {
          throw new ValoresForaDoRangeException("Prazo de financiamento muito alto!");
          //System.out.println("Deve ter um prazo menor de financiamento!");
        }
      } while (prazoFinanciamento <= 0 || prazoFinanciamento >= 20);
    } catch (InputMismatchException e) {
      System.out.println("Valor deve ser um número");
    } finally {
      this.scanner.nextLine();
    }

    return prazoFinanciamento;
  }

  public double solicitarTaxaDeJuros() throws ValoresForaDoRangeException {
    try {
      do {
        System.out.println("Informe a taxa de Juros Anual:");
        taxaJurosAnual = this.scanner.nextDouble() / 100;
        if (taxaJurosAnual <= 0.0) {
          throw new ValoresForaDoRangeException("Deve ser um valor positivo!");
          //System.out.println("O valor da taxa de juros deve ser um valor positivo!");
        } else if (taxaJurosAnual >= 2.0) {
          throw new ValoresForaDoRangeException("Taxa de juros muito alta!");
          //System.out.println("Taxa de juros muito alta!");
        }
      } while (taxaJurosAnual <= 0.0 || taxaJurosAnual >= 2.0);
    } catch (InputMismatchException e) {
      System.out.println("Valor deve ser um número");
    } finally {
      this.scanner.nextLine();
    }

    return taxaJurosAnual;
  }
}