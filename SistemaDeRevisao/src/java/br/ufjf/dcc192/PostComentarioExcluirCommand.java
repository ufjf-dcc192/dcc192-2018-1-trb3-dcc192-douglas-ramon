/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author douglas
 */
public class PostComentarioExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            Long id_comentario = Long.parseLong(request.getParameter("id_comentario"));
            Comentario comentario = UsuarioDAO.getInstance().getComentario(id_comentario);
            Usuario usuario = UsuarioDAO.getInstance().getUsuario(username);
            UsuarioDAO.getInstance().excluirComentario(usuario.getId_usuario(), id_comentario);
            response.sendRedirect("item-comentarios.html?id_item=" + comentario.getId_item() + "");
        }
    }

}
