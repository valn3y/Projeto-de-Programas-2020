import java.util.ArrayList;
import java.util.Scanner;

public class HorasTrabalho {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int input = 0;
    ArrayList<Integer> days = new ArrayList<Integer>();

    while (input > -1) {
      input = scan.nextInt();
      if (input > -1 && days.size() % 7 >= 0) {
        days.add(input);
      }
    }

    System.out.println(days);

    scan.close();
  }
}
