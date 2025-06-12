package br.com.fatec;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JogadorMinecraftDAO {
    public void atualizarJogador(JogadorMinecraft jogador) throws Exception {
        var sql = "UPDATE personagens SET nome=?, prob_construir=?, prob_mineirar=?, prob_coletar_madeira=?, num_vitorias=?, num_derrotas=? WHERE cod_personagem=?";

        var conexao = ConnectionFactory.obterConexao();
        var ps = conexao.prepareStatement(sql);

        ps.setString(1, jogador.getNome());
        ps.setInt(2, jogador.getProbConstruir());
        ps.setInt(3, jogador.getProbMineirar());
        ps.setInt(4, jogador.getProbColetarMadeira());
        ps.setInt(5, jogador.getVitorias());
        ps.setInt(6, jogador.getDerrotas());
        ps.setInt(7, jogador.getCodigo());
        ps.execute();
    }

    public ArrayList<JogadorMinecraft> listarJogadores() throws Exception {
        var jogadores = new ArrayList<JogadorMinecraft>();
        var sql = "SELECT * FROM personagens ORDER BY nome";

        var conexao = ConnectionFactory.obterConexao();
        var ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            var codigo = rs.getInt("cod_personagem");
            var nome = rs.getString("nome");
            var probConstruir = rs.getInt("prob_construir");
            var probMineirar = rs.getInt("prob_mineirar");
            var probColetarMadeira = rs.getInt("prob_coletar_madeira");
            var vitorias = rs.getInt("num_vitorias");
            var derrotas = rs.getInt("num_derrotas");
            var personagem = new JogadorMinecraft(nome, codigo, probConstruir, probMineirar, probColetarMadeira,
                    vitorias, derrotas);
            jogadores.add(personagem);
        }
        return jogadores;
    }
}
