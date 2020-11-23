public class AstromechMain {
  public static void main(String[] args) {
    Mestre mestre = new Mestre();
    Conexao conexao = new Conexao();
    Sensor sensor = new Sensor();

    Astromech astromech = new Astromech("", mestre, sensor, conexao);
    astromech.getDescricao();
  }
}
