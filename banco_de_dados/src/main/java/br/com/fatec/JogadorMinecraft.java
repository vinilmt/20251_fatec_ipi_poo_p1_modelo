package br.com.fatec;
import java.util.*;

public class JogadorMinecraft {
    private String nome;
    private int vida;
    private int blocosColetados;
    private List<String> inventario;

    public JogadorMinecraft(String nome) {
        this.nome = nome;
        this.vida = 10;
        this.blocosColetados = 0;
        this.inventario = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void minerar() {
        System.out.println(nome + " está minerando...");
        blocosColetados++;
        inventario.add("Pedra");
    }

    public void coletarMadeira() {
        System.out.println(nome + " coletou madeira.");
        inventario.add("Madeira");
    }

    public void construir() {
        if (inventario.size() >= 2) {
            System.out.println(nome + " construiu algo com seus recursos!");
            inventario.remove(0);
            inventario.remove(0);
        } else {
            System.out.println(nome + " não tem blocos suficientes para construir.");
        }
    }

    public void levarDano() {
        vida--;
        System.out.println(nome + " levou dano! Vida atual: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String toString() {
        return String.format(
            "%s - Vida: %d, Blocos: %d, Inventário: %s",
            nome, vida, blocosColetados, inventario
        );
    }
}
