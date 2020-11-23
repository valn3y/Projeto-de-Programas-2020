package screens.Admin;

import skywalkerDB.UserRepository;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import skywalkerDB.*;
import screens.Login.*;

/**
 * Classe MainAdminScreen - Classe tela principal do administrador.
* @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class MainAdminScreen extends JFrame {
  /** Constantes utilizadas em texto do sistema */
  private String stormImage = "admin.jpg";
  private String titleFieldTypeProduct = "Armazenamento:";
  private String titleFieldAddress = "Endereço:";
  private String titleFieldWidth = "Comp.:";
  private String titleFieldHeight = "Alt.:";
  private String titleFieldDepth = "Profund.:";
  private String titleFieldPrice = "Preço:";
  private String titleFieldStartDate = "Início:";
  private String titleFieldEndDate = "Fim:";
  private String titleFieldOptions = "Opc.:";

  Database database;
  private ArrayList<LocalRepository> locals;

  /**
   * Construtor da classe, renderiza a tela de usuário
   * @param user Objeto usuário
   */
  public MainAdminScreen(UserRepository user) {
    setSize(1500, 900);
    setResizable(false);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    File file = new File(stormImage);
    String pathImage = file.getAbsolutePath();
    setContentPane(new JLabel(new ImageIcon(pathImage)));

    database = new Database();
    locals = database.getLocalByAdmin(user.getId());

    JLabel titleAvailable = new JLabel("Disponíveis");
    titleAvailable.setBounds(50, 180, 100, 20);
    titleAvailable.setFont(new Font("Dialog", Font.BOLD, 15));
    titleAvailable.setForeground(Color.white);
    add(titleAvailable);

    JLabel titleUnavailable = new JLabel("Alugados");
    titleUnavailable.setBounds(1000, 180, 100, 20);
    titleUnavailable.setFont(new Font("Dialog", Font.BOLD, 15));
    titleUnavailable.setForeground(Color.white);
    add(titleUnavailable);

    panelGridLocalsAvailables(locals);
    panelGridLocalsUnavailable(locals);

    JButton buttonCreateLocal = new JButton("Criar Local");
    buttonCreateLocal.setBounds(50, 10, 120, 30);
    buttonCreateLocal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SignupLocal signupLocal = new SignupLocal(user.getId());
        signupLocal.setVisible(true);
      }
    });
    add(buttonCreateLocal);

    JButton buttonLogout = new JButton("Sair");
    buttonLogout.setBounds(1410, 10, 70, 30);
    buttonLogout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.setVisible(true);
      }
    });
    add(buttonLogout);
  }

  /**
   * Método panelGridLocalsAvailables renderiza um painel com scroll dos lugares disponíveis
   * @param locals Lista de locais
   */
  private void panelGridLocalsAvailables(ArrayList<LocalRepository> locals) {
    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.setBackground(new Color(0, 0, 0, 0));
    for (int i = 0; i < locals.size(); i++) {
      if (locals.get(i).getAvailable()) {
        panel.add(renderCard(false, locals.get(i).getCategory(), locals.get(i).getAddress(), locals.get(i).getWidth(),
            locals.get(i).getHeight(), locals.get(i).getDepth(), locals.get(i).getPrice(), locals.get(i).getId()));
      }
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setBounds(50, 200, 820, 600);
    scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

    add(scrollPane);
  }

  /**
   * Método panelGridLocalsUnavailable renderiza um painel com scroll dos lugares indisponíveis
   * @param locals Lista de locais
   */
  private void panelGridLocalsUnavailable(ArrayList<LocalRepository> myLocals) {
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBackground(new Color(0, 0, 0, 0));
    for (int i = 0; i < myLocals.size(); i++) {
      if (!locals.get(i).getAvailable()) {
        panel.add(renderCard(true, myLocals.get(i).getCategory(), myLocals.get(i).getAddress(),
            myLocals.get(i).getWidth(), myLocals.get(i).getHeight(), myLocals.get(i).getDepth(),
            myLocals.get(i).getPrice(), myLocals.get(i).getId()));
      }
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setBounds(1000, 200, 420, 600);
    scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

    add(scrollPane);
  }

  /**
   * Método renderCard renderiza os componentes cards
   * @param details Dtalhes de um local
   * @param typeProduct Tipo do local Conteiner, Quarto e etc...
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   * @return JPanel
   */
  private JPanel renderCard(boolean details, String typeProduct, String address, int width, int height, int depth,
      int price, int idLocal) {

    JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(400, 180));
    card.setLayout(null);
    card.setBackground(Color.black);
    Border border = new LineBorder(Color.white, 1, true);
    card.setBorder(border);

    JButton buttonMore = new JButton("...");
    buttonMore.setBounds(350, 10, 30, 20);
    buttonMore.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ManagerLocal managerLocal = new ManagerLocal(typeProduct, address, width, height, depth, price, idLocal);
        managerLocal.setVisible(true);
      }
    });
    card.add(buttonMore);

    JLabel titleType = new JLabel(titleFieldTypeProduct);
    titleType.setBounds(10, 10, 140, 15);
    titleType.setFont(new Font("Dialog", Font.BOLD, 12));
    titleType.setForeground(Color.white);
    card.add(titleType);
    JLabel textTypeProduct = new JLabel(typeProduct);
    textTypeProduct.setBounds(140, 10, 250, 15);
    textTypeProduct.setForeground(Color.white);
    card.add(textTypeProduct);

    JLabel titleAddress = new JLabel(titleFieldAddress);
    titleAddress.setBounds(10, 40, 80, 15);
    titleAddress.setFont(new Font("Dialog", Font.BOLD, 12));
    titleAddress.setForeground(Color.white);
    card.add(titleAddress);
    JLabel textAddress = new JLabel(address);
    textAddress.setBounds(90, 40, 300, 15);
    textAddress.setForeground(Color.white);
    card.add(textAddress);

    JLabel titleWidth = new JLabel(titleFieldWidth);
    titleWidth.setBounds(10, 70, 50, 15);
    titleWidth.setFont(new Font("Dialog", Font.BOLD, 12));
    titleWidth.setForeground(Color.white);
    card.add(titleWidth);
    JLabel textWidth = new JLabel(width + "m");
    textWidth.setBounds(60, 70, 40, 15);
    textWidth.setForeground(Color.white);
    card.add(textWidth);

    JLabel titleHeight = new JLabel(titleFieldHeight);
    titleHeight.setBounds(120, 70, 40, 15);
    titleHeight.setFont(new Font("Dialog", Font.BOLD, 12));
    titleHeight.setForeground(Color.white);
    card.add(titleHeight);
    JLabel textHeight = new JLabel(height + "m");
    textHeight.setBounds(150, 70, 40, 15);
    textHeight.setForeground(Color.white);
    card.add(textHeight);

    JLabel titleDepth = new JLabel(titleFieldDepth);
    titleDepth.setBounds(200, 70, 80, 15);
    titleDepth.setFont(new Font("Dialog", Font.BOLD, 12));
    titleDepth.setForeground(Color.white);
    card.add(titleDepth);
    JLabel textDepth = new JLabel(depth + "m");
    textDepth.setBounds(265, 70, 40, 15);
    textDepth.setForeground(Color.white);
    card.add(textDepth);

    JLabel titlePrice = new JLabel(titleFieldPrice);
    titlePrice.setBounds(10, 150, 50, 15);
    titlePrice.setFont(new Font("Dialog", Font.BOLD, 12));
    titlePrice.setForeground(Color.white);
    card.add(titlePrice);
    JLabel textPrice = new JLabel("R$" + price);
    textPrice.setBounds(60, 150, 70, 15);
    textPrice.setForeground(Color.white);
    card.add(textPrice);

    if (details) {
      database = new Database();
      RentRepository rent = database.getRents(idLocal);
      String optional = "";
      if (rent.getSecurity()) {
        optional += "Seguro ";
      }

      if (rent.getKeyExtra()) {
        optional += "Chave Ex ";
      }

      if (rent.getControlWether()) {
        optional += "Controle C ";
      }

      JLabel titleStartDate = new JLabel(titleFieldStartDate);
      titleStartDate.setBounds(120, 110, 70, 15);
      titleStartDate.setFont(new Font("Dialog", Font.BOLD, 12));
      titleStartDate.setForeground(Color.white);
      card.add(titleStartDate);
      JLabel textStartDate = new JLabel(rent.getStartDate());
      textStartDate.setBounds(170, 110, 100, 15);
      textStartDate.setForeground(Color.white);
      card.add(textStartDate);

      JLabel titleEndDate = new JLabel(titleFieldEndDate);
      titleEndDate.setBounds(120, 130, 70, 15);
      titleEndDate.setFont(new Font("Dialog", Font.BOLD, 12));
      titleEndDate.setForeground(Color.white);
      card.add(titleEndDate);
      JLabel textEndDate = new JLabel(rent.getEndDate());
      textEndDate.setBounds(160, 130, 100, 15);
      textEndDate.setForeground(Color.white);
      card.add(textEndDate);

      JLabel titleOptions = new JLabel(titleFieldOptions);
      titleOptions.setBounds(120, 150, 70, 15);
      titleOptions.setFont(new Font("Dialog", Font.BOLD, 12));
      titleOptions.setForeground(Color.white);
      card.add(titleOptions);
      JLabel textOptions = new JLabel(optional);
      textOptions.setBounds(170, 150, 250, 15);
      textOptions.setForeground(Color.white);
      card.add(textOptions);
    }

    return card;
  }
}