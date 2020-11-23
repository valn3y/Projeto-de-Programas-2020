import java.util.Scanner;

public class ValorExpoente {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        double result = 0;
        Double exp = 1.0;
        while (result < input) {
            result += Math.pow(2.0, exp);
            if (result <= input) {
                exp++;
            }
        }

        System.out.println(exp.intValue());

        scan.close();
    }
}
