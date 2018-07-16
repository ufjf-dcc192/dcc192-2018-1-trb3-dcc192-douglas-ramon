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
public class GetComentarioExcluirCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("authUser");
        if (session.getAttribute("authUser") == null) {
            response.sendRedirect("login.html");
        } else {
            String webInf = "/WEB-INF/comentario-excluir.jsp";
            String titulo = "Excluir Comentário";
            Long id_comentario = Long.parseLong(request.getParameter("id_comentario"));
            Comentario comentario = UsuarioDAO.getInstance().getComentario(id_comentario);
            Usuario usuario = UsuarioDAO.getInstance().getUsuario(username);
            UsuarioComentario uc = new UsuarioComentario(usuario, comentario);
            request.setAttribute("uc", uc);
            request.setAttribute("usuario", usuario);
            request.setAttribute("comentario", comentario);
            UsuarioDAO.getInstance().verificaSessionPaginaGet(request, response, webInf, titulo);
        }
    }
}
