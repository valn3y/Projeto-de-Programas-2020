package screens.Admin;

import javax.swing.*;

import skywalkerDB.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe SignupLocal - Tela de para cadastrar locais.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class SignupLocal extends JFrame{
  /** Constantes para o componentes */
  private String[] stocks = { "Guarda-Volumes", "Contêiner", "Quarto", "Galpão" };
  Database database;

  /**
   * Construtor para renderizar a tela de cadastro
   * @param idUser Id do usuário
   */
  public SignupLocal(int idUser) {
    setSize(500, 500);
    setResizable(false);
    setLayout(null);
    setUndecorated(false);
    setLocationRelativeTo(null);

    JLabel titleStock = new JLabel("Armazenamento:");
    titleStock.setBounds(20, 20, 140, 15);
    titleStock.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleStock);
    JComboBox<String> fieldStock = new JComboBox<String>(stocks);
    fieldStock.setBounds(150, 20, 160, 20);
    add(fieldStock);

    JLabel titleAddress = new JLabel("Endereço:");
    titleAddress.setBounds(20, 60, 100, 15);
    titleAddress.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleAddress);
    JTextField fieldAddress = new JTextField();
    fieldAddress.setBounds(100, 60, 320, 20);
    add(fieldAddress);

    JLabel titleWidth = new JLabel("Comprimento (m):");
    titleWidth.setBounds(20, 100, 180, 15);
    titleWidth.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleWidth);
    JTextField fieldWidth = new JTextField();
    fieldWidth.setBounds(150, 100, 50, 20);
    add(fieldWidth);

    JLabel titleHeight = new JLabel("Altura (m):");
    titleHeight.setBounds(20, 140, 150, 15);
    titleHeight.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleHeight);
    JTextField fieldHeight = new JTextField();
    fieldHeight.setBounds(100, 140, 50, 20);
    add(fieldHeight);

    JLabel titleDepth = new JLabel("Profundidade (m):");
    titleDepth.setBounds(20, 180, 180, 15);
    titleDepth.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleDepth);
    JTextField fieldDepth = new JTextField();
    fieldDepth.setBounds(150, 180, 50, 20);
    add(fieldDepth);

    JLabel titlePrice = new JLabel("Preço (R$):");
    titlePrice.setBounds(20, 220, 100, 15);
    titlePrice.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titlePrice);
    JTextField fieldPrice = new JTextField();
    fieldPrice.setBounds(100, 220, 50, 20);
    add(fieldPrice);

    JLabel titleOptions = new JLabel("**Os opcionais serão ofertados os padrões do sistema.**");
    titleOptions.setBounds(20, 260, 380, 15);
    titleOptions.setFont(new Font("Dialog", Font.ITALIC, 12));
    add(titleOptions);

    JButton cancelCreate = new JButton("Cancelar");
    cancelCreate.setBounds(100, 400, 120, 20);
    cancelCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    add(cancelCreate);

    JButton buttonCreateLocal = new JButton("Criar");
    buttonCreateLocal.setBounds(280, 400, 120, 20);
    buttonCreateLocal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String stock = fieldStock.getSelectedItem().toString();
        String address = fieldAddress.getText();
        String width = fieldWidth.getText();
        String height = fieldHeight.getText();
        String depth = fieldDepth.getText();
        String price = fieldPrice.getText();

        if (address.length() == 0 || width.length() == 0 || height.length() == 0 || depth.length() == 0
            || price.length() == 0) {
          JOptionPane.showMessageDialog(null, "Por favor, informe todos os campos.");
        } else {
          requestCreate(stock, address, Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth),
              Integer.parseInt(price), idUser);
        }
      }
    });
    add(buttonCreateLocal);
  }

  /**
   * Método que faz requisição para o banco para criar um local
   * @param category Categoria do local Conteiner, Quarto e etc...
   * @param address Endereço do local
   * @param width COmprimento do local
   * @param height Altura do local
   * @param depth Profundiadae do local
   * @param price Preço do local
   * @param idUser Id do Usuário
   */
  public void requestCreate(String category, String address, int width, int height, int depth, int price, int idUser) {
    try {
      database = new Database();
      boolean result = database.createLocal(category, address, width, height, depth, price, true, idUser);
      if(result){
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Ooops, problema em cadastrar um produto, certifique-se se os campos estão preenchidos corretamente, dimensões e preços devem ser números.");
      }
    } catch (Error e) {
      System.out.println(e);
      JOptionPane.showMessageDialog(null, "Ooops, ocorreu algum problema.");
    }
  }
}
