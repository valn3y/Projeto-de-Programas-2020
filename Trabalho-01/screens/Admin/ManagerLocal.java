package screens.Admin;

import javax.swing.*;

import skywalkerDB.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Classe ManagerLocal - Tela de para editar e remover locais.
 * @author Valney Marinho do Nascimento Júnior &lt;neymarinho.junior@gmail.com
 * @version 1.0, 2020-12-03
 */
public class ManagerLocal extends JFrame {
  /** Constantes para o componentes */
  private String[] stocks = { "Guarda-Volumes", "Contêiner", "Quarto", "Galpão" };
  Database database;

  /**
   * Construtor com a renderização da tela
   * @param stock Tipo de local Conteiner, Quarto e etc...
   * @param address Endereço do local
   * @param width Comprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   */
  public ManagerLocal(String stock, String address, Integer width, Integer height, Integer depth, Integer price, int idLocal){
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
    for(int i = 0; i < stocks.length; i++){
      if(stocks[i].equals(stock)){
        fieldStock.setSelectedIndex(i);
      }
    }
    add(fieldStock);

    JLabel titleAddress = new JLabel("Endereço:");
    titleAddress.setBounds(20, 60, 100, 15);
    titleAddress.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleAddress);
    JTextField fieldAddress = new JTextField(address);
    fieldAddress.setBounds(100, 60, 320, 20);
    add(fieldAddress);

    JLabel titleWidth = new JLabel("Comprimento (m):");
    titleWidth.setBounds(20, 100, 180, 15);
    titleWidth.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleWidth);
    JTextField fieldWidth = new JTextField(width.toString());
    fieldWidth.setBounds(150, 100, 50, 20);
    add(fieldWidth);

    JLabel titleHeight = new JLabel("Altura (m):");
    titleHeight.setBounds(20, 140, 150, 15);
    titleHeight.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleHeight);
    JTextField fieldHeight = new JTextField(height.toString());
    fieldHeight.setBounds(100, 140, 50, 20);
    add(fieldHeight);

    JLabel titleDepth = new JLabel("Profundidade (m):");
    titleDepth.setBounds(20, 180, 180, 15);
    titleDepth.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titleDepth);
    JTextField fieldDepth = new JTextField(depth.toString());
    fieldDepth.setBounds(150, 180, 50, 20);
    add(fieldDepth);

    JLabel titlePrice = new JLabel("Preço (R$):");
    titlePrice.setBounds(20, 220, 100, 15);
    titlePrice.setFont(new Font("Dialog", Font.BOLD, 12));
    add(titlePrice);
    JTextField fieldPrice = new JTextField(price.toString());
    fieldPrice.setBounds(100, 220, 50, 20);
    add(fieldPrice);

    JLabel titleOptions = new JLabel("**Os opcionais serão ofertados os padrões do sistema.**");
    titleOptions.setBounds(20, 260, 380, 15);
    titleOptions.setFont(new Font("Dialog", Font.ITALIC, 12));
    add(titleOptions);

    JButton cancelCreate = new JButton("Cancelar");
    cancelCreate.setBounds(100, 350, 120, 20);
    cancelCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
    add(cancelCreate);

    JButton buttonCreateLocal = new JButton("Atualizar");
    buttonCreateLocal.setBounds(280, 350, 120, 20);
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
          requestUpdate(stock, address, Integer.parseInt(width), Integer.parseInt(height), Integer.parseInt(depth),
              Integer.parseInt(price), idLocal);
        }
      }
    });
    add(buttonCreateLocal);

    JButton buttonDeleteLocal = new JButton("Deletar");
    buttonDeleteLocal.setBounds(190,400, 120, 20);
    buttonDeleteLocal.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e){
        requestDelete(idLocal);
      }
    });
    add(buttonDeleteLocal);
  }

  /**
   * Método que faz requisição para o  banco para atualizar um local
   * @param category Tipo de local COnteiner, Quarto e etc...
   * @param address Endereço do local
   * @param width COmprimento do local
   * @param height Altura do local
   * @param depth Profundidade do local
   * @param price Preço do local
   * @param idLocal Id do local
   */
  public void requestUpdate(String category, String address, int width, int height, int depth, int price, int idLocal){
    try{
      database = new Database();
      boolean request = database.updateLocal(category, address, width, height, depth, price, idLocal);
      if(request) {
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Ooops, problema em atualizar um produto, certifique-se se os campos estão preenchidos corretamente, dimensões e preços devem ser números.");
      }
    } catch (Error e){
      System.out.println(e);
      JOptionPane.showMessageDialog(null, "Ooops, ocorreu algum problema.");
    }
  }

  /**
   * Método que faz requisião para o banco para deletar um local
   * @param idLocal Id do local
   */
  public void requestDelete(int idLocal) {
    try {
      database = new Database();
      boolean request = database.deleteLocal(idLocal);
      if(request){
        dispose();
      } else {
        JOptionPane.showMessageDialog(null, "Ooops, problema em deletar o local.");
      }
    } catch(Error e){
      System.out.println(e);
    }
  }
}
