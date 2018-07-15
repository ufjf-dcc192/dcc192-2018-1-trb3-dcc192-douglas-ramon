/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author douglas
 */
public class PostAvaliarComentarioCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            Usuario u = UsuarioDAO.getInstance().getUsuario(username);
            Long id_comentario = Long.parseLong(request.getParameter("id_comentario"));
            Integer t = Integer.parseInt(request.getParameter("tipo"));
            Boolean tipo;
            if (t == 0) {
                tipo = false;
            } else {
                tipo = true;
            }
            AvaliacaoComentario ac = UsuarioDAO.getInstance().getAvaliacaoComentario(id_comentario, u.getId_usuario());
            Comentario c = UsuarioDAO.getInstance().getComentario(id_comentario);
            if (ac.getId_avaliacao() == null) {
                UsuarioDAO.getInstance().avaliaComentario(u.getId_usuario(), id_comentario, tipo);
                response.sendRedirect("item-comentarios.html?id_item=" + c.getId_item() + "");
            } else {
                if (Objects.equals(tipo, ac.isTipo())) {
                    response.sendRedirect("item-comentarios.html?id_item=" + c.getId_item() + "");
                } else {
                    UsuarioDAO.getInstance().atualizaAvaliacaoComentario(id_comentario, u.getId_usuario(), tipo);
                    response.sendRedirect("item-comentarios.html?id_item=" + c.getId_item() + "");
                }
            }
        }
    }

}
