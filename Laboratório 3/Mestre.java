public class Mestre {
  String nome;
  int anoNascimento;
  String afiliacao;
  String posto;

  Mestre() {
    nome = "";
    anoNascimento = 0;
    afiliacao = "";
    posto = "";
  }

  Mestre(String nome, int anoNascimento, String afiliacao, String posto) {
    this.nome = nome;
    this.anoNascimento = anoNascimento;
    this.afiliacao = afiliacao;
    this.posto = posto;
  }

  public int getIdade(int anoReferência) {
    int age = anoReferência - anoNascimento;
    return age;
  }

  public String getAnoNascimentoString() {
    if (anoNascimento > 0) {
      return Math.abs(anoNascimento) + "DBY";
    }
    return Math.abs(anoNascimento) + "ABY";
  }

  public boolean possuiForca() {
    if (posto == "Jedi" || posto == "Sith") {
      return true;
    }
    return false;
  }

  public String getDescricao() {
    return "Mestre: nome=" + nome + ", anoNascimento=" + getAnoNascimentoString() + ", afiliacao=" + afiliacao
        + ", posto=" + posto + ", possuiForca=" + possuiForca() + ".";
  }
}
