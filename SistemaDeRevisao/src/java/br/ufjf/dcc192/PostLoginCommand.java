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
public class PostLoginCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = UsuarioDAO.getInstance().login(email, senha);
        if (usuario.getNome_completo() != null) {
            String username = usuario.getNome_usuario();
            HttpSession session = request.getSession();
            session.setAttribute("authUser", username);
            response.sendRedirect("index.html");
        } else {
            response.sendRedirect("login.html");
        }
    }

}
