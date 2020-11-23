import java.util.ArrayList;

public class Turma {
  String nome;
  String professor;
  int numAlunos;
  boolean acessivel;
  ArrayList<Integer> horarios = new ArrayList<Integer>();

  Turma() {
    nome = "";
    professor = "";
    numAlunos = 0;
    acessivel = false;
  }

  Turma(String nome, String professor, int numAlunos, boolean acessivel) {
    this.nome = nome;
    this.professor = professor;
    this.numAlunos = numAlunos;
    this.acessivel = acessivel;
  }

  public void addHorario(int horario) {
    horarios.add(horario);
  }

  public String getHorariosString() {
    int[] hours = { 8, 10, 12, 14, 16, 18, 20 };
    String result = "";

    for (int i = 0; i < horarios.size(); i++) {
      if (i != 0) {
        result += ", ";
      }
      if (horarios.get(i) <= 7) {
        result += "segunda " + hours[horarios.get(i) - 1] + "hs";
      }
      if (horarios.get(i) > 7 && horarios.get(i) <= 14) {
        result += "terça " + hours[horarios.get(i) - 8] + "hs";
      }
      if (horarios.get(i) > 14 && horarios.get(i) <= 21) {
        result += "quarta " + hours[horarios.get(i) - 15] + "hs";
      }
      if (horarios.get(i) > 21 && horarios.get(i) <= 28) {
        result += "quinta " + hours[horarios.get(i) - 22] + "hs";
      }
      if (horarios.get(i) > 28 && horarios.get(i) <= 35) {
        result += "sexta " + hours[horarios.get(i) - 29] + "hs";
      }
    }

    return result;

  }

  public String getDescricao() {
    String access = "não";
    if (acessivel) {
      access = "sim";
    }

    return "Turma: " + nome + "\n" + "Professor: " + professor + "\n" + "Número de Alunos: " + numAlunos + "\n"
        + "Horário: " + getHorariosString() + "\n" + "Acessível: " + access + "\n";
  }
}
