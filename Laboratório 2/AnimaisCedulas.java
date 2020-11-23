import java.util.Scanner;

class AnimaisCedulas {
    public static void main(String[] args) {
        AnimaisCedulas ac = new AnimaisCedulas();
        Scanner scan = new Scanner(System.in);
        int value = scan.nextInt();

        String symbol = ac.ballot(value);
        System.out.println(symbol);

        scan.close();
    }

    public String ballot(int value) {
        if (value == 2) {
            return "Tartaruga";
        }
        if (value == 5) {
            return "Garça";
        }
        if (value == 10) {
            return "Arara";
        }
        if (value == 20) {
            return "Mico-leão-dourado";
        }
        if (value == 50) {
            return "Onça-pintada";
        }
        if (value == 100) {
            return "Garoupa";
        }
        return "erro";
    }
}
