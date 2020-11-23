import java.util.Hashtable;
import java.util.LinkedList;

import javax.naming.LinkException;

public class ListaInvertida {
  private Hashtable<String, LinkedList<String>> tabela;

  public ListaInvertida() {
    this.tabela = new Hashtable<String, LinkedList<String>>();
  }

  public boolean insere(String palavra, String documento) {
    if (tabela.get(palavra) != null) {
      LinkedList<String> list = tabela.get(palavra);
      if (list.contains(documento)) {
        return false;
      } else {
        list.add(documento);
        tabela.put(palavra, list);
        return true;
      }
    } else {
      LinkedList<String> list = new LinkedList<String>();
      list.add(documento);
      tabela.put(palavra, list);
      return true;
    }
  }

  public LinkedList<String> busca(String palavra) {
    LinkedList<String> list = tabela.get(palavra);
    return list;
  }

  public String toString() {
    return tabela.toString();
  }
}
