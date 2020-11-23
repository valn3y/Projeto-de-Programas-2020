import java.util.ArrayList;

public class Ensalamento {
  ArrayList<Sala> salas;
  ArrayList<Turma> turmas;
  ArrayList<TurmaEmSala> ensalamento;

  Ensalamento() {
    this.salas = new ArrayList<Sala>();
    this.turmas = new ArrayList<Turma>();
    this.ensalamento = new ArrayList<TurmaEmSala>();
  }

  public void addSala(Sala sala) {
    salas.add(sala);
  }

  public void addTurma(Turma turma) {
    turmas.add(turma);
  }

  public Sala getSala(Turma turma) {
    Sala sala = null;
    for (int i = 0; i < ensalamento.size(); i++) {
      if (ensalamento.get(i).turma == turma) {
        return sala = ensalamento.get(i).sala;
      }
    }
    return sala;
  }

  public boolean salaDisponivel(Sala sala, int horario) {
    for (int i = 0; i < ensalamento.size(); i++) {
      if (ensalamento.get(i).sala == sala) {
        for (int j = 0; j < ensalamento.get(i).turma.horarios.size(); j++) {
          if (ensalamento.get(i).turma.horarios.get(j) == horario) {
            return false;
          }
        }
      }
    }
    return true;
  }

  public boolean salaDisponivel(Sala sala, ArrayList<Integer> horariosIntegers) {
    for (int i = 0; i < horariosIntegers.size(); i++) {
      if (salaDisponivel(sala, horariosIntegers.get(i))) {
        return true;
      }
    }
    return false;
  }

  public boolean alocar(Turma turma, Sala sala) {
    TurmaEmSala turmaEmSala = new TurmaEmSala(turma, sala);
    if (turma.acessivel == sala.acessivel && turma.numAlunos <= sala.capacidade
        && salaDisponivel(sala, turma.horarios)) {
      ensalamento.add(turmaEmSala);
      return true;
    }

    return false;
  }

  public void alocarTodas() {
    for (int i = 0; i < turmas.size(); i++) {
      for (int j = 0; j < salas.size(); j++) {
        if (alocar(turmas.get(i), salas.get(j))) {
          break;
        } else {
          continue;
        }
      }
    }
  }

  public int getTotalTurmasAlocadas() {
    int count = 0;
    for (int i = 0; i < ensalamento.size(); i++) {
      if (ensalamento.get(i) != null) {
        count++;
      }
    }
    return count;
  }

  public int getTotalEspacoLivre() {
    int total = 0;
    for (int i = 0; i < ensalamento.size(); i++) {
      if (ensalamento.get(i) != null) {
        total += ensalamento.get(i).sala.capacidade - ensalamento.get(i).turma.numAlunos;
      }
    }
    return total;
  }

  public String relatorioResumoEnsalamento() {
    return "Total de Salas: " + salas.size() + "\n" + "Total de Turmas: " + turmas.size() + "\n" + "Turmas Alocadas: "
        + getTotalTurmasAlocadas() + "\n" + "Espaços Livres: " + getTotalEspacoLivre() + "\n\n";
  }

  public String relatorioTurmasPorSala() {
    String result = relatorioResumoEnsalamento();

    for (int i = 0; i < salas.size(); i++) {
      result += "--- " + salas.get(i).getDescricao() + " ---\n\n";
      for (int j = 0; j < ensalamento.size(); j++) {
        if (ensalamento.get(j).sala == salas.get(i)) {
          result += ensalamento.get(j).turma.getDescricao() + "\n";
        }
      }
    }
    return result;
  }

  public String relatorioSalasPorTurma() {
    String result = relatorioResumoEnsalamento();
    for (int i = 0; i < turmas.size(); i++) {
      result += turmas.get(i).getDescricao();
      if (getSala(turmas.get(i)) != null) {
        result += "Sala: " + getSala(turmas.get(i)).getDescricao() + "\n\n";
      } else {
        result += "Sala: SEM SALA\n\n";
      }
    }

    return result;
  }
}
