import java.util.ArrayList;

/**
 * Classe SessaoJedi - Representa a sessao de um treinador com os iniciados
 * 
 * @author Valney Marinho &lt;valney.junior@icomp.ufam.edu.br&gt;
 * @version 0.1, 2020-09-29
 */
public class SessaoJedi {

  String nome;
  TreinadorJedi treinador = new TreinadorJedi();
  ArrayList<IniciadoJedi> iniciados = new ArrayList<IniciadoJedi>();

  /**
   * Construtor da classe
   * 
   * @param nome      nome da sessão
   * @param treinador informações do treinador Jedi
   */
  SessaoJedi(String nome, TreinadorJedi treinador) {
    this.nome = nome;
    this.treinador = treinador;
  }

  /**
   * Adiciona um iniciado na lista de todos os iniciados sem ter repetidos
   * 
   * @param iniciado objeto iniciado do tipo IniciadoJedi
   */
  public void addIniciado(IniciadoJedi iniciado) {
    boolean repeat = false;
    for (int i = 0; i < iniciados.size(); i++) {
      if (iniciados.get(i) == iniciado) {
        repeat = true;
      }
    }
    if (!repeat) {
      iniciados.add(iniciado);
    }
  }

  /**
   * Pega a informação de iniciado através do seu nome, se ele não estiver na
   * lista retornará null
   * 
   * @param nome String do nome de um iniciado
   * @return IniciadoJedi retorna um iniciado se ele existir, se não retorna null
   */
  public IniciadoJedi getIniciado(String nome) {
    IniciadoJedi iniciado = null;
    for (int i = 0; i < iniciados.size(); i++) {
      if (iniciados.get(i).nome == nome) {
        iniciado = iniciados.get(i);
      }
    }
    return iniciado;
  }

  /**
   * Dá a média do ano de nascimento dos iniciados da lista
   * 
   * @return Double retorna a média da idade
   */
  public double getMediaAnoNascimento() {
    int sum = 0;
    for (int i = 0; i < iniciados.size(); i++) {
      sum += iniciados.get(i).anoNascimento;
    }
    return sum / iniciados.size();
  }

  /**
   * Entrega a descrição sobre a sessão, contendo: nome da sessão, informações do
   * treinador e a listagem dos iniciados
   * 
   * @return String descrição da sessão
   */
  public String getDescricao() {
    int order = 1;
    String descricao = "--> SESSÃO " + nome + " (Treinador: " + treinador.getDescricao() + ")\n";
    for (int i = 0; i < iniciados.size(); i++) {
      descricao += "  - Iniciado " + order + ": " + getIniciado(iniciados.get(i).nome).getDescricao() + "\n";
      order++;
    }
    return descricao;
  }
}
