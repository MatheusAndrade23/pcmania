package br.inatel.pcmania.computador;

import br.inatel.pcmania.formatadores.Formatadores;
import br.inatel.pcmania.hardware_basico.HardwareBasico;
import br.inatel.pcmania.memoria_usb.MemoriaUSB;
import br.inatel.pcmania.sistema_operacional.SistemaOperacional;

public class Computador {
  public String marca;
  public float preco;

  public MemoriaUSB[] memoriasUsb;

  public SistemaOperacional sistemaOperacional;
  public HardwareBasico[] hardwaresBasicos;

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
    System.out.println("Sistema Operacional: " + sistemaOperacional.nome + "(" + sistemaOperacional.tipo+ ")");
    System.out.println("Preço: " + preco);

    HardwareBasico processador = hardwaresBasicos[0];
    HardwareBasico memoriaRam = hardwaresBasicos[1];
    HardwareBasico hd = hardwaresBasicos[2];

    System.out.println("Processador: " + processador.nome + " - Capacidade: " + Formatadores.formatarMemoria(processador.capacidade));
    System.out.println(memoriaRam.nome + " - Capacidade: " + Formatadores.formatarMemoria(memoriaRam.capacidade));
    System.out.println(hd.nome + " - Capacidade: " + Formatadores.formatarMemoria(hd.capacidade));

    System.out.println("Sistema Operacional: " + sistemaOperacional.nome + " (" + sistemaOperacional.tipo + " bits)");

    if (memoriasUsb[0] != null) {
        System.out.println("Acompanha: " + memoriasUsb[0].nome + " " + Formatadores.formatarMemoria(memoriasUsb[0].capacidade));
    }
  }
}