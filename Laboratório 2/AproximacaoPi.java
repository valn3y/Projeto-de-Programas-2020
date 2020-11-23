import java.util.Scanner;

public class AproximacaoPi {
  public static void main(String[] args) {
    AproximacaoPi ap = new AproximacaoPi();
    Scanner scan = new Scanner(System.in);

    int input = scan.nextInt();
    ap.pi(input);

    scan.close();
  }

  public void pi(Integer input) {
    double result = 0;
    for (double i = 1; i <= input; i++) {
      if (i == 1) {
        result = 3;
      } else {
        if (i % 2 == 0) {
          result += 4 / ((2 * i) * (2 * i - 1) * (2 * i - 2));
        } else {
          result -= 4 / ((2 * i) * (2 * i - 1) * (2 * i - 2));
        }
      }
      System.out.printf("%.6f\n", result);
    }
  }
}
