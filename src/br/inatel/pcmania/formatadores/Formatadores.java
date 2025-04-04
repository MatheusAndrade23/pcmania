package br.inatel.pcmania.formatadores;

public class Formatadores{
  public static String formatarMemoria(float capacidadeGB){
    if(capacidadeGB >= 1000){
      return capacidadeGB/1000 + " TB";
    }

    return capacidadeGB + " GB";
  }
}