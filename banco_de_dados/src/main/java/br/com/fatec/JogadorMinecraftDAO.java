package br.com.fatec;

import java.sql.ResultSet;
import java.util.ArrayList;

public class JogadorMinecraftDAO {
    public ArrayList<JogadorMinecraft> listarJogadores() throws Exception{
        var jogadores = new ArrayList<JogadorMinecraft>();
        var sql = "Select * FROM personagens ORDER BY nome";
        try(
            var conexao = ConnectionFactory.obterConexao();
            var ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while(rs.next()){
                var codigo = rs.getInt("cod_personagem");
                var nome = rs.getString("nome");
                var construir = rs.getInt("prob_construir");
                var mineirar = rs.getInt("prob_mineirar");
                var madeira = rs.getInt("prob_coletar_madeira");
                var vitorias = rs.getInt("num_vitorias");
                var derrotas = rs.getInt("num_derrotas");
                var personagem = new JogadorMinecraft(nome, codigo, construir, mineirar, madeira, vitorias, derrotas);
                jogadores.add(personagem);
            }
            return jogadores;
        }
    }
}
