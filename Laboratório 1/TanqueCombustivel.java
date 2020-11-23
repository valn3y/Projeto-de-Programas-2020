import java.util.Scanner;

public class TanqueCombustivel {
  public static void main(String[] args) {
    TanqueCombustivel tc = new TanqueCombustivel();
    Scanner scan = new Scanner(System.in);

    int raio = scan.nextInt();
    int x = scan.nextInt();
    int option = scan.nextInt();

    if (option == 1) {
      double answer = tc.volAir(raio, x);
      System.out.printf("%.4f", answer);
    }

    if (option == 2) {
      double answer = tc.volGas(raio, x);
      System.out.printf("%.4f", answer);
    }

    scan.close();
  }

  public Double volAir(Integer raio, Integer x) {
    double v = (Math.PI / 3) * Math.pow(x, 2) * (3 * raio - x);
    return v;
  }

  public Double volGas(Integer raio, Integer x) {
    double sfera = (4 * Math.PI * Math.pow(raio, 3)) / 3;

    double answer = sfera - volAir(raio, x);

    return answer;
  }
}
