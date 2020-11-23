import java.util.Hashtable;
import java.util.LinkedList;

import javax.xml.catalog.Catalog;

public class GoogleMain {
  public static void main(String[] args) {
    ListaInvertida li = new ListaInvertida();
    li.insere("force", "document1.txt");
    li.insere("force", "document2.txt");
    li.insere("force", "document3.txt");
    li.insere("always", "document1.txt");
    li.insere("one", "document3.txt");
    li.insere("is", "document2.txt");
    li.insere("is", "document3.txt");

    li.busca("force");

    System.out.println(li.toString());
  }
}
