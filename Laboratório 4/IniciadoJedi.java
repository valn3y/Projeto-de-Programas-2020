/**
 * Classe IniciadoJedi - Representa especificações de um iniciado
 * 
 * @author Valney Marinho &lt;valney.junior@icomp.ufam.edu.br&gt;
 * @version 0.1, 2020-09-29
 */
public class IniciadoJedi {
  String nome;
  String especie;
  int anoNascimento;

  IniciadoJedi() {
    nome = "";
    especie = "";
    anoNascimento = 0;
  }

  /**
   * Construtor da classe
   * 
   * @param nome          nome do iniciado
   * @param especie       especie do inciado
   * @param anoNascimento ano de nascimento do inciado
   */
  IniciadoJedi(String nome, String especie, int anoNascimento) {
    this.nome = nome;
    this.especie = especie;
    this.anoNascimento = anoNascimento;
  }

  /**
   * Pega o ano de nascimento do iniciado e verifica se é DBY (Depois da batalha
   * de Yavin) ou ABY (Antes da batalha de Yavin)
   * 
   * @return String data formatada
   */
  public String getAnoNascimento() {
    if (anoNascimento > 0) {
      return Math.abs(anoNascimento) + " DBY";
    }

    return Math.abs(anoNascimento) + " ABY";
  }

  /**
   * Entrega a descrição sobre o iniciado, contendo: nome, especie e ano de
   * nascimento
   * 
   * @return String descrição do iniciado
   */
  public String getDescricao() {
    return nome + " " + "(especie=" + especie + ", nascimento=" + getAnoNascimento() + ")";
  }
}
