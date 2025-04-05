package br.inatel.pcmania;

import java.util.Scanner;

import br.inatel.pcmania.cliente.Cliente;
import br.inatel.pcmania.computador.Computador;
import br.inatel.pcmania.memoria_usb.MemoriaUSB;
public class Main {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    int MATRICULA = 355;

    Computador pc_promocao1 = new Computador(
      "Apple",
      MATRICULA, 
      "Pentium Core i3",
      2200,
      8,
      500,
      "Linux Ubuntu",
      32
    );

    MemoriaUSB memoriaUsb1 = new MemoriaUSB("Pen drive", 16);
    pc_promocao1.addMemoriaUSB(memoriaUsb1);

    Computador pc_promocao2 = new Computador(
      "Samsung",
      MATRICULA + 1234, 
      "Pentium Core i5",
      3370,
      16,
      1000,
      "Windows 8",
      64
    );

    MemoriaUSB memoriaUsb2 = new MemoriaUSB("Pen drive", 32);
    pc_promocao2.addMemoriaUSB(memoriaUsb2);

    Computador pc_promocao3 = new Computador(
      "Dell",
      MATRICULA + 5678, 
      "Pentium Core i7",
      4500,
      32,
      2000,
      "Windows 10",
      64
    );

    MemoriaUSB memoriaUsb3 = new MemoriaUSB("HD Externo", 1000);
    pc_promocao3.addMemoriaUSB(memoriaUsb3);

    System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");
    System.out.println("         BEM-VINDO À PCMANIA        ");
    System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");
    System.out.println("   A melhor loja de PCs do Brasil!  ");
    System.out.println("=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=");

    System.out.print("Digite seu nome: ");
    String nome = keyboard.nextLine();
        
    System.out.print("Digite seu CPF: ");
    String cpf = keyboard.nextLine();
        
    Cliente cliente = new Cliente(nome, Long.parseLong(cpf));

    System.out.println("\nCadastro realizado com sucesso!");

    System.out.println("====================================");
    System.out.println("Estamos com promoções imperdíveis!");
    System.out.println("====================================");

    System.out.println("Digite 1 para adicionar a promoção 1 ao carrinho.");
    System.out.println("Digite 2 para adicionar a promoção 2 ao carrinho.");
    System.out.println("Digite 3 para adicionar a promoção 3 ao carrinho.");
    System.out.println("Digite 0 para finalizar sua compra e sair.");

    System.out.println("Boas Compras!");

    boolean continuar = true;

    while (continuar) { 
      System.out.print("Digite o código desejado:");
      int codigo = Integer.parseInt(keyboard.nextLine());

        switch (codigo) {
            case 0 -> {
              continuar = false;
            }
            case 1 -> {
              Computador[] carrinho = cliente.carrinho;
              Computador[] novoCarrinho = new Computador[carrinho.length + 1];
    
              for (int i = 0; i < carrinho.length; i++) {
                novoCarrinho[i] = carrinho[i];
              }
  
              novoCarrinho[carrinho.length] = pc_promocao1;
              cliente.carrinho = novoCarrinho;

              System.out.println("Computador da promoção 1 adicionado ao carrinho!");
            }
            case 2 -> {
              Computador[] carrinho = cliente.carrinho;
              Computador[] novoCarrinho = new Computador[carrinho.length + 1];
    
              for (int i = 0; i < carrinho.length; i++) {
                novoCarrinho[i] = carrinho[i];
              }
  
              novoCarrinho[carrinho.length] = pc_promocao2;
              cliente.carrinho = novoCarrinho;

              System.out.println("Computador da promoção 2 adicionado ao carrinho!");
            }
            case 3 -> {
              

              Computador[] carrinho = cliente.carrinho;
              Computador[] novoCarrinho = new Computador[carrinho.length + 1];
    
              for (int i = 0; i < carrinho.length; i++) {
                novoCarrinho[i] = carrinho[i];
              }
  
              novoCarrinho[carrinho.length] = pc_promocao3;
              cliente.carrinho = novoCarrinho;

              System.out.println("Computador da promoção 3 adicionado ao carrinho!");
            }
            default -> System.out.println("Código inválido. Tente novamente.");
        }
    }

    System.out.println("======== Compra Encerrada ========");

    System.out.println("Cliente: " + cliente.nome + " - CPF: " + cliente.cpf);
    System.out.println("Produtos:");

    Computador[] carrinho = cliente.carrinho;

    for (Computador computador : carrinho) {
      System.out.println("");
      computador.mostraPCConfigs();
    }

    System.out.println("------------");
    System.out.println("Total da Compra: " + cliente.calculaTotalCompra() + " R$");

    keyboard.close();
  }
}