package br.inatel.pcmania.hardware_basico;

import br.inatel.pcmania.formatadores.Formatadores;

public class HardwareBasico {
  private String nome;
  private float capacidade;

  public HardwareBasico(String nomeProcessador, float capacidade, int armazenamentoGB, int memoriaRamGB){
    this.nome = nomeProcessador + " - " + armazenamentoGB + " - " + Formatadores.formatarMemoria(armazenamentoGB) + "de HD - " + Formatadores.formatarMemoria(memoriaRamGB) + " de Memória RAM";
    this.capacidade = capacidade;
  }

  public String getNome(){
    return nome;
  }

  public float getCapacidade(){
    return capacidade;
  }
}