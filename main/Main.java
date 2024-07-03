package main;

import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.Scanner;

import exception.ValoresForaDoRangeException;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

public class Main {

  public static void main(String[] args) {
    InterfaceUsuario usuario = new InterfaceUsuario();
    double valorImovel = 0.0;
    double taxaJurosAnual = 0.0;
    int prazoFinanciamento = 0;
    double somaDosFinanciamentos = 0.0;
    double somaDosImoveis = 0.0;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Financiamento> financiamentos = new ArrayList<>();

    System.out.println("Digite os valores do primeiro financiamento");
    try {
      valorImovel = usuario.solicitarValorDoImovel();
      prazoFinanciamento = usuario.solicitarPrazoDoFinanciamento();
      taxaJurosAnual = usuario.solicitarTaxaDeJuros();
    } catch (ValoresForaDoRangeException exception) {
      System.out.println(exception);
    }

    Financiamento novoFinanciamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 200.0, 300.0);
    Financiamento novoFinanciamento2 = new Casa(300000.0, 5, 0.4, 100.0, 200.0);
    Financiamento novoFinanciamento3 = new Apartamento(150000.0, 7, 0.5, 2, 3);
    Financiamento novoFinanciamento4 = new Terreno(500000.0, 10, 0.1, "residencial");
    
    financiamentos.add(novoFinanciamento);
    financiamentos.add(novoFinanciamento2);
    financiamentos.add(novoFinanciamento3);
    financiamentos.add(novoFinanciamento4);

    for (int i = 0; i < financiamentos.size(); i++) {
      somaDosImoveis += financiamentos.get(i).getValorImovel();
      somaDosFinanciamentos += financiamentos.get(i).calcularTotalDoPagamento();
      System.out.println("Financiamento " + (i + 1) + " - valor do imóvel: R$ "
          + String.format("%.0f", financiamentos.get(i).getValorImovel())
          + ", valor do financiamento: R$ " + String.format("%.0f", financiamentos.get(i).calcularTotalDoPagamento()));
    }
    
    System.out.println("Total de todos os imóveis: R$ " + String.format("%.0f", somaDosImoveis)
        + ", total de todos os financiamentos: R$ " + String.format("%.0f", somaDosFinanciamentos));

    scanner.close();
  }
}