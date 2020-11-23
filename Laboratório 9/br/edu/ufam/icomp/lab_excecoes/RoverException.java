package br.edu.ufam.icomp.lab_excecoes;

public class RoverException extends Exception {
  public RoverException() {
    super();
  }

  public RoverException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Exceção geral do rover";
  }
}
