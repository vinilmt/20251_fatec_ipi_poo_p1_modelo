import java.util.Random;

public class JogoMinecraft {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();

    var alex = new JogadorMinecraft("Alex");
    var steve = new JogadorMinecraft("Steve Construtor");

    while (alex.estaVivo() || steve.estaVivo()) {
      if (alex.estaVivo()) {
        executarAcao(alex, gerador, new int[] {1,1,1});
        System.out.println(alex);
        processarDanoProprio(alex, steve, gerador);
      }

      if (steve.estaVivo()) {
        executarAcao(steve, gerador, new int[] {1,3,6});
        System.out.println(steve);
        processarDanoProprio(steve, alex, gerador);
      }
      
      if (alex.estaVivo() && steve.estaVivo()) {
        processarAtaque(alex, steve, gerador);
      }

      System.out.println("============");
      Thread.sleep(5000);
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
