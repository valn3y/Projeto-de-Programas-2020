import java.util.ArrayList;
import java.util.Scanner;

public class AprovacaoDisciplina {
  public static void main(String[] args) {
    AprovacaoDisciplina ad = new AprovacaoDisciplina();
    Scanner scan = new Scanner(System.in);

    double inputGrades = 0;
    ArrayList<Double> grades = new ArrayList<Double>();
    while (inputGrades > -1) {
      inputGrades = scan.nextDouble();
      if (inputGrades > -1) {
        grades.add(inputGrades);
      }
    }

    int inputPresence = 0;
    ArrayList<Integer> presence = new ArrayList<Integer>();
    while (inputPresence > -1) {
      inputPresence = scan.nextInt();
      if (inputPresence > -1) {
        presence.add(inputPresence);
      }
    }

    if (presence.size() == grades.size()) {
      int hoursSubject = scan.nextInt();

      ad.statictis(grades, presence, hoursSubject);
    }

    scan.close();
  }

  public void statictis(ArrayList<Double> grades, ArrayList<Integer> presence, Integer hoursSubject) {
    Double minHourToPass = 0.75 * hoursSubject;

    int pass = 0;
    int reproveForGrade = 0;
    int reproveForFrequence = 0;

    for (int i = 0; i < grades.size(); i++) {
      if (grades.get(i) >= 5 && presence.get(i) >= minHourToPass) {
        pass++;
      }

      if (presence.get(i) < minHourToPass) {
        reproveForFrequence++;
      }

      if (grades.get(i) < 5 && presence.get(i) >= minHourToPass) {
        reproveForGrade++;
      }
    }

    System.out.printf("%d %d %d", pass, reproveForGrade, reproveForFrequence);
  }
}
