package br.inatel.pcmania.cliente;

import br.inatel.pcmania.computador.Computador;

public class Cliente {
  public String nome;
  public long cpf;

  public Computador[] carrinho;

  public Cliente(String nome, long cpf){
    this.nome = nome;
    this.cpf = cpf;

    this.carrinho =  new Computador[0];
  }

  public float calculaTotalCompra() {
    float total = 0;
    for (Computador computador : carrinho) {
      if (computador != null) {
        total += computador.preco;
      }
    }
    return total;
  }
}