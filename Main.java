/**
 * Main
 */
public class Main {

  public static void main(String[] args) {
    InterfaceUsuario usuario = new InterfaceUsuario();
    double valorImovel;
    double taxaJurosAnual;
    int prazoFinanciamento;

    valorImovel = usuario.solicitarValorDoImovel();
    prazoFinanciamento = usuario.solicitarPrazoDoFinanciamento();
    taxaJurosAnual = usuario.solicitarTaxaDeJuros();

    Financiamento financiamento1 = new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual);

    System.out.println("Pagamento mensal: " + financiamento1.calcularPagamentoMensal());
    System.out.println("Total do pagamento: " + financiamento1.calcularTotalDoPagemento());

  }
}