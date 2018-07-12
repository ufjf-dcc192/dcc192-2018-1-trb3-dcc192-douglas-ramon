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
public class GetItemListarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/item-listar.jsp");
            request.setAttribute("titulo", "Lista de Itens");
            String username = (String) session.getAttribute("authUser");
            String mensagem = "Olá " + username;
            String link = "logout.html";
            String logout = "Logout";
            request.setAttribute("authUser", username);
            request.setAttribute("mensagem", mensagem);
            request.setAttribute("link", link);
            request.setAttribute("logout", logout);
            dispacher.forward(request, response);
        }
    }

}
