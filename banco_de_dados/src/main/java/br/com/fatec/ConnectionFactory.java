package br.com.fatec;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String host = "localhost";
    private static String port = "5432";
    private static String db = "p2";
    private static String user = "postgres";
    private static String password = "1234567";

    // https://google.com:80/search
    public static Connection obterConexao() throws Exception {
        // string de conexão
        var s = String.format("jdbc:postgresql://%s:%s/%s", host, port, db);
        // cat or declare
        // exeção verificada pelo compilador
        Connection c = DriverManager.getConnection(s, user, password);
        return c;
    }
}