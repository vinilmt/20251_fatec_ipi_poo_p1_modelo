import java.util.Random;

public class JogoMinecraft {
  public static void main(String[] args) throws Exception {
    var gerador = new Random();

    var alex = new JogadorMinecraft("Alex");

    while (true) {
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
      System.out.println(alex);
      System.out.println("============");
      Thread.sleep(5000);
    }
  }
}
