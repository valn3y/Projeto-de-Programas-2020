import java.util.ArrayList;
import java.util.Scanner;

class TimeFutebol {
  public static void main(String[] args) {
    TimeFutebol tf = new TimeFutebol();
    Scanner scan = new Scanner(System.in);
    int input = 0;
    ArrayList<Integer> team_home = new ArrayList<Integer>();
    ArrayList<Integer> team_visiting = new ArrayList<Integer>();

    while (input > -1) {
      input = scan.nextInt();
      if (input > -1) {
        team_home.add(input);
      }
    }

    input = 0;
    while (input > -1 && team_visiting.size() < team_home.size()) {
      input = scan.nextInt();
      if (input > -1) {
        team_visiting.add(input);
      }
    }

    tf.statistic(team_home, team_visiting);

    scan.close();
  }

  public void statistic(ArrayList<Integer> home, ArrayList<Integer> visit) {
    int win = 0;
    int defeat = 0;
    int equals = 0;

    for (int i = 0; i < home.size(); i++) {
      if (home.get(i) == visit.get(i)) {
        equals++;
      }
      if (home.get(i) > visit.get(i)) {
        win++;
      }
      if (home.get(i) < visit.get(i)) {
        defeat++;
      }
    }

    System.out.printf("%d %d %d\n", win, equals, defeat);
  }
}
