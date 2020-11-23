import java.util.Scanner;

class NumeroNarcisista {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    Integer input = scan.nextInt();
    String digits = input.toString();

    int sizeDigits = digits.length();
    int result = 0;

    for (int i = 0; i < sizeDigits; i++) {
      result += Math.pow(Character.getNumericValue((digits.charAt(i))), sizeDigits);
    }

    if (result == input) {
      System.out.println("SIM");
    } else {
      System.out.println("NAO");
    }

    scan.close();
  }
}
