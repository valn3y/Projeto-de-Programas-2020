import java.util.ArrayList;
import java.util.Scanner;

public class AreaPoligono {
  public static void main(String[] args) {
    AreaPoligono ap = new AreaPoligono();
    Scanner scan = new Scanner(System.in);
    ArrayList<Double> x = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();

    double x_input = 0;
    while (x_input > -1) {
      x_input = scan.nextDouble();
      if (x_input > -1) {
        x.add(x_input);
      }
    }

    double y_input = 0;
    while (y_input > -1) {
      y_input = scan.nextDouble();
      if (y_input > -1) {
        y.add(y_input);
      }
    }

    if (x.size() >= 4 && y.size() >= 4) {
      double first_x = x.get(0);
      double last_x = x.get(x.size() - 1);
      double first_y = y.get(0);
      double last_y = y.get(x.size() - 1);

      if (first_x == last_x && first_y == last_y) {
        ap.areaPol(x, y);
      }
    }

    scan.close();
  }

  public void areaPol(ArrayList<Double> x, ArrayList<Double> y) {
    double sum = 0;
    for (int i = 0; i <= x.size() - 2; i++) {
      sum += (x.get(i + 1) + x.get(i)) * (y.get(i + 1) - y.get(i));
    }

    double area = Math.abs(sum) / 2;
    System.out.printf("%.4f\n", area);
  }
}
