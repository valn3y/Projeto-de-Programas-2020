import java.util.Scanner;

public class Fahrenheit {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double celsius = scan.nextDouble();

    double fah = ((9 * celsius) + 160) / 5;

    System.out.printf("%.1f\n", fah);

    scan.close();
  }
}
