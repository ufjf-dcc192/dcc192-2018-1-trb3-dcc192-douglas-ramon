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
public class GetIndexCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            String username = (String) session.getAttribute("authUser");
            String nome = (String) UsuarioDAO.getInstance().getUsuarioUsername(username).getNome_completo();
            String mensagem = "Olá " + username;
            String link = "logout.html";
            String logout = "Logout";
            request.setAttribute("titulo", "Página Inicial");
            request.setAttribute("authUser", username);
            request.setAttribute("nome", nome);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            request.setAttribute("logout", logout);
            dispacher.forward(request, response);
        }
    }

}
