import java.util.Scanner;

class TanqueCombustivel {
    public static void main(String[] args) {
        TanqueCombustivel tc = new TanqueCombustivel();
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int h = scan.nextInt();
        int option = scan.nextInt();

        if (option == 1) {
            tc.volumeAir(r, h);
        }
        if (option == 2) {
            tc.volumeFuel(r, h);
        }

        scan.close();
    }

    public void volumeFuel(int radius, int height) {
        double result = sphera(radius) - hubcap(radius, height);
        System.out.printf("%.4f", result);
    }

    public void volumeAir(int radius, int height) {
        double result = hubcap(radius, height);
        System.out.printf("%.4f", result);
    }

    public double sphera(int radius) {
        return (4 * Math.PI / 3) * Math.pow(radius, 3);
    }

    public double hubcap(int radius, int height) {
        return (Math.PI / 3) * Math.pow(height, 2) * (3 * radius - height);
    }
}
