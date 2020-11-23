import java.util.Scanner;

class AreaVolume {
    public static void main(String[] args) {
        AreaVolume av = new AreaVolume();
        Scanner scan = new Scanner(System.in);
        double raio = scan.nextDouble();
        double a = av.area(raio);
        double v = av.volume(raio);

        System.out.printf("Um circulo com raio de %.2f centimetros tem uma area de %.2f centimetros quadrados.\n", raio,
                a);
        System.out.printf("Uma esfera com raio de %.2f centimetros tem um volume de %.2f centimetros cubicos.\n", raio,
                v);

        scan.close();
    }

    public double area(double raio) {
        return Math.PI * Math.pow(raio, 2);
    }

    public double volume(double raio) {
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }
}
