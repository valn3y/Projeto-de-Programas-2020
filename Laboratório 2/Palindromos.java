import java.text.Normalizer;
import java.util.Scanner;

public class Palindromos {
  public static void main(String[] args) {
    Palindromos p = new Palindromos();
    Scanner scan = new Scanner(System.in);
    String input = scan.nextLine();
    p.verify(input);

    scan.close();
  }

  public void verify(String input) {
    String parseInput = input.toUpperCase().replace(" ", "");
    parseInput = parseInput.replace("-", "");
    parseInput = parseInput.replace(",", "");
    parseInput = parseInput.replace(".", "");
    parseInput = parseInput.replace("!", "");
    parseInput = parseInput.replace("?", "");
    parseInput = parseInput.replace(":", "");
    parseInput = Normalizer.normalize(parseInput, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

    String newString = "";
    int result = 0;
    int x = 0;
    int y = parseInput.length() - 1;

    while (x < parseInput.length() && y >= 0) {
      char x_value = parseInput.charAt(x);
      char y_value = parseInput.charAt(y);

      newString += x_value;
      if (x_value == y_value) {
        result = 1;
      } else {
        result = 0;
      }

      x++;
      y--;
    }

    System.out.println(newString + " " + result);
  }
}
