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
public class PostItemExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            Long id_item = Long.parseLong(request.getParameter("id_item"));
            Usuario usuario = UsuarioDAO.getInstance().getUsuario(username);
            UsuarioDAO.getInstance().excluirItem(usuario.getId_usuario(), id_item);
            response.sendRedirect("item-listar.html");
        }
    }

}
