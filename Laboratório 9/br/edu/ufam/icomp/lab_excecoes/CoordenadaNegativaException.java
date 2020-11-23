package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaNegativaException extends RoverCoordenadaException {
  public CoordenadaNegativaException() {
    super();
  }

  public CoordenadaNegativaException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Coordenada com valor negativo";
  }
}
