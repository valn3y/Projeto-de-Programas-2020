package screens.Client;

import java.text.ParseException;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;

import skywalkerDB.*;

/**
 * Classe Rent - Classe que contem a tela de aluguel.
 * 
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class Rent extends JFrame {
  /** Constantes utilizadas para as informações dos componentes */
  private String titleFieldStartDate = "Data de início:";
  private String titleFieldEndDate = "Data de término:";
  private String titleFieldOptional = "Opcionais:";
  private String titleCheckSecurity = "Seguro";
  private String titleCheckKeyExtra = "Chave extra";
  private String titleCheckControlWeather = "Controle Climático";
  private String titleButtonConfirm = "Confirmar";

  private String titleFieldTypeProduct = "Armazenamento:";
  private String titleFieldAddress = "Endereço:";
  private String titleFieldWidth = "Comp.:";
  private String titleFieldHeight = "Alt.:";
  private String titleFieldDepth = "Profund.:";
  private String titleFieldPrice = "Preço:";

  private Database database;

  /**
   * Construtor que renderiza a tela para executar um aluguel
   * @param typeProduct Tipo de produto Conteiner, quarto e etc...
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   * @param idTenant Id do inquilino
   */
  public Rent(String typeProduct, String address, int width, int height, int depth, int price, int idLocal,
      int idTenant) {

    setSize(500, 500);
    setResizable(false);
    setLayout(null);
    setUndecorated(false);
    setLocationRelativeTo(null);

    renderCard(typeProduct, address, width, height, depth, price);

    JLabel titleStartDate = new JLabel(titleFieldStartDate);
    titleStartDate.setBounds(20, 202, 120, 15);
    titleStartDate.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleStartDate);
    JFormattedTextField startDate = new JFormattedTextField(this.maskDate());
    startDate.setBounds(130, 200, 80, 20);
    add(startDate);

    JLabel titleEndDate = new JLabel(titleFieldEndDate);
    titleEndDate.setBounds(230, 202, 120, 15);
    titleEndDate.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleEndDate);
    JFormattedTextField endDate = new JFormattedTextField(this.maskDate());
    endDate.setBounds(360, 200, 80, 20);
    add(endDate);

    JLabel titleOptional = new JLabel(titleFieldOptional);
    titleOptional.setBounds(20, 250, 100, 15);
    titleOptional.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleOptional);

    JCheckBox checkSecurity = new JCheckBox(titleCheckSecurity);
    checkSecurity.setBounds(100, 247, 80, 20);
    add(checkSecurity);
    JCheckBox checkKeyExtra = new JCheckBox(titleCheckKeyExtra);
    checkKeyExtra.setBounds(180, 247, 110, 20);
    add(checkKeyExtra);
    JCheckBox checkControlWhether = new JCheckBox(titleCheckControlWeather);
    checkControlWhether.setBounds(290, 247, 180, 20);
    add(checkControlWhether);

    JButton buttonConfirm = new JButton(titleButtonConfirm);
    buttonConfirm.setBounds(180, 400, 150, 30);
    buttonConfirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String textStartDate = startDate.getText();
        String textEndDate = endDate.getText();
        if (textStartDate.equals("__/__/____") || textEndDate.equals("__/__/____")) {
          JOptionPane.showMessageDialog(null, "Por favor, informe as datas.");
        } else {
          String dateStart = parseDateSQL(textStartDate);
          String dateEnd = parseDateSQL(textEndDate);
          boolean security = checkSecurity.isSelected();
          boolean keyExtra = checkKeyExtra.isSelected();
          boolean controlWether = checkControlWhether.isSelected();
          requestRent(dateStart, dateEnd, security, keyExtra, controlWether, idLocal);
          requestChangeAvailable(idLocal, idTenant);
        }
      }
    });
    add(buttonConfirm);
  }

  /**
   * Método que renderiza componentes cards
   * @param typeProduct Tipo de produto Conteiner, quarto e etc...
   * @param address Endereço do local
   * @param width COmprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   */
  private void renderCard(String typeProduct, String address, int width, int height, int depth, int price) {
    JPanel card = new JPanel();
    card.setBounds(10, 10, 480, 140);
    card.setLayout(null);
    Border border = new LineBorder(Color.black, 4, true);
    card.setBorder(border);
    add(card);

    JLabel titleType = new JLabel(titleFieldTypeProduct);
    titleType.setBounds(10, 10, 140, 15);
    titleType.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titleType);
    JLabel textTypeProduct = new JLabel(typeProduct);
    textTypeProduct.setBounds(140, 10, 250, 15);
    card.add(textTypeProduct);

    JLabel titleAddress = new JLabel(titleFieldAddress);
    titleAddress.setBounds(10, 40, 80, 15);
    titleAddress.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titleAddress);
    JLabel textAddress = new JLabel(address);
    textAddress.setBounds(90, 40, 380, 15);
    card.add(textAddress);

    JLabel titleWidth = new JLabel(titleFieldWidth);
    titleWidth.setBounds(10, 70, 50, 15);
    titleWidth.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titleWidth);
    JLabel textWidth = new JLabel(width + "m");
    textWidth.setBounds(60, 70, 40, 15);
    card.add(textWidth);

    JLabel titleHeight = new JLabel(titleFieldHeight);
    titleHeight.setBounds(120, 70, 40, 15);
    titleHeight.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titleHeight);
    JLabel textHeight = new JLabel(height + "m");
    textHeight.setBounds(150, 70, 40, 15);
    card.add(textHeight);

    JLabel titleDepth = new JLabel(titleFieldDepth);
    titleDepth.setBounds(200, 70, 80, 15);
    titleDepth.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titleDepth);
    JLabel textDepth = new JLabel(depth + "m");
    textDepth.setBounds(265, 70, 40, 15);
    card.add(textDepth);

    JLabel titlePrice = new JLabel(titleFieldPrice);
    titlePrice.setBounds(10, 100, 50, 15);
    titlePrice.setFont(new Font("Dialog", Font.BOLD, 12));
    card.add(titlePrice);
    JLabel textPrice = new JLabel("R$" + price);
    textPrice.setBounds(60, 100, 70, 15);
    card.add(textPrice);
  }

  /**
   * Máscara para as datas
   * @return MaskFormatter
   */
  public MaskFormatter maskDate() {
    MaskFormatter date = null;
    try {
      date = new MaskFormatter("##/##/####");
      date.setPlaceholderCharacter('_');
    } catch (ParseException e) {
      System.err.println("Erro na formatação: " + e.getMessage());
    }
    return date;
  }

  /**
   * Parse para ajstar os dados para a inserção no banco
   * @param date Data informada
   * @return String Formato SQL
   */
  public String parseDateSQL(String date) {
    String[] arrayString = date.split("/");
    String newFormatDate = arrayString[2] + "-" + arrayString[1] + "-" + arrayString[0];
    return newFormatDate;
  }

  /**
   * Método que faz requisição para criar um aluguel
   * @param startDate Data de início
   * @param endDate Data de fim
   * @param security Opcional de seguro
   * @param keyExtra Opcional chave extra
   * @param controlWether Opcional controle climático
   * @param idLocal Id do local
   */
  public void requestRent(String startDate, String endDate, boolean security, boolean keyExtra, boolean controlWether,
      int idLocal) {
    try {
      database = new Database();
      boolean request = database.createRent(startDate, endDate, security, keyExtra, controlWether, idLocal);
      if (request) {
        dispose();
      } else {
        JOptionPane.showMessageDialog(null,
            "Não foi possível cadastrar, verifique se os dados fornecidos estão corretos e tente novamente.");
      }
    } catch (Error e) {
      System.out.println(e);
    }
  }

  /**
   * Método que faz requisição para mudar a disponibilidade de um local
   * @param idLocal Id do local
   * @param idTenant Id do inquilino
   */
  public void requestChangeAvailable(int idLocal, int idTenant) {
    try {
      database = new Database();
      database.changeAvailable(false, idLocal, idTenant);
    } catch (Error e) {
      System.out.println(e);
    }
  }
}