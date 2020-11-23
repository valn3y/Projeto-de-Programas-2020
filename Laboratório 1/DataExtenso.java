import java.util.Scanner;

public class DataExtenso {
  public static void main(String[] args) {
    DataExtenso de = new DataExtenso();

    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    de.parseInput(input);

    scan.close();
  }

  public void parseInput(String input) {
    int day = Integer.parseInt(input.substring(0, 2));
    int month = Integer.parseInt(input.substring(2, 4));
    int year = Integer.parseInt(input.substring(4, 8));

    String _nameMonth = nameMonth(month);

    System.out.printf("%d de %s de %d\n", day, _nameMonth, year);
  }

  public String nameMonth(Integer month) {
    if (month == 1) {
      return "janeiro";
    }
    if (month == 2) {
      return "fevereiro";
    }
    if (month == 3) {
      return "março";
    }
    if (month == 4) {
      return "abril";
    }
    if (month == 5) {
      return "maio";
    }
    if (month == 6) {
      return "junho";
    }
    if (month == 7) {
      return "julho";
    }
    if (month == 8) {
      return "agosto";
    }
    if (month == 9) {
      return "setembro";
    }
    if (month == 10) {
      return "outubro";
    }
    if (month == 11) {
      return "novembro";
    }
    return "dezembro";
  }
}
