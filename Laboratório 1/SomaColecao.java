import java.util.ArrayList;
import java.util.Scanner;

public class SomaColecao {
  public static void main(String[] args) {
    SomaColecao sc = new SomaColecao();

    Scanner scan = new Scanner(System.in);
    int input = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();

    while (input > -1) {
      input = scan.nextInt();
      if (input > -1) {
        list.add(input);
      }
    }

    sc.sumArray(list);

    scan.close();
  }

  public void sumArray(ArrayList<Integer> list) {
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      sum = sum + list.get(i);
    }

    System.out.println(sum);
  }
}
