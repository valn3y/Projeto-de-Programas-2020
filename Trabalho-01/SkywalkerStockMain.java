import screens.Login.*;
import skywalkerDB.*;

/**
 * Classe SkywalkerStockMan - É classe de início do sistema.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class SkywalkerStockMain {
  public static void main(String args[]) {
    System.out.println("Bem-vindo ao stock skywalker!!!\n");

    System.out.println("Use as credenciais populadas pela classe PopulateDatabase.");
    System.out.println("Se ainda não populou, você pode executá-la antes para ter um cenário já pronto.\n");

    System.out.println("------Credenciais Administrador------");
    System.out.println("Email: admin@live.com");
    System.out.println("Senha: admin123\n");

    System.out.println("------Credenciais Usuário------");
    System.out.println("Email: user@live.com");
    System.out.println("Senha: user123\n");

    new Database();
    LoginScreen loginScreen = new LoginScreen();
    loginScreen.setVisible(true);
  }
}
