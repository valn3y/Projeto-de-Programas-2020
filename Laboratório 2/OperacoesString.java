import java.util.Scanner;

public class OperacoesString {
  public static void main(String[] args) {
    OperacoesString os = new OperacoesString();
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();

    System.out.println(input.length());
    System.out.println(input.charAt(0));
    System.out.println(input.charAt(input.length() - 1));
    System.out.println(input.toUpperCase());
    System.out.println(input.toLowerCase());
    System.out.println(os.change_a_for_e(input));
    System.out.println(os.textPairs(input));
    System.out.println(os.vowels(input));

    scan.close();
  }

  public String change_a_for_e(String input) {
    String result = "";

    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) == 'a') {
        result += 'e';
      } else {
        result += input.charAt(i);
      }
    }

    return result;
  }

  public String textPairs(String input) {
    String result = "";

    for (int i = 0; i < input.length(); i++) {
      if (i % 2 == 0) {
        result += input.charAt(i);
      }
    }

    return result;
  }

  public Integer vowels(String input) {
    int count = 0;

    for (int i = 0; i < input.length(); i++) {
      char c = input.toLowerCase().charAt(i);
      if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        count++;
      }
    }

    return count;
  }
}
