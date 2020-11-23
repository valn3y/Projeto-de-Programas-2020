package screens.Client;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import screens.Login.*;
import skywalkerDB.*;

/**
 * Classe MainClientScreen - Classe que contem a tela principal do usuário cliente.
* @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class MainClientScreen extends JFrame {
  /** Constantes utilizadas para informações dos componentes */
  private String textTitle = "Lugares Disponíveis para o seu negócio!";
  private String stormImage = "storm.jpg";
  private JButton buttonLogout;

  private String titleFieldTypeProduct = "Armazenamento:";
  private String titleFieldAddress = "Endereço:";
  private String titleFieldWidth = "Comp.:";
  private String titleFieldHeight = "Alt.:";
  private String titleFieldDepth = "Profund.:";
  private String titleFieldPrice = "Preço:";
  private String textButtonRent = "Alugar";

  Database database;
  private ArrayList<LocalRepository> locals;
  private ArrayList<LocalRepository> myLocals;

  /**
   * COnstrutor da classe que renderiza a tela do cliente
   * @param user Objeto usuário
   */
  public MainClientScreen(UserRepository user) {
    setSize(1500, 900);
    setResizable(false);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    File file = new File(stormImage);
    String pathImage = file.getAbsolutePath();
    setContentPane(new JLabel(new ImageIcon(pathImage)));

    database = new Database();
    locals = database.getLocals();
    myLocals = database.getMyLocals(user.getId());

    JLabel title = new JLabel(textTitle);
    title.setBounds(20, 10, 740, 37);
    title.setFont(new Font("Dialog", Font.BOLD, 32));
    UIManager.put("Label.font", title);
    add(title);

    JLabel titleLocals = new JLabel("Meus lugares");
    titleLocals.setBounds(1100, 160, 250, 25);
    titleLocals.setFont(new Font("Dialog", Font.BOLD, 20));
    titleLocals.setForeground(Color.white);
    add(titleLocals);

    panelGridRents(locals, user);
    panelGridMyRents(myLocals, user);

    buttonLogout = new JButton("Sair");
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
   * Método panelGridRents renderiza um painel com scroll dos lugares disponíveis
   * @param locals Lista de locais
   * @param user Objeto do usuário
   */
  private void panelGridRents(ArrayList<LocalRepository> locals, UserRepository user) {
    JPanel panel = new JPanel(new GridLayout(0, 2));
    panel.setBackground(new Color(0, 0, 0, 0));
    for (int i = 0; i < locals.size(); i++) {
      panel.add(renderCard(true, locals.get(i).getCategory(), locals.get(i).getAddress(), locals.get(i).getWidth(),
          locals.get(i).getHeight(), locals.get(i).getDepth(), locals.get(i).getPrice(), locals.get(i).getId(),
          user.getId()));
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setBounds(50, 200, 820, 600);
    scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

    add(scrollPane);
  }

  /**
   * Método panelGridMyRents renderiza um painel com scroll dos lugares alugados
   * @param myLocals Lista de locais
   * @param user Objeto do usuário
   */
  private void panelGridMyRents(ArrayList<LocalRepository> myLocals, UserRepository user) {
    JPanel panel = new JPanel(new GridLayout(0, 1));
    panel.setBackground(new Color(0, 0, 0, 0));
    for (int i = 0; i < myLocals.size(); i++) {
      panel.add(renderCard(false, myLocals.get(i).getCategory(), myLocals.get(i).getAddress(),
          myLocals.get(i).getWidth(), myLocals.get(i).getHeight(), myLocals.get(i).getDepth(),
          myLocals.get(i).getPrice(), myLocals.get(i).getId(), user.getId()));
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    scrollPane.setBounds(1000, 200, 420, 600);
    scrollPane.getViewport().setBackground(new Color(0, 0, 0, 0));

    add(scrollPane);
  }

  /**
   * Método renderCard renderiza os componentes cards
   * @param renderButton COndicional para renderizar button de aluguel
   * @param typeProduct Tipo de produto conteiner, quarto e etc...
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   * @param idTenant Id do inquilino
   * @return JPanel
   */
  private JPanel renderCard(boolean renderButton, String typeProduct, String address, int width, int height, int depth,
      int price, int idLocal, int idTenant) {
    JPanel card = new JPanel();
    card.setPreferredSize(new Dimension(400, 180));
    card.setLayout(null);
    card.setBackground(Color.black);
    Border border = new LineBorder(Color.white, 1, true);
    card.setBorder(border);

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

    if (renderButton) {
      JButton buttonGoRent = new JButton(textButtonRent);
      buttonGoRent.setBounds(270, 140, 100, 30);
      buttonGoRent.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          Rent rent = new Rent(typeProduct, address, width, height, depth, price, idLocal, idTenant);
          rent.setVisible(true);
        }
      });
      card.add(buttonGoRent);
    }

    return card;
  }
}
