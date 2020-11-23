import java.util.Scanner;

public class AsciiArt {
  public static void main(String[] args) {
    AsciiArt aa = new AsciiArt();

    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    aa.makeArt(input);

    scan.close();
  }

  public void makeArt(Integer input) {
    for (int i = input; i > 0; i--) {
      start(i, input);
      end(i, input);
      System.out.println("");
    }
  }

  public void start(Integer input, Integer rootInput) {
    for (int i = 0; i < rootInput; i++) {
      if (i < input) {
        System.out.print("*");
      } else {
        System.out.print(" ");
      }
    }
  }

  public void end(Integer input, Integer rootInput) {
    int difference = rootInput - input;
    for (int i = 0; i < rootInput; i++) {
      if (difference > 0) {
        System.out.print(" ");
      } else {
        System.out.print("*");
      }

      difference--;
    }
  }
}
