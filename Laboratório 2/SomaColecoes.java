import java.util.Scanner;

class SomaColecoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int value = 0;
        int sum = 0;
        String status = "continue";

        while (status == "continue") {
            int in = scan.nextInt();
            if (in != -1) {
                sum = sum + in;
            } else {
                if (in == value) {
                    status = "stop";
                } else {
                    System.out.println(sum);
                    sum = 0;
                }
            }
            value = in;
        }

        scan.close();
    }
}
