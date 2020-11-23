package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class CarroLuxuoso extends Carro implements Localizavel {
  public CarroLuxuoso(String placa) {
    super(placa);
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
    return 15.0;
  }
}
