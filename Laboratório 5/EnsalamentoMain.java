public class EnsalamentoMain {
  public static void main(String[] args) {
    Sala sala1 = new Sala(6, 101, 50, true);
    Sala sala2 = new Sala(6, 102, 100, true);
    Sala sala3 = new Sala(6, 203, 50, false);
    Sala sala4 = new Sala(6, 204, 100, false);
    Ensalamento e = new Ensalamento();
    e.addSala(sala1);
    e.addSala(sala2);
    e.addSala(sala3);
    e.addSala(sala4);

    Turma turma1 = new Turma("Algoritmos e Estruturas de Dados I", "Edleno Silva", 60, false);
    turma1.addHorario(1);
    turma1.addHorario(15);
    turma1.addHorario(29);

    Turma turma2 = new Turma("Técnicas de Programação", "Horácio Fernandes", 50, false);
    turma2.addHorario(11);
    turma2.addHorario(25);
    turma2.addHorario(32);

    Turma turma3 = new Turma("Laboratório de Programação C", "Edson Nascimento", 25, true);
    turma3.addHorario(1);
    turma3.addHorario(15);
    turma3.addHorario(29);

    Turma turma4 = new Turma("Redes de Computadores", "Edjair Souza", 70, true);
    turma4.addHorario(2);
    turma4.addHorario(16);

    e.addTurma(turma1);
    e.addTurma(turma2);
    e.addTurma(turma3);
    e.addTurma(turma4);
    e.alocarTodas();

    System.out.println(e.relatorioResumoEnsalamento());
    System.out.println(e.relatorioTurmasPorSala());
    System.out.println(e.relatorioSalasPorTurma());
  }
}
