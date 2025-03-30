package br.inatel.pcmania.cliente;

import br.inatel.pcmania.computador.Computador;

public class Cliente {
  private String nome;
  private long cpf;

  private Computador[] carrinho;

  public Cliente(String nome, long cpf){
    this.nome = nome;
    this.cpf = cpf;

    carrinho =  new Computador[10];
  }

  public float calculaTotalCompra(){
    return 1;
  }
}