public class Astromech {
  String modelo;
  Mestre mestre;
  Sensor sensor;
  Conexao conexao;

  Astromech(String modelo, Mestre mestre, Sensor sensor, Conexao conexao) {
    this.modelo = modelo;
    this.mestre = mestre;
    this.sensor = sensor;
    this.conexao = conexao;
  }

  public String getDescricao() {
    return "Astromech modelo " + modelo + "." + mestre.getDescricao() + " " + sensor.getDescricao() + " "
        + conexao.getDescricao();
  }
}
