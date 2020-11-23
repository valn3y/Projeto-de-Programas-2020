
/**
 * Classe TreinadorJedi - Representa especificações de um treinador jedi
 * 
 * @author Valney Marinho &lt;valney.junior@icomp.ufam.edu.br&gt;
 * @version 0.1, 2020-09-29
 */
public class TreinadorJedi {
  String titulacao;
  String nome;

  TreinadorJedi() {
    titulacao = "";
    nome = "";
  }

  /**
   * Construtor da classe
   * 
   * @param titulacao titulacao do treinador
   * @param nome      nome do treinador
   */
  TreinadorJedi(String titulacao, String nome) {
    this.titulacao = titulacao;
    this.nome = nome;
  }

  /**
   * Dá a descrição sobre o treinador, contendo: Titulação e nome.
   * 
   * @return String descrição do treinador
   */
  public String getDescricao() {
    return titulacao + " " + nome;
  }
}
