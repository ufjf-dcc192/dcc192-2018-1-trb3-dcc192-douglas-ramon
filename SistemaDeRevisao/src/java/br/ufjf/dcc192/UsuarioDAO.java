package br.ufjf.dcc192;

import java.io.IOException;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

    public Usuario getUsuario(String username) {
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

    public Usuario getUsuario(Long id_usuario) {
        Usuario usuario = new Usuario();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM usuario WHERE id_usuario = " + id_usuario + "");
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

    public List<UsuarioItem> listaItem() {
        List<UsuarioItem> itens = new ArrayList<>();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT u.nome_usuario, i.* FROM usuario AS u JOIN item AS i ON u.id_usuario = i.id_usuario ORDER BY i.data_insert");
            while (resultado.next()) {
                Item item = new Item();
                Usuario usuario = new Usuario();
                item.setDataAtualizacao(resultado.getTimestamp("data_update"));
                item.setDataCriacao(resultado.getTimestamp("data_insert"));
                item.setDescricao(resultado.getString("descricao"));
                item.setId_usuario(resultado.getLong("id_usuario"));
                item.setTitulo(resultado.getString("titulo"));
                item.setId_item(resultado.getLong("id_item"));
                item.setLink1(resultado.getString("link1"));
                item.setLink2(resultado.getString("link2"));
                item.setLink3(resultado.getString("link3"));
                usuario.setNome_usuario(resultado.getString("nome_usuario"));
                UsuarioItem usuarioItem = new UsuarioItem(usuario, item);
                itens.add(usuarioItem);
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

    public UsuarioItem getItem(Long id_item) {
        Item item = new Item();
        Usuario usuario = new Usuario();
        UsuarioItem ui = new UsuarioItem(usuario, item);
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT u.nome_usuario, i.* FROM usuario AS u JOIN item AS i ON u.id_usuario = i.id_usuario WHERE id_item = " + id_item + " ORDER BY i.data_insert");
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
                usuario.setNome_usuario(resultado.getString("nome_usuario"));
                ui.setItem(item);
                ui.setUsuario(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ui;
    }

    public void verificaSessionPaginaGet(HttpServletRequest request, HttpServletResponse response, String webInf, String tituloPagina) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher(webInf);
            String username = (String) session.getAttribute("authUser");
            String nome = (String) UsuarioDAO.getInstance().getUsuario(username).getNome_completo();
            String mensagem = "Olá " + username;
            String link = "logout.html";
            String logout = "Logout";
            request.setAttribute("titulo", tituloPagina);
            request.setAttribute("authUser", username);
            request.setAttribute("nome", nome);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            request.setAttribute("logout", logout);
            dispacher.forward(request, response);
        }
    }

    public int somaPositivoItem(Long id_item) {
        int total = 0;
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT COUNT(*) AS total FROM avaliacao_item WHERE tipo = TRUE AND id_item = " + id_item + "");
            if (resultado.next()) {
                total = resultado.getInt("total");
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }

    public int somaNegativoItem(Long id_item) {
        int total = 0;
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT COUNT(*) AS total FROM avaliacao_item WHERE tipo = FALSE AND id_item = " + id_item + "");
            if (resultado.next()) {
                total = resultado.getInt("total");
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public void avaliaItem(Long id_usuario, Long id_item, Boolean tipo) {
        try {
            comando = conexao.createStatement();
            comando.executeUpdate("INSERT INTO avaliacao_item(id_usuario, id_item, tipo) VALUES (" + id_usuario + ", " + id_item + ", " + tipo + ")");
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizaAvaliacaoItem(Long id_item, Long id_usuario, Boolean tipo) {
        try {
            comando = conexao.createStatement();
            comando.executeUpdate("UPDATE avaliacao_item SET tipo = " + tipo + " WHERE id_item = " + id_item + " AND id_usuario = " + id_usuario + "");
            comando.close();
                    } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public AvaliacaoItem getAvaliacaoItem(Long id_item, Long id_usuario) {
        AvaliacaoItem ai = new AvaliacaoItem();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT * FROM avaliacao_item WHERE id_item = " + id_item + " AND id_usuario = " + id_usuario + "");
            while(resultado.next()) {
                ai.setId_avaliacao(resultado.getLong("id_avaliacao"));
                ai.setId_item(resultado.getLong("id_item"));
                ai.setId_usuario(resultado.getLong("id_usuario"));
                ai.setTipo(resultado.getBoolean("tipo"));
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ai;
    }

    public List<UsuarioComentario> listaComentario(Long id_item) {
        List<UsuarioComentario> comentarios = new ArrayList<>();
        try {
            comando = conexao.createStatement();
            resultado = comando.executeQuery("SELECT u.nome_usuario, c.* FROM usuario AS u JOIN comentario AS c ON u.id_usuario = c.id_usuario WHERE c.id_item = " + id_item + " ORDER BY c.data_insert");
            while (resultado.next()) {
                Comentario comentario = new Comentario();
                Usuario usuario = new Usuario();
                comentario.setData_insert(resultado.getTimestamp("data_insert"));
                comentario.setData_update(resultado.getTimestamp("data_update"));
                comentario.setId_comentario(resultado.getLong("id_comentario"));
                comentario.setId_item(resultado.getLong("id_item"));
                comentario.setId_usuario(resultado.getLong("id_usuario"));
                comentario.setTexto(resultado.getString("texto"));
                usuario.setNome_usuario(resultado.getString("nome_usuario"));
                UsuarioComentario usuarioComentario = new UsuarioComentario(usuario, comentario);
                comentarios.add(usuarioComentario);
            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comentarios;
    }
    
}
