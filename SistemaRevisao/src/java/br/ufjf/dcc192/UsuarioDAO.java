package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static Connection conexao;
    private static UsuarioDAO instancia;
    private Statement comando;
    private ResultSet resultado;

    public static UsuarioDAO getInstance() {
        if (instancia == null) {
            instancia = new UsuarioDAO();
        }
        return instancia;
    }

    public UsuarioDAO() {
        if (conexao == null) {
            try {
                DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
                conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/SistemaDeRevisao", "usuario", "senha");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Usuario login(String login, String senha) {
        Usuario usuario = new Usuario();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM usuario WHERE email = '" + login + "' AND senha = '" + senha + "'");
            while (resultado.next()) {
                usuario.setId_usuario(resultado.getLong("id_usuario"));
                usuario.setNome_completo(resultado.getString("nome_completo"));
                usuario.setNome_usuario(resultado.getString("nome_usuario"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setSenha(resultado.getString("senha"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public void novoUsuario(String nomeCompleto, String nomeUsuario, String email, String senha) {
        try {
            comando = conexao.createStatement();
           // comando.executeUpdate("INSERT INTO usuario(nome_completo, nome_usuario, email, senha) VALUES ('" + nomeCompleto + "', '" + nomeUsuario + "', '" + email + "', '" + senha + "')");
            comando.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
