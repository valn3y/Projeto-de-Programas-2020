/**
 * Classe SessaoJediMain - Executa todas as classes sendo instanciadas nesse
 * arquivo, são elas: IniciadoJedi, SessaoJedi e TreinadorJedi
 * 
 * @author Valney Marinho &lt;valney.junior@icomp.ufam.edu.br&gt;
 * @version 0.1, 2020-09-29
 */
public class SessaoJediMain {
  public static void main(String[] args) {
    IniciadoJedi starter = new IniciadoJedi("Ashla", "Togruta", -29);
    IniciadoJedi starter2 = new IniciadoJedi("Katooni", "Tholothian", 23);
    IniciadoJedi starter3 = new IniciadoJedi("Liam", "Human", 12);
    TreinadorJedi trainer = new TreinadorJedi("Grão-Mestre", "Fae Coven");
    SessaoJedi sessaoJedi = new SessaoJedi("Uso da força", trainer);
    sessaoJedi.addIniciado(starter);
    sessaoJedi.addIniciado(starter2);
    sessaoJedi.addIniciado(starter3);
    System.out.println(sessaoJedi.getDescricao());
  }
}
