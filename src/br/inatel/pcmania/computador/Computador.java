package br.inatel.pcmania.computador;

import br.inatel.pcmania.formatadores.Formatadores;
import br.inatel.pcmania.hardware_basico.HardwareBasico;
import br.inatel.pcmania.memoria_usb.MemoriaUSB;
import br.inatel.pcmania.sistema_operacional.SistemaOperacional;

public class Computador {
  private String marca;
  private float preco;

  private MemoriaUSB[] memoriasUsb;

  private SistemaOperacional sistemaOperacional;
  private HardwareBasico[] hardwaresBasicos;

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

    HardwareBasico processador = new HardwareBasico(nomeProcessador, capacidadeProcessador);
    HardwareBasico memoriaRam = new HardwareBasico("Memória Ram", memoriaRamGB);
    HardwareBasico hd = new HardwareBasico("HD", armazenamentoHDGB);

    this.hardwaresBasicos = new HardwareBasico[3];

    this.hardwaresBasicos[0] = processador;
    this.hardwaresBasicos[1] = memoriaRam;
    this.hardwaresBasicos[2] = hd;

    sistemaOperacional = new SistemaOperacional(nomeSistemaOperacional, tipoSistemaOperacional);

    memoriasUsb = new MemoriaUSB[1];
  }

  public float getPreco(){
    return preco;
  }

  public void addMemoriaUSB(MemoriaUSB musb){
    if (memoriasUsb[0] != null) {
        System.err.println("O PC já possui uma memória USB!");
        return;
    }

    memoriasUsb[0] = musb;
  }

  public void mostraPCConfigs(){
    System.out.println("Informações Gerais");
    System.out.println("Marca: " + marca);
    System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + "(" + sistemaOperacional.getTipo() + ")");
    System.out.println("Preço: " + preco);

    HardwareBasico processador = hardwaresBasicos[0];
    HardwareBasico memoriaRam = hardwaresBasicos[1];
    HardwareBasico hd = hardwaresBasicos[2];

    System.out.println("Processador: " + processador.getNome() + " - Capacidade: " + Formatadores.formatarMemoria(processador.getCapacidade()));
    System.out.println(memoriaRam.getNome() + " - Capacidade: " + Formatadores.formatarMemoria(memoriaRam.getCapacidade()));
    System.out.println(hd.getNome() + " - Capacidade: " + Formatadores.formatarMemoria(hd.getCapacidade()));

    System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");

    if (memoriasUsb[0] != null) {
        System.out.println("Acompanha: " + memoriasUsb[0].getNome() + " " + memoriasUsb[0].getCapacidade());
    }
  }
}