import java.util.Scanner;

class MediaColecao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 0;
        double media = 0;
        double sum = 0;
        double count = 0;
        while (value >= 0) {
            int in = scan.nextInt();
            if (in > 0) {
                sum = sum + in;
                count = count + 1;
            }
            value = in;
        }
        media = sum / count;
        System.out.printf("%.2f\n", media);

        scan.close();
    }
}
