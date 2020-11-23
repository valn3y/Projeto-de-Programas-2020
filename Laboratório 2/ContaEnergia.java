import java.util.Scanner;

class ContaEnergia {
    public static void main(String[] args) {
        ContaEnergia ce = new ContaEnergia();
        Scanner scan = new Scanner(System.in);
        double value = scan.nextDouble();
        char type = scan.next().charAt(0);

        if (value > 0) {
            switch (type) {
                case ('R'):
                    ce.residential(value);
                    break;
                case ('C'):
                    ce.commercial(value);
                    break;
                case ('I'):
                    ce.industrial(value);
                    break;
                default:
                    System.out.println("-1.00");
                    break;
            }
        } else {
            System.out.println("-1.00");
        }

        scan.close();
    }

    public void residential(double value) {
        double result;
        if (value <= 500) {
            result = value * 0.4;
            System.out.printf("%.2f\n", result);
        }
        if (value > 500) {
            result = value * 0.65;
            System.out.printf("%.2f\n", result);
        }
    }

    public void commercial(double value) {
        double result;
        if (value <= 1000) {
            result = value * 0.55;
            System.out.printf("%.2f\n", result);
        }
        if (value > 1000) {
            result = value * 0.60;
            System.out.printf("%.2f\n", result);
        }
    }

    public void industrial(double value) {
        double result;
        if (value <= 5000) {
            result = value * 0.55;
            System.out.printf("%.2f\n", result);
        }
        if (value > 5000) {
            result = value * 0.60;
            System.out.printf("%.2f\n", result);
        }
    }
}
