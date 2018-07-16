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
public class PostItemEditarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            Long id_item = Long.parseLong(request.getParameter("id_item"));
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            String link1 = request.getParameter("link1");
            String link2 = request.getParameter("link2");
            String link3 = request.getParameter("link3");
            Usuario usuario = UsuarioDAO.getInstance().getUsuario(username);
            if (link2 != null && link3 != null) {
                UsuarioDAO.getInstance().atualizaItem(usuario.getId_usuario(), id_item, titulo, descricao, link1, link2, link3);
            } else if (link2 != null) {
                UsuarioDAO.getInstance().atualizaItem(usuario.getId_usuario(), id_item, titulo, descricao, link1, link2);
            } else if (link3 != null) {
                UsuarioDAO.getInstance().atualizaItem(usuario.getId_usuario(), id_item, titulo, descricao, link1, link3);
            } else {
                UsuarioDAO.getInstance().atualizaItem(usuario.getId_usuario(), id_item, titulo, descricao, link1);
            }
            response.sendRedirect("item-comentarios.html?id_item=" + id_item + "");
        }
    }

}
