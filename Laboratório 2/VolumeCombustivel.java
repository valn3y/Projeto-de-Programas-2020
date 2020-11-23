import java.util.Scanner;

public class VolumeCombustivel {
  public static void main(String[] args) {
    VolumeCombustivel vc = new VolumeCombustivel();
    Scanner scan = new Scanner(System.in);
    int H = scan.nextInt();
    int h = scan.nextInt();
    int r = scan.nextInt();

    if (h > H || r <= 0 || H <= 0) {
      System.out.println("-1.000");
    } else {
      if (h < r) {
        System.out.printf("%.3f\n", vc.volume_hubcap(h, r));
      }

      if (h == r) {
        System.out.printf("%.3f\n", vc.volume_sfera(r) / 2);
      }

      if (h <= H - r && h > r) {
        Double volume_total = vc.volume_sfera(r) / 2 + vc.volume_cylinder(h - r, r);
        System.out.printf("%.3f\n", volume_total);
      }

      if (h < H && h > H - r) {
        Double volume_total = vc.volume_sfera(r) + vc.volume_cylinder(h, r) - vc.volume_hubcap(Math.abs(h - r), r);
        System.out.printf("%.3f\n", volume_total);
      }

      if (h == H) {
        Double volume_total = vc.volume_cylinder(h, r) + vc.volume_sfera(r);
        System.out.printf("%.3f\n", volume_total);
      }
    }

    scan.close();
  }

  public Double volume_sfera(Integer r) {
    return (4 * Math.PI * Math.pow(r, 3)) / 3;
  }

  public Double volume_cylinder(Integer h, Integer r) {
    return Math.PI * Math.pow(r, 2) * h;
  }

  public Double volume_hubcap(Integer h, Integer r) {
    return (Math.PI * Math.pow(h, 2) * (3 * r - h)) / 3;
  }
}
