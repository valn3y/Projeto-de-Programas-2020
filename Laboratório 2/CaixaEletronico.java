import java.util.Scanner;

public class CaixaEletronico {
  public static void main(String[] args) {
    CaixaEletronico ce = new CaixaEletronico();

    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    if (!ce.isOdd(input) && input > 0) {
      ce.countNotes(input);
    } else {
      System.out.println("Valor Invalido");
    }

    scan.close();
  }

  public boolean isOdd(Integer value) {
    int rest = value % 2;

    if (rest == 0) {
      return false;
    }

    return true;
  }

  public void countNotes(Integer value) {
    int restFifty = value % 50;
    int restTen = restFifty % 10;
    int restTwo = restTen % 2;

    int fifty = (value - restFifty) / 50;
    int ten = (restFifty - restTen) / 10;
    int two = (restTen - restTwo) / 2;

    System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2\n", fifty, ten, two);
  }
}
