package br.ufjf.dcc192;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    
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
            comando.executeUpdate("INSERT INTO usuario(nome_completo, nome_usuario, email, senha) VALUES ('" + nomeCompleto + "', '" + nomeUsuario + "', '" + email + "', '" + senha + "')");
            comando.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuarioUsername(String username) {
        Usuario usuario = new Usuario();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM usuario WHERE nome_usuario = '" + username + "'");
            while (resultado.next()) {
                usuario.setEmail(resultado.getString("email"));
                usuario.setId_usuario(resultado.getLong("id_usuario"));
                usuario.setNome_completo(resultado.getString("nome_completo"));
                usuario.setNome_usuario(resultado.getString("nome_usuario"));
                usuario.setSenha(resultado.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public List<Item> listaItem() {
        List<Item> itens = new ArrayList<>();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM item");
            while (resultado.next()) {
                Item item = new Item();
                item.setDataAtualizacao(resultado.getTimestamp("data_update"));
                item.setDataCriacao(resultado.getTimestamp("data_insert"));
                item.setDescricao(resultado.getString("descricao"));
                item.setId_usuario(resultado.getLong("id_usuario"));
                item.setTitulo(resultado.getString("titulo"));
                itens.add(item);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itens;
    }

    public void novoItem(Long id_usuario, String titulo, String descricao, String link1) {
        try {
            Date data_insert = new Date();
            Timestamp t_data_insert = new Timestamp(data_insert.getTime());
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO item(id_usuario, titulo, descricao, link1, data_insert) VALUES (" + id_usuario + ", '" + titulo + "', '" + descricao + "', '" + link1 + "', '" + t_data_insert + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void novoItem(Long id_usuario, String titulo, String descricao, String link1, String link2) {
        try {
            Date data_insert = new Date();
            Timestamp t_data_insert = new Timestamp(data_insert.getTime());
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO item(id_usuario, titulo, descricao, link1, link2, data_insert) VALUES (" + id_usuario + ", '" + titulo + "', '" + descricao + "', '" + link1 + "', '" + link2 + "', '" + t_data_insert + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void novoItem(Long id_usuario, String titulo, String descricao, String link1, String link2, String link3) {
        try {
            Date data_insert = new Date();
            Timestamp t_data_insert = new Timestamp(data_insert.getTime());
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO item(id_usuario, titulo, descricao, link1, link2, link3, data_insert) VALUES (" + id_usuario + ", '" + titulo + "', '" + descricao + "', '" + link1 + "', '" + link2 + "', '" + link3 + "', '" + t_data_insert + "')");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Item getItem(Long id_item) {
        Item item = new Item();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM item WHERE id_item = " + id_item + "");
            while (resultado.next()) {
                item.setDataAtualizacao(resultado.getDate("data_update"));
                item.setDataCriacao(resultado.getDate("data_insert"));
                item.setDescricao(resultado.getString("descricao"));
                item.setId_usuario(resultado.getLong("id_usuario"));
                item.setTitulo(resultado.getString("titulo"));
                item.setId_item(resultado.getLong("id_item"));
                item.setLink1(resultado.getString("link1"));
                item.setLink2(resultado.getString("link2"));
                item.setLink3(resultado.getString("link3"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }
}
