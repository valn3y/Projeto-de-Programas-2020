package br.edu.ufam.icomp.lab_excecoes;

public class CoordenadaForaDosLimitesException extends RoverCoordenadaException {
  public CoordenadaForaDosLimitesException() {
    super();
  }

  public CoordenadaForaDosLimitesException(String s) {
    super(s);
  }

  public String getMessage() {
    return "Coordenada com valores fora dos limites";
  }
}
