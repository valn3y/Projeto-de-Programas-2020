import java.util.Scanner;

class Desconto {
    public static void main(String[] args) {
        Desconto d = new Desconto();
        Scanner scan = new Scanner(System.in);
        double price = scan.nextDouble();

        if (price >= 200.00) {
            d.descount(price);
        } else {
            System.out.printf("%.2f\n", price);
        }

        scan.close();
    }

    public void descount(double price) {
        double value = price - (0.05 * price);
        System.out.printf("%.2f\n", value);
    }
}
