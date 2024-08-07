package main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.Scanner;

import exception.ValoresForaDoRangeException;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

public class Main {
  public static void escreverEmTxt(ArrayList<Financiamento> financiamentos) {
    FileWriter out = null;
    try {
      out = new FileWriter("financiamentosTexto.txt");
      for (Financiamento financiamento : financiamentos) {
        int contLetra = 0;
        while (contLetra < financiamento.toString().length()) {
          out.write(financiamento.toString().charAt(contLetra));
          contLetra++;
        } 
      }
      out.close(); 
    } catch (FileNotFoundException e) {
      System.out.println("nenhum arquivo para escrever encontrado!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void lerTxt() {
    FileReader in = null;
    try {
      in = new FileReader("financiamentosTexto.txt");
      int c;
      System.out.println("Financiamentos recuperados do arquivo .txt: ");
      while ((c = in.read()) != -1) 
        System.out.print((char) c);
      in.close(); 
    } catch (FileNotFoundException e) {
      System.out.println("Nenhum arquivo de .txt encontrado!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void escreverFinanciamentos(String filename, ArrayList<Financiamento> arrayList) {
    ObjectOutputStream outputStream = null;
    try {
      outputStream = new ObjectOutputStream(new FileOutputStream(filename));

      for (Financiamento financiamento : arrayList) {
        outputStream.writeObject(financiamento);
      }

      outputStream.flush();
      outputStream.close();

    } catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static ArrayList<Financiamento> leFinanciamentos(String filename) {
    ObjectInputStream inputStream = null;
    ArrayList<Financiamento> financiamentos = new ArrayList<>();
    try {
      inputStream = new ObjectInputStream(new FileInputStream(filename));
      Object obj = null;
      while ((obj = inputStream.readObject()) != null) {
        if (obj instanceof Financiamento) 
          financiamentos.add(((Financiamento) obj));
      }
      inputStream.close();
    } catch (EOFException ex) { 
      System.out.println("Fim de arquivo alcançado.");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    } catch (FileNotFoundException ex) {
      System.out.println("Nenhum arquivo serializado encontrado!");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return financiamentos;
  }

  public static void main(String[] args) {
    InterfaceUsuario usuario = new InterfaceUsuario();
    double valorImovel = 0.0;
    double taxaJurosAnual = 0.0;
    int prazoFinanciamento = 0;
    double somaDosFinanciamentos = 0.0;
    double somaDosImoveis = 0.0;

    Scanner scanner = new Scanner(System.in);
    ArrayList<Financiamento> financiamentos = leFinanciamentos("financiamentosSerializados.ser");

    if (!financiamentos.isEmpty()) {
      System.out.println("Financiamentos recuperados do arquivo serializado: ");
      for (Financiamento financiamento : financiamentos) {
        System.out.println(financiamento.toString());
      }
    }

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

    for (Financiamento financiamento : financiamentos) {
      somaDosImoveis += financiamento.getValorImovel();
      somaDosFinanciamentos += financiamento.calcularTotalDoPagamento();
    }
    
    escreverEmTxt(financiamentos);
    escreverFinanciamentos("financiamentosSerializados.ser", financiamentos);

    lerTxt();

    System.out.println("Total de todos os imóveis: R$ " + String.format("%.0f", somaDosImoveis)
        + ", total de todos os financiamentos: R$ " + String.format("%.0f", somaDosFinanciamentos));

    scanner.close();
  }
}