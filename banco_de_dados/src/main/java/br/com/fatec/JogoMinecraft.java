package br.com.fatec;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class JogoMinecraft {
  public static void main(String[] args) {
    try{
      var dao = new JogadorMinecraftDAO();
      ArrayList<JogadorMinecraft> jogadores = dao.listarJogadores();
      var gerador = new Random();
      var jogador1 = jogadores.get(0);
      var jogador2 = jogadores.get(1);

      while (jogador1.estaVivo() || jogador2.estaVivo()) {
        if (jogador1.estaVivo()) {
          int[] probabilidade = new int[] {jogador1.getProb_mineirar(), jogador1.getProb_coletar_madeira(), jogador1.getProb_construir()};
          executarAcao(jogador1, gerador, probabilidade);
          System.out.println(jogador1);
          processarDanoProprio(jogador1, jogador2, gerador);
        }

        if (jogador2.estaVivo()) {
          
          int[] probabilidade = new int[] {jogador2.getProb_mineirar(), jogador2.getProb_coletar_madeira(), jogador2.getProb_construir()};
          executarAcao(jogador2, gerador, probabilidade);
          System.out.println(jogador2);
          processarDanoProprio(jogador2, jogador1, gerador);
        }
        
        if (jogador1.estaVivo() && jogador2.estaVivo()) {
          processarAtaque(jogador1, jogador2, gerador);
        }

        System.out.println("============");
        Thread.sleep(5000);
      }

    } catch (Exception e) {
      e.printStackTrace();
      JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a execução do jogo!");
    }
    System.out.println("GAME OVER");
  }

  private static void executarAcao(JogadorMinecraft jogador, Random gerador, int[] pesos) {
    int total = 0;
    for (int i = 0; i < pesos.length; i++) {
        total += pesos[i];
    }
    
    int escolha = gerador.nextInt(total);
    if (escolha < pesos[0]) {
        jogador.minerar();
    } else if (escolha < pesos[0] + pesos[1]) {
        jogador.coletarMadeira();
    } else {
        jogador.construir();
    }
  }

  private static void processarDanoProprio(JogadorMinecraft alvo, JogadorMinecraft oponente, Random gerador) {
    if (gerador.nextInt(4) == 0) {
      alvo.levarDano();
      if (!alvo.estaVivo() && oponente.estaVivo()) {
        System.out.println(oponente.getNome() + " venceu!");
      }
    }
  }

  private static void processarAtaque(JogadorMinecraft jogador1, JogadorMinecraft jogador2, Random gerador) {
    if (gerador.nextBoolean()) {
      System.out.println(jogador1.getNome() + " atacou " + jogador2.getNome() + "!");
      jogador2.levarDano();
      if (!jogador2.estaVivo()) {
        System.out.println(jogador1.getNome() + " venceu!");
      }
    } else {
      System.out.println(jogador2.getNome() + " atacou " + jogador1.getNome() + "!");
      jogador1.levarDano();
      if (!jogador1.estaVivo()) {
        System.out.println(jogador2.getNome() + " venceu!");
      }
    }
  }
}