package skywalkerDB;

/**
 * Classe LocalRepository - Classe modelo de repositório.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class LocalRepository {
  /** Informações de um repositório */
  private int id;
  private String category;
  private String address;
  private int width;
  private int height;
  private int depth;
  private int price;
  private int available;
  private int idUser;
  private int idTenant;

  /**
   * Construtor de um local
   * @param id Id do local
   * @param category Categoria do local Conteiner, Quarto, Galpao e Guarda-Volume
   * @param address Endereço de um local
   * @param width Comprimento de um local
   * @param height Altura de um local
   * @param depth Profundidade de um local
   * @param price Preço de um local
   * @param available Disponibilidade de um local
   * @param idUser Id do dono do local
   * @param idTenant Id do inquilino
   */
  public LocalRepository(int id, String category, String address, int width, int height, int depth, int price, int available, int idUser, int idTenant){
    this.id = id;
    this.category = category;
    this.address = address;
    this.width = width;
    this.height = height;
    this.depth = depth;
    this.price = price;
    this.available = available;
    this.idUser = idUser;
    this.idTenant = idTenant;
  }

  /**
   * Método get id
   * @return int Id do Local
   */
  public int getId(){
    return id;
  }

  /**
   * Método set id
   * @param id Id do Local
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Método get Category
   * @return String Categoria do Local
   */
  public String getCategory(){
    return category;
  }

  /**
   * Método set Category
   * @param category Categoria do Local
   */
  public void setCategory(String category){
    this.category = category;
  }

  /**
   * Método get Address
   * @return String Endereço de um local
   */
  public String getAddress(){
    return address;
  }

  /**
   * Método set Address
   * @param address Endereço do local
   */
  public void setAddress(String address){
    this.address = address;
  }

  /**
   * Método get Width
   * @return int Comprimento do local
   */
  public int getWidth(){
    return width;
  }

  /**
   * Método set Width
   * @param width Comprimento do local
   */
  public void setWidth(int width){
    this.width = width;
  }

  /**
   * Método get Height
   * @return int Altura do local
   */
  public int getHeight(){
    return height;
  }

  /**
   * Método set Height
   * @param height Altura do local
   */
  public void setHeight(int height){
    this.height = height;
  }

  /**
   * Método get Depth
   * @return int Profundidade do local
   */
  public int getDepth(){
    return depth;
  }

  /**
   * Método set Depth
   * @param depth Profundidade do local
   */
  public void setDepth(int depth){
    this.depth = depth;
  }

  /**
   * Método get Price
   * @return int Preço do local
   */
  public int getPrice(){
    return price;
  }

  /**
   * Método set Price
   * @param price Preço do local
   */
  public void setPrice(int price){
    this.price = price;
  }

  /**
   * Método get Available
   * @return boolean Disponibilidade do local
   */
  public boolean getAvailable(){
    return available == 1 ? true : false;
  }

  /**
   * Método set Available
   * @param available Disponibilidade do local
   */
  public void setAvailable(int available){
    this.available = available;
  }

  /**
   * Método get IdUser
   * @return int Id do usuário
   */
  public int getIdUser(){
    return idUser;
  }

  /**
   * Método set IdUser
   * @param idUser Id do usuário
   */
  public void setIdUser(int idUser){
    this.idUser = idUser;
  }

  /**
   * Método get IdTenant
   * @return int Id do inquilino
   */
  public int getIdTenant(){
    return idTenant;
  }

  /**
   * Método set IdTenant
   * @param idTenant Id do inquilino
   */
  public void setIdTenant(int idTenant){
    this.idTenant = idTenant;
  }
}
