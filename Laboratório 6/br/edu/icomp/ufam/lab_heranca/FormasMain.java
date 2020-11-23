package br.edu.icomp.ufam.lab_heranca;

import java.util.ArrayList;

public class FormasMain {
  public static void main(String[] args) {
    ArrayList<FormaGeometrica> o = new ArrayList<FormaGeometrica>();
    Circulo c1 = new Circulo(5, 6, 4);
    Circulo c2 = new Circulo(10, 3, 8);
    Retangulo r1 = new Retangulo(2, 5, 2, 5);
    Retangulo r2 = new Retangulo(5, 5, 2, 3);
    Quadrado q1 = new Quadrado(1, 3, 2);
    Quadrado q2 = new Quadrado(3, 5, 6);
    o.add(c1);
    o.add(c2);
    o.add(r1);
    o.add(r2);
    o.add(q1);
    o.add(q2);

    for (int i = 0; i < o.size(); i++) {
      System.out.println(o.get(i));
    }
  }
}
