package br.edu.ufam.icomp.lab_excecoes;

import br.edu.ufam.icomp.lab_excecoes.Coordenada;

public class RoverMain {
  public static void main(String[] args) {
    Caminho c = new Caminho(7);

    try {
      Coordenada coord1 = new Coordenada(32, 30, 1);
      Coordenada coord2 = new Coordenada(35, 40, 2);
      Coordenada coord3 = new Coordenada(38, 30, 3);
      Coordenada coord4 = new Coordenada(30, 36, 4);
      Coordenada coord5 = new Coordenada(40, 36, 5);
      Coordenada coord6 = new Coordenada(33, 31, 5);
      Coordenada coord7 = new Coordenada(20, 20, 6);
      c.addCoordenada(coord1);
      c.addCoordenada(coord2);
      c.addCoordenada(coord3);
      c.addCoordenada(coord4);
      c.addCoordenada(coord5);
      c.addCoordenada(coord6);
      c.addCoordenada(coord7);

      c.toString();
    } catch (Exception e) {
      c.reset();
    }
  }
}
