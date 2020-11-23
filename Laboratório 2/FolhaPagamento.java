import java.util.Scanner;

public class FolhaPagamento {
  public static void main(String[] args) {
    FolhaPagamento fp = new FolhaPagamento();

    Scanner scan = new Scanner(System.in);
    double priceHour = scan.nextDouble();
    int hourWorks = scan.nextInt();

    System.out.printf("Salario bruto: R$%.2f\n", fp.totalSalary(priceHour, hourWorks));
    System.out.printf("IR: R$%.2f\n", fp.ir(priceHour, hourWorks));
    System.out.printf("INSS: R$%.2f\n", fp.inss(priceHour, hourWorks));

    double totalDescounts = fp.ir(priceHour, hourWorks) + fp.inss(priceHour, hourWorks);
    System.out.printf("Total de descontos: R$%.2f\n", totalDescounts);

    double liquidSalary = fp.totalSalary(priceHour, hourWorks) - totalDescounts;
    System.out.printf("Salario liquido: R$%.2f\n", liquidSalary);

    scan.close();
  }

  public Double totalSalary(Double priceHour, Integer hourWorks) {
    return priceHour * hourWorks;
  }

  public Double ir(Double priceHour, Integer hourWorks) {
    return priceHour * hourWorks * 0.11;
  }

  public Double inss(Double priceHour, Integer hourWorks) {
    return priceHour * hourWorks * 0.08;
  }
}
