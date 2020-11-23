import java.util.Scanner;

public class Media {
  public static void main(String[] args) {
    Media m = new Media();
    Scanner scan = new Scanner(System.in);

    double x = scan.nextDouble();
    double y = scan.nextDouble();
    double z = scan.nextDouble();

    m.media(x, y, z);

    scan.close();
  }

  public void media(Double x, Double y, Double z) {
    double m = (x + y + z) / 3;

    System.out.printf("%.2f\n", m);
  }
}
