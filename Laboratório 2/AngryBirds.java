import java.util.Scanner;

public class AngryBirds {
  public static void main(String[] args) {
    AngryBirds ab = new AngryBirds();
    Scanner scan = new Scanner(System.in);

    double vo = scan.nextDouble();
    double angle = scan.nextDouble();
    double distanceBirdToPig = scan.nextDouble();

    ab.scope(vo, angle, distanceBirdToPig);

    scan.close();
  }

  public void scope(Double vo, Double angle, Double distanceBirdToPig) {
    double scope = (Math.pow(vo, 2) * Math.sin(2 * (Math.toRadians(angle)))) / 9.8;

    if (Math.abs(scope - distanceBirdToPig) <= 5) {
      System.out.println("1");
    } else {
      System.out.println("0");
    }
  }
}
