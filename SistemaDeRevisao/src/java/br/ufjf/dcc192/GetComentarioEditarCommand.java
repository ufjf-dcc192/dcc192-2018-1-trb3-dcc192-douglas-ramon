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
public class GetComentarioEditarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String webInf = "/WEB-INF/comentar.jsp";
        String titulo = "Editar Comentário";
        Long id_comentario = Long.parseLong(request.getParameter("id_comentario"));
        Comentario comentario = UsuarioDAO.getInstance().getComentario(id_comentario);
        Usuario usuario = UsuarioDAO.getInstance().getUsuario(comentario.getId_usuario());
        request.setAttribute("usuario", usuario);
        request.setAttribute("comentario", comentario);
        UsuarioDAO.getInstance().verificaSessionPaginaGet(request, response, webInf, titulo);
    }

}
