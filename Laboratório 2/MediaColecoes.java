import java.util.Scanner;

class MediaColecoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 0;
        double sum = 0;
        double media = 0;
        double count = 0;
        String status = "continue";

        while (status == "continue") {
            int in = scan.nextInt();
            if (in != -1) {
                sum = sum + in;
                count = count + 1;
            } else {
                if (in == value) {
                    status = "stop";
                } else {
                    media = sum / count;
                    System.out.printf("%.2f\n", media);
                    sum = 0;
                    count = 0;
                }
            }
            value = in;
        }

        scan.close();
    }
}
