import java.util.ArrayList;
import java.util.Scanner;

public class ParImpar {
  public static void main(String[] args) {
    ParImpar pi = new ParImpar();

    Scanner scan = new Scanner(System.in);
    int input = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();

    while (input > -1) {
      input = scan.nextInt();
      if (input > -1) {
        list.add(input);
      }
    }

    pi.oddOrPair(list);

    scan.close();
  }

  public void oddOrPair(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) % 2 == 0) {
        System.out.println("PAR");
      } else {
        System.out.println("IMPAR");
      }
    }
  }
}
