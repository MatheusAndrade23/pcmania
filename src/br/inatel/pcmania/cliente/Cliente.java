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
    float total = 0;

    for (Computador computador : carrinho) {
      total+= computador.getPreco();
    }

    return total;
  }

  public String getNome(){
    return nome;
  }

  public long getCpf(){
    return cpf;
  }

  public Computador[] getCarrinho(){
    return carrinho;
  }

  public void setCarrinho(Computador[] novo_carrinho){
    carrinho = novo_carrinho;
  }
}