public class Conexao {
  String tipoPorta;
  int idProtocolo;
  int taxaTransmissao;

  Conexao() {
    tipoPorta = "";
    idProtocolo = 0;
    taxaTransmissao = 0;
  }

  Conexao(String tipoPorta, int idProtocolo, int taxaTransmissao) {
    this.tipoPorta = tipoPorta;
    this.idProtocolo = idProtocolo;
    this.taxaTransmissao = taxaTransmissao;
  }

  public double getTaxaMBps() {
    return taxaTransmissao / 1024;
  }

  public String getProtocoloString() {
    if (idProtocolo == 1) {
      return "Rotoscope";
    }
    if (idProtocolo == 2) {
      return "Acustico";
    }
    if (idProtocolo == 3) {
      return "Radio";
    }
    return "Outros";
  }

  public String getDescricao() {
    return "Conexao: tipoPorta=" + tipoPorta + ", protocolo=" + getProtocoloString() + ", taxaTransmissao="
        + getTaxaMBps() + "MBps.";
  }
}
