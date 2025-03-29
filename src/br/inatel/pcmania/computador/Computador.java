package br.inatel.pcmania.computador;

import br.inatel.pcmania.memoria_usb.MemoriaUSB;
import br.inatel.pcmania.sistema_operacional.SistemaOperacional;
import br.inatel.pcmania.hardware_basico.HardwareBasico;

public class Computador {
  private String marca;
  private float preco;

  private MemoriaUSB[] memoriasUsb;

  private SistemaOperacional sistemaOperacional;
  private HardwareBasico hardwareBasico;

  public Computador(
    String marca, 
    float preco, 
    String nomeProcessador, 
    int capacidadeProcessador,
    int memoriaRamGB,
    int armazenamentoHDGB,
    String nomeSistemaOperacional,
    int tipoSistemaOperacional
  ){
    this.marca = marca;
    this.preco = preco;

    hardwareBasico = new HardwareBasico(nomeProcessador, capacidadeProcessador, armazenamentoHDGB, memoriaRamGB);
    sistemaOperacional = new SistemaOperacional(nomeSistemaOperacional, tipoSistemaOperacional);

    memoriasUsb = new MemoriaUSB[1];
  }

  public void addMemoriaUSB(MemoriaUSB musb){
    if(memoriasUsb.length == 1){
      System.err.println("O PC já possui uma memória USB!");
      return;
    }

    memoriasUsb[1] = musb;
  }

  public void mostraPCConfigs(){
    System.out.println("Informações Gerais: " + hardwareBasico.getNome() + " - Clock Processador: " + hardwareBasico.getCapacidade() + "Mhz");
    System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

    if(memoriasUsb.length == 1) {
      System.out.println("Acompanha: Pen Drive " + memoriasUsb[1].getNome() + " " + memoriasUsb[1].getCapacidade());
    }
  }
}