package br.edu.ufam.icomp.lab_encapsulamento;

import br.edu.ufam.icomp.lab_encapsulamento.Localizavel;
import br.edu.ufam.icomp.lab_encapsulamento.CarroLuxuoso;
import java.util.ArrayList;

public class GISMain {
  public static void main(String[] args) {
    Localizavel[] localizaveis = new Localizavel[7];
    Celular c1 = new Celular(92, 80, 10000000);
    Celular c2 = new Celular(92, 80, 10000000);
    Celular c3 = new Celular(92, 80, 10000000);
    CarroLuxuoso cl1 = new CarroLuxuoso("JSXKSNSD");
    CarroLuxuoso cl2 = new CarroLuxuoso("JSXKSNSD");
    CarroLuxuoso cl3 = new CarroLuxuoso("JSXKSNSD");
    CarroLuxuoso cl4 = new CarroLuxuoso("JSXKSNSD");
    localizaveis[0] = c1;
    localizaveis[1] = c2;
    localizaveis[2] = c3;
    localizaveis[3] = cl1;
    localizaveis[4] = cl2;
    localizaveis[5] = cl3;
    localizaveis[6] = cl4;

    for (int i = 0; i < localizaveis.length; i++) {
      System.out.println(localizaveis[i].getPosicao());
    }
  }
}
