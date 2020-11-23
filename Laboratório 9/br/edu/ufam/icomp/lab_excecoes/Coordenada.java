package br.edu.ufam.icomp.lab_excecoes;

public class Coordenada {
  private int posX;
  private int posY;
  private int digito;

  public Coordenada(int posX, int posY, int digito)
      throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException {
    if (posX < 0 || posY < 0)
      throw new CoordenadaNegativaException();

    if ((posX < 0 || posX > 30000) || posY < 0 || posY > 30000)
      throw new CoordenadaForaDosLimitesException();

    if ((posX + posY) % 10 != digito)
      throw new DigitoInvalidoException();

    this.posX = posX;
    this.posY = posY;
    this.digito = digito;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public double distancia(Coordenada coordenada) {
    int diferenceX = posX - coordenada.getPosX();
    int diferenceY = posY - coordenada.getPosY();
    double distance = Math.sqrt(Math.pow(diferenceX, 2) + Math.pow(diferenceY, 2));
    return distance;
  }

  public String toString() {
    return posX + ", " + posY;
  }
}
