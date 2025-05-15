import java.util.Random;

public class JogoMinecraft {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();

    var alex = new JogadorMinecraft("Alex");

    while (alex.estaVivo()) {
      switch (gerador.nextInt(3)) {
          case 0:
              alex.minerar();
              break;
          case 1:
              alex.coletarMadeira();
              break;
          default:
              alex.construir();
      }

      if (gerador.nextInt(4) == 0) {
        alex.levarDano();
      }

      System.out.println(alex);
      System.out.println("============");

      Thread.sleep(5000);
    }

    System.out.println("GAME OVER");
  }
}
