package br.edu.ufam.icomp.lab_excecoes;

public class TamanhoMaximoExcedidoException extends RoverCaminhoException {
  public TamanhoMaximoExcedidoException() {
    super();
  }

  public TamanhoMaximoExcedidoException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Quantidade máxima de coordenadas excedida";
  }
}
