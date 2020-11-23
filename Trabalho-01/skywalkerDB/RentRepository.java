package skywalkerDB;

/**
 * Classe RentRepository - Classe modelo de um aluguel.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class RentRepository {
  /**Informações de um aluguel de acordo com o esquema de banco */
  private int id;
  private String startDate;
  private String endDate;
  private int security;
  private int keyExtra;
  private int controlWether;
  private int idLocal;

  /**
   * Construtor de um aluguel
   * @param id Id do aluguel
   * @param startDate Data de inicio
   * @param endDate Data de fim
   * @param security Opcional de seguro
   * @param keyExtra Opcional de chave extra
   * @param controlWether Opcional de controle climático
   * @param idLocal Id do local
   */
  public RentRepository(int id, String startDate, String endDate, int security, int keyExtra, int controlWether, int idLocal){
    this.id = id;
    this.startDate = startDate;
    this.endDate = endDate;
    this.security = security;
    this.keyExtra = keyExtra;
    this.controlWether = controlWether;
    this.idLocal = idLocal;
  }

  /**
   * Método get Id
   * @return int Id do aluguel
   */
  public int getId(){
    return id;
  }

  /**
   * Método set Id
   * @param id Id do aluguel
   */
  public void setId(int id){
    this.id = id;
  }

  /**
   * Método get StartDate
   * @return String Data de início
   */
  public String getStartDate(){
    return startDate;
  }

  /**
   * Método set StartDate
   * @param startDate Data de inicio
   */
  public void setStartDate(String startDate){
    this.startDate = startDate;
  }

  /**
   * Método get EndDate
   * @return String Data de fim
   */
  public String getEndDate(){
    return endDate;
  }

  /**
   * Método set EndDate
   * @param endDate Data de fim
   */
  public void setEndDate(String endDate){
    this.endDate = endDate;
  }

  /**
   * Método get Security
   * @return boolean Opcional seguro
   */
  public boolean getSecurity(){
    return security == 1 ? true : false;
  }

  /**
   * Método set Security
   * @param security Opcional de seguro
   */
  public void setSecurity(int security){
    this.security = security;
  }

  /**
   * Método get KeyExtra
   * @return boolean Opcional de chave extra
   */
  public boolean getKeyExtra(){
    return keyExtra == 1 ? true : false;
  }

  /**
   * Método set KeyExtra
   * @param keyExtra Opcional de chave extra
   */
  public void setKeyExtra(int keyExtra){
    this.keyExtra = keyExtra;
  }

  /**
   * Método get ControlWether
   * @return boolean Opcional de controle climatico
   */
  public boolean getControlWether(){
    return controlWether == 1 ? true : false;
  }

  /**
   * Método set ControlWether
   * @param controlWether Opcional de controle climático
   */
  public void setControlWether(int controlWether){
    this.controlWether = controlWether;
  }

  /**
   * Método get IdLocal
   * @return int Id do local
   */
  public int getIdLocal(){
    return idLocal;
  }

  /**
   * Método set IdLocal
   * @param idLocal Id do local
   */
  public void setIdLocal(int idLocal){
    this.idLocal = idLocal;
  }
}
