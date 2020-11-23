public class Sensor {
  String cor;
  double resolucao;
  int framesPorSegundo;

  Sensor() {
    cor = "";
    resolucao = 0;
    framesPorSegundo = 0;
  }

  Sensor(String cor, double resolucao, int framesPorSegundo) {
    this.cor = cor;
    this.resolucao = resolucao;
    this.framesPorSegundo = framesPorSegundo;
  }

  public double getMPixelsPorSegundo() {
    return resolucao * framesPorSegundo;
  }

  public String getDescricao() {
    return "Sensor: cor=" + cor + ", resolucao=" + resolucao + "Mp, framesPorSegundo=" + framesPorSegundo
        + "fps, mPixelsPorSegundo=" + getMPixelsPorSegundo() + "Mpps.";
  }
}
