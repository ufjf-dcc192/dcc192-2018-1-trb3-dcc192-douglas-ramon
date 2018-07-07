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
//        HttpSession session = request.getSession();
//        String username = (String) session.getAttribute("authUser");
//        if (username == null || username.isEmpty()) {
//            Boolean logado = false;
//            request.setAttribute("logado", logado);
//            RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
//            dispacher.forward(request, response);
//            return;
//        }
//        request.setAttribute("authUser", username);
//        Boolean logado = true;
//        request.setAttribute("logado", logado);
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        dispacher.forward(request, response);
    }

}
