package br.edu.ufam.icomp.lab_excecoes;

public class RoverCaminhoException extends RoverException {
  public RoverCaminhoException() {
    super();
  }

  public RoverCaminhoException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Exceção geral de caminho do rover";
  }
}
