import java.util.Random;

public class JogoMinecraft {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();

    var alex = new JogadorMinecraft("Alex");
    JogadorMinecraft steve = new JogadorMinecraft("Steve Construtor");

    while (alex.estaVivo() || steve.estaVivo()) {
      if (alex.estaVivo()) {
        executarAcaoAleatoria(alex, gerador, new int[] {1,1,1});
        if (gerador.nextInt(4) == 0) {
          alex.levarDano();
        }
        System.out.println(alex);
      }

      if (steve.estaVivo()) {
        executarAcaoAleatoria(steve, gerador, new int[] {1,3,6});
        if (gerador.nextInt(4) == 0) {
          steve.levarDano();
        }
        System.out.println(steve);
      }
      
      System.out.println("============");
      Thread.sleep(5000);
    }

    System.out.println("GAME OVER");
  }

  private static void executarAcaoAleatoria(JogadorMinecraft jogador, Random gerador, int[] pesos) {
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
}
