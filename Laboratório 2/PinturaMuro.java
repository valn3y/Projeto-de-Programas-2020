import java.util.Scanner;

public class PinturaMuro {
  public static void main(String[] args) {
    PinturaMuro pm = new PinturaMuro();
    Scanner scan = new Scanner(System.in);
    double pricePainter = scan.nextDouble();

    pm.price(pricePainter);

    scan.close();
  }

  public void price(Double priceService) {
    double total = (36 * priceService) + 100;

    System.out.printf("%.1f", total);
  }
}
