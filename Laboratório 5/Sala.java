public class Sala {
  int bloco;
  int sala;
  int capacidade;
  boolean acessivel;

  Sala() {
    bloco = 0;
    sala = 0;
    capacidade = 0;
    acessivel = false;
  }

  Sala(int bloco, int sala, int capacidade, boolean acessivel) {
    this.bloco = bloco;
    this.sala = sala;
    this.capacidade = capacidade;
    this.acessivel = acessivel;
  }

  public String getDescricao() {
    String isAccess = "não acessível";
    if (acessivel) {
      isAccess = "acessível";
    }
    return "Bloco " + bloco + ", Sala " + sala + " (" + capacidade + " lugares, " + isAccess + ")";
  }
}
