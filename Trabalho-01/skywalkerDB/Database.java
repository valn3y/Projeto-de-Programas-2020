package skywalkerDB;
import java.sql.*;
import java.util.ArrayList;

/**
 * Classe Database - Conexão e métodos de manipulação do banco de dados.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class Database {
  /**Dados para conexão */
  private static String url = "jdbc:mysql://localhost:3306/stock_skywalker";
  private static String user = "junior";
  private static String password = "junior";
  protected static Connection connection = null;

  /**
   * Construtor da classe.
   */
  public Database() {
    if (connection == null)
      connect();
  }

  /**
   * Método que tenta fazer conexão com o banco
   * @return Boolean
   */
  private static boolean connect() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, password);
      return true;
    }catch (ClassNotFoundException e){
      System.out.println(e);
      return false;
    }
     catch (SQLException e) {
       System.out.println(e);
      return false;
    }
  }

  /**
   * Método que encerrar a conexão com o banco
   * @return Boolean
   */
  public static boolean disconnect() {
    try {
      connection.close();
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  /**
   * Método que tenta criar um usuário
   * @param name Nome do usuário
   * @param email Email do usuário
   * @param password Senha do usuário
   * @param category Categoria do usuário, sendo usuário comum ou um admin
   * @return Boolean
   */
  public boolean createUser(String name, String email, String password, String category) {
    try {
      Statement statement = connection.createStatement();
      statement.executeUpdate(
        "INSERT INTO user (name, email, password, category) VALUES ('"
        + name + "', '" + email + "', '"+ password + "', '" + category + "')"
      );
      return true;
    } catch (SQLException e) {
      return false;
    }
  }

  /**
   * Método que tenta criar um local sem relação com inquilino
   * @param category Categoria do local, Conteiner, Quarto, Galpao e Guarda-Volumes
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param available Disponibilidade do local
   * @param idUser Id do dono do local
   * @return Boolean
   */
  public boolean createLocal(String category, String address, int width, int height, int depth, int price, Boolean available, int idUser){
    int newAvailable = available ? 1 : 0;

    try{
      Statement statement = connection.createStatement();
      statement.executeUpdate(
        "INSERT INTO local (category, address, width, height, depth, price, available, idUser) VALUES ('"
        + category + "', '"+ address + "', " + width + ", " + height + ", " + depth + ", " + price+ ", " + newAvailable + ", " + idUser + ")"
      );
      return true;
    } catch (SQLException e){
      System.out.println(e);
      return false;
    }
  }

  /**
   * Método que tenta criar um local com relação com inquilino
   * @param category Categoria do local, Conteiner, Quarto, Galpao e Guarda-Volumes
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param available Disponibilidade do local
   * @param idUser Id do dono do local
   * @param idTenant Id do inquilino
   * @return Boolean
   */
  public boolean createLocal(String category, String address, int width, int height, int depth, int price, Boolean available, int idUser, int idTenant){
    int newAvailable = available ? 1 : 0;

    try{
      Statement statement = connection.createStatement();
      statement.executeUpdate(
        "INSERT INTO local (category, address, width, height, depth, price, available, idUser, idTenant) VALUES ('"
        + category + "', '"+ address + "', " + width + ", " + height + ", " + depth + ", " + price+ ", " + newAvailable + ", " + idUser + ", " + idTenant + ")"
      );
      return true;
    } catch (SQLException e){
      System.out.println(e);
      return false;
    }
  }

  /**
   * Método que tenta criar um aluguel
   * @param startDate Data de início
   * @param endDate Data de fim
   * @param security Opcional de seguro
   * @param keyExtra Opcional de chave extra
   * @param controlWether Opcicional de controle climático
   * @param idLocal Id do local
   * @return Boolean
   */
  public boolean createRent(String startDate, String endDate, boolean security, boolean keyExtra, boolean controlWether, int idLocal){
    int securitySQL = security ? 1 : 0;
    int keyExtraSQL = keyExtra ? 1 : 0;
    int controlWetherSQL = controlWether ? 1 : 0;

    try{
      Statement statement = connection.createStatement();
      statement.executeUpdate(
        "INSERT INTO rent (startDate, endDate, security, keyExtra, controlWether, idLocal) VALUES ('"
        + startDate + "', '" + endDate + "', " + securitySQL + ", " + keyExtraSQL + ", " + controlWetherSQL + ", " + idLocal +")"
      );
      return true;
    } catch(SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Método que pega as credenciais de um usuário existente
   * @param email Email do usuário
   * @param password Senha do usuário
   * @return UserRepository Classe modelo de um usuário
   */
  public UserRepository getUser(String email, String password){
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE email='" + email + "' AND password='"+ password  +"'");
      if(resultSet.next()){
        return new UserRepository(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
      } else {
        return null;
      }
    } catch(SQLException e ){
      System.out.println(e);
      return null;
    }
  }

  /**
   * Método que pega os locais pertecentes a um adminstrador
   * @param idAdmin Id do administrador
   * @return ArrayList<LocalRepository> Lista da Classe modelo de um local
   */
  public ArrayList<LocalRepository> getLocalByAdmin(int idAdmin){
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM local WHERE idUser=" + idAdmin);
      ArrayList<LocalRepository> lista = new ArrayList<LocalRepository>();

      while(resultSet.next()){
        lista.add(new LocalRepository(
          resultSet.getInt(1),
          resultSet.getString(2),
          resultSet.getString(3),
          resultSet.getInt(4),
          resultSet.getInt(5),
          resultSet.getInt(6),
          resultSet.getInt(7),
          resultSet.getInt(8),
          resultSet.getInt(9),
          resultSet.getInt(10)
        ));
      }

      return lista;
    } catch(SQLException e){
      System.out.println(e);
      return null;
    }
  }

  /**
   * Método que pega todos o locais
   * @return ArrayList<LocalRepository> Lista da Classe modelo de um local
   */
  public ArrayList<LocalRepository> getLocals(){
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM local WHERE available=1");
      ArrayList<LocalRepository> lista = new ArrayList<LocalRepository>();

      while (resultSet.next()){
        lista.add(new LocalRepository(
          resultSet.getInt(1),
          resultSet.getString(2),
          resultSet.getString(3),
          resultSet.getInt(4),
          resultSet.getInt(5),
          resultSet.getInt(6),
          resultSet.getInt(7),
          resultSet.getInt(8),
          resultSet.getInt(9),
          resultSet.getInt(10)
        ));
      }
      return lista;
    } catch(SQLException e){
      System.out.println(e);
      return null;
    }
  }

  /**
   * Método que pega os locais de alugados de um usuário
   * @param idUser Id do usuário
   * @return ArrayList<LocalRepository> Lista da Classe modelo de um local
   */
  public ArrayList<LocalRepository> getMyLocals(int idUser){
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM local WHERE idTenant=" + idUser);
      ArrayList<LocalRepository> lista = new ArrayList<LocalRepository>();
      
      while(resultSet.next()){
        lista.add(new LocalRepository(
          resultSet.getInt(1),
          resultSet.getString(2),
          resultSet.getString(3),
          resultSet.getInt(4),
          resultSet.getInt(5),
          resultSet.getInt(6),
          resultSet.getInt(7),
          resultSet.getInt(8),
          resultSet.getInt(9),
          resultSet.getInt(10)
        ));
      }

      return lista;
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }

  /**
   * Método que pega todos os alugueis para um administrador
   * @param idLocal Id do local
   * @return RentRepository Classe modelo de um aluguel
   */
  public RentRepository getRents(int idLocal){
    try{
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM rent WHERE idLocal=" + idLocal);

      if(resultSet.next()){
        return new RentRepository(
          resultSet.getInt(1),
          resultSet.getString(2),
          resultSet.getString(3),
          resultSet.getInt(4),
          resultSet.getInt(5),
          resultSet.getInt(6),
          resultSet.getInt(7)
        );
      } else {
        return null;
      }
    } catch(SQLException e){
      System.out.println(e);
      return null;
    }
  }

  /**
   * Método que muda a disponibilidade de um local
   * @param available Disponibilidade do local
   * @param idLocal Id do local
   * @param idTenant Id do inquilino
   */
  public void changeAvailable(boolean available, int idLocal, int idTenant){
    int newAvailable = available ? 1 : 0;
    try{
      Statement statement = connection.createStatement();
      statement.executeUpdate("UPDATE local SET available=" + newAvailable + ", idTenant=" + idTenant + " WHERE idLocal=" + idLocal);
    } catch (SQLException e){
      System.out.println(e);
    }
  }

  /**
   * Método que atualiza as informações de um local
   * @param category Categoria do local, sendo Conteiner, Quarto, Galpao e Guarda-Volumes
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param heght Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   * @return Boolean
   */
  public boolean updateLocal(String category, String address, int width, int heght, int depth, int price, int idLocal){
    try{
      Statement statement = connection.createStatement();
      statement.executeUpdate(
        "UPDATE local SET category='" + category + "', address='" + address + "', width="
        + width + ", height=" + heght + ", depth=" + depth + ", price=" + price + " WHERE idLocal=" + idLocal);
      
      return true;
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Método que deleta um local
   * @param idLocal Id do local
   * @return Boolean
   */
  public boolean deleteLocal(int idLocal){
    try {
      Statement statement = connection.createStatement();
      statement.executeUpdate("DELETE FROM local WHERE idLocal=" + idLocal);
      return true;
    } catch (SQLException e){
      System.out.println(e);
      return false;
    }
  }
}