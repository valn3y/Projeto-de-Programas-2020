import java.util.Scanner;

public class ArteAscii {
  public static void main(String[] args) {
    ArteAscii aa = new ArteAscii();
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    aa.decrescente(input);
    aa.crescente(input);

    scan.close();
  }

  public void crescente(Integer input) {
    for (int i = 0; i < input; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }

  public void decrescente(Integer input) {
    for (int i = input; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        System.out.print("*");
      }
      System.out.println("");
    }
  }
}
