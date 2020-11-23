public class TurmaEmSala {
  Turma turma = new Turma();
  Sala sala = new Sala();

  TurmaEmSala() {
    turma = null;
    sala = null;
  }

  TurmaEmSala(Turma turma, Sala sala) {
    this.turma = turma;
    this.sala = sala;
  }
}
