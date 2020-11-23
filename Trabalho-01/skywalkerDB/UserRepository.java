package skywalkerDB;

/**
 * Classe UserRepository - Classe modelo de um usuário.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class UserRepository {
  /** Informações de usuário de acordo com o esquema de banco */
  private int id;
  private String name;
  private String email;
  private String password;
  private String category;

  /**
   * Construtor de um usuário
   * @param id Id do usuário
   * @param name Nome do usuário
   * @param email Email do usuário
   * @param password Senha do usuário
   * @param category Categoria do usuário (usuário comum ou administrador)
   */
  public UserRepository(int id, String name, String email, String password, String category){
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
    this.category = category;
  }

  /**
   * Método get Id
   * @return int Id do usuário
   */
  public int getId(){
    return id;
  }

  /**
   * Método set Id
   * @param id Id do usuário
   */
  public void setId(int id){
    this.id = id;
  }

  /**
   * Método get Name
   * @return String Nome do usuário
   */
  public String getName(){
    return name;
  }

  /**
   * Método set Name
   * @param name Nome do usuário
   */
  public void setName(String name){
    this.name = name;
  }

  /**
   * Método get Email
   * @return String Email do usuário
   */
  public String getEmail(){
    return email;
  }

  /**
   * Método set Email
   * @param email Email do usuário
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Método get Password
   * @return String Senha do usuário
   */
  public String getPassword(){
    return password;
  }

  /**
   * Método set Password
   * @param password Senha do usuário
   */
  public void setPassword(String password){
    this.password = password;
  }

  /**
   * Método get Category
   * @return String Categoria de um usuário
   */
  public String getCategory() {
    return category;
  }

  /**
   * Método set Category
   * @param category Categoria de um usuário
   */
  public void setCategory(String category){
    this.category = category;
  }
} 
