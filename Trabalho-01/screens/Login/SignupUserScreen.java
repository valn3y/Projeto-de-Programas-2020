package screens.Login;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

import skywalkerDB.*;


/**
 * Classe SignupUserScreen - Tela de cadastro do usuário
 * 
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class SignupUserScreen extends JFrame {
  /** Constantes utilizadas para manipulação dos componentes */
  private String signupImage = "signup.jpg";
  private String textTitle = "Cadastro";
  private String textSubInfo = "Precisamos de suas informações e seu lado da força (Administrador ou usuário)";
  private String textNameField = "Nome:";
  private String textEmailField = "E-mail:";
  private String textPasswordField = "Senha:";
  private String textConfirmPasswordField = "Confirmar senha:";
  private JRadioButton radioAdmin;
  private JRadioButton radioUser;

  /**
   * Construtor para tela de cadastro
   */
  public SignupUserScreen(){
    setSize(1500, 900);
    setResizable(false);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    File file = new File(signupImage);
    String pathImage = file.getAbsolutePath();
    setContentPane(new JLabel(new ImageIcon(pathImage)));

    JLabel title = new JLabel(textTitle);
    title.setBounds(300, 20, 300, 30);
    title.setFont(new Font("Dialog", Font.BOLD, 30));
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setForeground(Color.white);
    UIManager.put("Label.font", title);
    add(title);

    JLabel subInfo = new JLabel(textSubInfo);
    subInfo.setBounds(50,150,850,25);
    subInfo.setFont(new Font("Dialog", Font.PLAIN, 20));
    subInfo.setForeground(Color.white);
    add(subInfo);

    radioAdmin = new JRadioButton("Administrador");
    radioAdmin.setBounds(300,250,150,25);
    radioAdmin.setBackground(new Color(0,0,0,0));
    radioAdmin.setForeground(Color.white);
    radioAdmin.setSelected(true);
    radioAdmin.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        radioAdmin.setSelected(true);
        radioUser.setSelected(false);
      }
    });
    add(radioAdmin);

    radioUser = new JRadioButton("Usuário");
    radioUser.setBounds(500,250,150,25);
    radioUser.setBackground(new Color(0,0,0,0));
    radioUser.setForeground(Color.white);
    radioUser.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        radioAdmin.setSelected(false);
        radioUser.setSelected(true);
      }
    });
    add(radioUser);

    JLabel nameField = new JLabel(textNameField);
    nameField.setBounds(200, 303, 200, 17);
    nameField.setFont(new Font("Dialog", Font.PLAIN, 15));
    nameField.setHorizontalAlignment(SwingConstants.CENTER);
    nameField.setForeground(Color.white);
    add(nameField);
    JTextField nameInput = new JTextField();
    nameInput.setBounds(340, 300, 300, 25);
    add(nameInput);

    JLabel emailField = new JLabel(textEmailField);
    emailField.setBounds(200, 353, 200, 17);
    emailField.setFont(new Font("Dialog", Font.PLAIN, 15));
    emailField.setHorizontalAlignment(SwingConstants.CENTER);
    emailField.setForeground(Color.white);
    add(emailField);
    JTextField emailInput = new JTextField();
    emailInput.setBounds(340, 350, 300, 25);
    add(emailInput);

    JLabel passwordField = new JLabel(textPasswordField);
    passwordField.setBounds(200, 403, 200, 17);
    passwordField.setFont(new Font("Dialog", Font.PLAIN, 15));
    passwordField.setHorizontalAlignment(SwingConstants.CENTER);
    passwordField.setForeground(Color.white);
    add(passwordField);
    JPasswordField passwordInput = new JPasswordField();
    passwordInput.setBounds(340, 400, 300, 25);
    add(passwordInput);

    JLabel confirmPassField = new JLabel(textConfirmPasswordField);
    confirmPassField.setBounds(165, 453, 200, 17);
    confirmPassField.setFont(new Font("Dialog", Font.PLAIN, 15));
    confirmPassField.setHorizontalAlignment(SwingConstants.CENTER);
    confirmPassField.setForeground(Color.white);
    add(confirmPassField);
    JPasswordField confirmPassInput = new JPasswordField();
    confirmPassInput.setBounds(340, 450, 300, 25);
    add(confirmPassInput);

    JButton buttonSignup = new JButton("Cadastrar");
    buttonSignup.setBounds(400,520, 150,25);
    buttonSignup.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        String name = nameInput.getText();
        String email = emailInput.getText();
        String password = new String(passwordInput.getPassword());
        String confirmPassword = new String(confirmPassInput.getPassword());
        String category = radioAdmin.isSelected() ? "admin" : "user";
        if(name.length() == 0 || email.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){
          JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
        } else {
          if(password.equals(confirmPassword)){
            requestSignup(name, email, password, category);
          } else {
            JOptionPane.showMessageDialog(null, "Por favor, o campo senha precisa ser igual ao campo confirmar senha.");
          }
        }
      }
    });
    add(buttonSignup);

    JButton buttonLogin = new JButton("Login");
    buttonLogin.setBounds(1380,10,90,30);
    buttonLogin.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        dispose();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
      }
    });
    add(buttonLogin);
  }

  /**
   * Método que criar usuário no banco de dados
   * @param name Nome do usuário
   * @param email Email do usuário
   * @param password Senha do usuário
   * @param category Categoria do usuário (Admin, user)
   */
  public void requestSignup(String name, String email, String password, String category){
    Database database = new Database();
    Boolean result = database.createUser(name,email,password,category);
    if(result){
      dispose();
      LoginScreen loginScreen = new LoginScreen();
      loginScreen.setVisible(true);
    } else {
      JOptionPane.showMessageDialog(null, "Ooops! Ocorreu um erro para criar seu usuário, tente novamente.");
    }
  }
}
