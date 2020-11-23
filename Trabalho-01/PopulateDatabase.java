import skywalkerDB.*;

/**
 * Classe PopulateDatabase - Utilizada para popular o banco, para se obter um
 * cenário pronto.
 * 
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class PopulateDatabase {
  public static void main(String args[]) {
    Database database = new Database();

    database.createUser("Usuário", "user@live.com", "user123", "user");
    database.createUser("Administrador", "admin@live.com", "admin123", "admin");

    database.createLocal("Guarda-Volumes", "Av. São José", 150, 150, 150, 1000, true, 2);
    database.createLocal("Contêiner", "Av. Acre", 500, 500, 500, 150, true, 2);
    database.createLocal("Quarto", "Av. São José", 150, 600, 160, 2000, false, 2, 1);
    database.createLocal("Galpão", "Av. São José", 100, 560, 550, 150, true, 2);
    database.createLocal("Guarda-Volumes", "Av. São Raimundo", 200, 200, 100, 150, false, 2, 1);
    database.createLocal("Guarda-Volumes", "Av. São José", 480, 250, 230, 600, false, 2, 1);
    database.createLocal("Contêiner", "Av. São Paulo", 510, 420, 630, 840, true, 2);
    database.createLocal("Galpão", "Av. Grande Circular", 140, 420, 630, 840, true, 2);
    database.createLocal("Guarda-volumes", "Av. Cosme Ferreira", 120, 220, 320, 2840, true, 2);

    database.createRent("2020-02-15", "2020-03-15", true, true, false, 3);
    database.createRent("2018-03-05", "2020-12-01", false, true, true, 5);
    database.createRent("2020-12-12", "2021-01-30", true, false, false, 6);
  }
}
