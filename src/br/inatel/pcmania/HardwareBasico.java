package br.inatel.pcmania;

class HardwareBasico {
  private String nome;
  private float capacidade;

  public HardwareBasico(String nomeProcessador, float capacidade, int armazenamentoGB, int memoriaRamGB){
    this.nome = nomeProcessador + " - " + armazenamentoGB + " GB de HD - " + memoriaRamGB + " de Memória RAM";
    this.capacidade = capacidade;
  }

  public String getNome(){
    return nome;
  }

  public float getCapacidade(){
    return capacidade;
  }
}