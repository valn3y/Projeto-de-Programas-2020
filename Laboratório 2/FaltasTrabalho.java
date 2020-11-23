import java.util.ArrayList;
import java.util.Scanner;

public class FaltasTrabalho {
  public static void main(String[] args) {
    FaltasTrabalho ft = new FaltasTrabalho();
    Scanner scan = new Scanner(System.in);
    int input = 0;
    ArrayList<Integer> frequence = new ArrayList<Integer>();

    while (input > -1) {
      input = scan.nextInt();
      if (input > -1) {
        frequence.add(input);
      }
    }

    ft.statistic(frequence);

    scan.close();
  }

  public void statistic(ArrayList<Integer> frequence) {
    double monday = 0;
    double tuesday = 0;
    double wednesday = 0;
    double thursday = 0;
    double friday = 0;
    double saturday = 0;

    for (int i = 0; i < frequence.size(); i++) {
      if (frequence.get(i) == 2) {
        monday++;
      }
      if (frequence.get(i) == 3) {
        tuesday++;
      }
      if (frequence.get(i) == 4) {
        wednesday++;
      }
      if (frequence.get(i) == 5) {
        thursday++;
      }
      if (frequence.get(i) == 6) {
        friday++;
      }
      if (frequence.get(i) == 7) {
        saturday++;
      }
    }

    monday = (100 * monday) / frequence.size();
    tuesday = (100 * tuesday) / frequence.size();
    wednesday = (100 * wednesday) / frequence.size();
    thursday = (100 * thursday) / frequence.size();
    friday = (100 * friday) / frequence.size();
    saturday = (100 * saturday) / frequence.size();

    System.out.printf("%.1f %.1f %.1f %.1f %.1f %.1f\n", monday, tuesday, wednesday, thursday, friday, saturday);
  }
}
