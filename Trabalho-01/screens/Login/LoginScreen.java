package screens.Login;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import skywalkerDB.*;
import screens.Client.MainClientScreen;
import screens.Admin.MainAdminScreen;

/**
 * Classe LoginScreen - Tela de login.
 * 
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class LoginScreen extends JFrame {
  /** Constantes utilizadas na manipulação dos componentes */
  private String textTitle = "SKYWALKER STOCK";
  private String textSubTitle = "Sistema para Aluguel de Auto-serviço de Amazenamento";
  private String textWelcome = "Seja Bem-vindo";
  private String textSubWelcome = "Partiu alugar um espaço. RHHH!!!";
  private String textEmailField = "Insira o seu E-mail:";
  private String textPasswordField = "Insira a sua senha:";
  private String vaderImage = "vader.jpeg";

  private Database database;

  /**
   * Construtor que renderiza a tela de login
   */
  public LoginScreen() {
    setSize(1500, 900);
    setResizable(false);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    File file = new File(vaderImage);
    String pathImage = file.getAbsolutePath();
    setContentPane(new JLabel(new ImageIcon(pathImage)));

    JLabel title = new JLabel(textTitle);
    title.setBounds(585, 20, 335, 30);
    title.setFont(new Font("Dialog", Font.BOLD, 30));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setForeground(Color.white);
    UIManager.put("Label.font", title);
    add(title);

    JLabel subTitle = new JLabel(textSubTitle);
    subTitle.setBounds(542, 60, 420, 15);
    subTitle.setFont(new Font("Dialog", Font.ITALIC, 15));
    subTitle.setHorizontalAlignment(SwingConstants.CENTER);
    subTitle.setForeground(Color.white);
    UIManager.put("Label.font", subTitle);
    add(subTitle);

    JLabel welcome = new JLabel(textWelcome);
    welcome.setBounds(670, 300, 160, 20);
    welcome.setFont(new Font("Dialog", Font.PLAIN, 20));
    welcome.setHorizontalAlignment(SwingConstants.CENTER);
    welcome.setForeground(Color.white);
    UIManager.put("Label.font", welcome);
    add(welcome);

    JLabel subWelcome = new JLabel(textSubWelcome);
    subWelcome.setBounds(540, 320, 420, 25);
    subWelcome.setFont(new Font("Dialog", Font.PLAIN, 20));
    subWelcome.setHorizontalAlignment(SwingConstants.CENTER);
    subWelcome.setForeground(Color.white);
    UIManager.put("Label.font", subWelcome);
    add(subWelcome);

    JLabel emailField = new JLabel(textEmailField);
    emailField.setBounds(490, 377, 200, 10);
    emailField.setFont(new Font("Dialog", Font.PLAIN, 10));
    emailField.setHorizontalAlignment(SwingConstants.CENTER);
    emailField.setForeground(Color.white);
    UIManager.put("Label.font", subWelcome);
    add(emailField);
    JTextField emailInput = new JTextField();
    emailInput.setBounds(640, 370, 300, 25);
    add(emailInput);

    JLabel passwordField = new JLabel(textPasswordField);
    passwordField.setBounds(490, 417, 200, 10);
    passwordField.setFont(new Font("Dialog", Font.PLAIN, 10));
    passwordField.setHorizontalAlignment(SwingConstants.CENTER);
    passwordField.setForeground(Color.white);
    UIManager.put("Label.font", subWelcome);
    add(passwordField);
    JPasswordField passwordInput = new JPasswordField();
    passwordInput.setBounds(640, 410, 300, 25);
    add(passwordInput);

    JButton buttonLogin = new JButton("Login");
    buttonLogin.setBounds(670, 460, 160, 30);
    buttonLogin.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String email = emailInput.getText();
        String password = new String(passwordInput.getPassword());

        if (email.length() == 0 || password.length() == 0) {
          JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
        } else {
          requestLogin(email, password);
        }
      }
    });
    add(buttonLogin);

    JLabel titleSignup = new JLabel("Ainda não possui conta?");
    titleSignup.setBounds(20, 823, 190, 20);
    titleSignup.setFont(new Font("Dialog", Font.PLAIN, 15));
    titleSignup.setForeground(Color.white);
    add(titleSignup);

    JButton buttonSignup = new JButton("Cadastrar");
    buttonSignup.setBounds(220, 820, 120, 25);
    buttonSignup.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        SignupUserScreen signupUserScreen = new SignupUserScreen();
        signupUserScreen.setVisible(true);
      }
    });
    add(buttonSignup);
  }

  /**
   * Método que verifica no banco se o usuário existe e tenta fazer login com suas credenciais
   * @param email Email do usuário
   * @param password Senha do usuário
   */
  public void requestLogin(String email, String password) {
    try {
      database = new Database();
      UserRepository user = database.getUser(email, password);
      if (user == null) {
        JOptionPane.showMessageDialog(null,
            "Não foi possível fazer login, confira E-mail ou senha, ou cadastre um usuário.");
      } else {
        String category = user.getCategory();
        if (category.equals("user")) {
          dispose();
          MainClientScreen mainClientScreen = new MainClientScreen(user);
          mainClientScreen.setVisible(true);
        } else {
          dispose();
          MainAdminScreen mainAdminScreen = new MainAdminScreen(user);
          mainAdminScreen.setVisible(true);
        }
      }
    } catch (Error e) {
      System.out.println(e);
    }
  }
}