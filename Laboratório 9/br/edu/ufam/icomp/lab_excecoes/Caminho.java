package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {
  private Coordenada[] caminho;
  private int tamanho;

  public Caminho(int maxTam) {
    Coordenada[] caminho = new Coordenada[maxTam];
    this.caminho = caminho;
    this.tamanho = maxTam;
  }

  public int tamanho() {
    int size = 0;
    for (int i = 0; i < caminho.length; i++) {
      if (caminho[i] != null) {
        size++;
      }
    }
    return size;
  }

  public void addCoordenada(Coordenada coordenada)
      throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException {

    if (tamanho() == tamanho)
      throw new TamanhoMaximoExcedidoException();

    if (tamanho() == 0) {
      caminho[tamanho()] = coordenada;
    } else {
      if (caminho[tamanho() - 1].distancia(coordenada) > 15) {
        throw new DistanciaEntrePontosExcedidaException();
      } else {
        caminho[tamanho()] = coordenada;
      }
    }
  }

  public void reset() {
    for (int i = 0; i < caminho.length; i++) {
      caminho[i] = null;
    }
    this.caminho = caminho;
  }

  public String toString() {
    String message = "Dados do caminho:\n" + "  - Quantidade de pontos: " + tamanho() + "\n" + "  - Pontos:\n";

    if (tamanho() != 0) {
      for (int i = 0; i < tamanho(); i++) {
        message += "    -> " + caminho[i].toString();
      }
    }

    return message;
  }
}
