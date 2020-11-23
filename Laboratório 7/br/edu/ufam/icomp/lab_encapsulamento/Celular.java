package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class Celular implements Localizavel {
  private int codPais;
  private int codArea;
  private int numero;

  public Celular(int codPais, int codArea, int numero) {
    setCodPais(codPais);
    setCodArea(codArea);
    setNumero(numero);
  }

  public final void setCodPais(int codPais) {
    if (codPais > 0 && codPais < 2000) {
      this.codPais = codPais;
    } else {
      this.codPais = -1;
    }
  }

  public int getCodPais() {
    return codPais;
  }

  public final void setCodArea(int codArea) {
    if (codArea >= 0 && codArea <= 99) {
      this.codArea = codArea;
    } else {
      this.codArea = -1;
    }
  }

  public int getCodArea() {
    return codArea;
  }

  public final void setNumero(int numero) {
    if (numero >= 10000000 && numero <= 999999999) {
      this.numero = numero;
    } else {
      this.numero = -1;
    }
  }

  public int getNumero() {
    return numero;
  }

  public Posicao getPosicao() {
    Random random = new Random();
    double minLatitude = -3.160000;
    double maxLatitude = -2.960000;
    double minLongitude = -60.120000;
    double maxLongitude = -59.820000;
    double minAltitude = 15.0;
    double maxAltitude = 100.0;

    double latitude = minLatitude + (maxLatitude - minLatitude) * random.nextDouble();
    double longitude = minLongitude + (maxLongitude - minLongitude) * random.nextDouble();
    double altitude = minAltitude + (maxAltitude - minAltitude) * random.nextDouble();

    Posicao posicao = new Posicao(latitude, longitude, altitude);

    return posicao;
  }

  public double getErroLocalizacao() {
    return 50.0;
  }
}
