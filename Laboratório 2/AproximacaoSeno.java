import java.util.Scanner;

public class AproximacaoSeno {
  public static void main(String[] args) {
    AproximacaoSeno as = new AproximacaoSeno();
    Scanner scan = new Scanner(System.in);
    double angle = scan.nextDouble();
    int quantitySerie = scan.nextInt();

    as.serieTaylor(quantitySerie, angle);

    scan.close();
  }

  public void serieTaylor(Integer quantitySerie, Double angle) {
    double angleInRad = Math.toRadians(angle);
    double result = 0;

    int x = 1;
    int y = 0;
    for (int i = 0; i < quantitySerie; i++) {
      if (i % 2 == 0) {
        result += (Math.pow(angleInRad, x + y) / fatorial(x + y));
      } else {
        result -= (Math.pow(angleInRad, x + y) / fatorial(x + y));
      }
      System.out.printf("%.10f\n", result);
      x++;
      y++;
    }
  }

  public Double fatorial(Integer x) {
    double result = 1;
    for (int i = x; i > 0; i--) {
      result = result * i;
    }
    return result;
  }
}
