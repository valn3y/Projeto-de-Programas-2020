package br.edu.ufam.icomp.lab_excecoes;

public class DigitoInvalidoException extends RoverCoordenadaException {
  public DigitoInvalidoException() {
    super();
  }

  public DigitoInvalidoException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Digito da coordenada inválido";
  }
}
