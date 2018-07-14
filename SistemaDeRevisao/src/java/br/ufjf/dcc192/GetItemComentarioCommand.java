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
public class GetItemComentarioCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String webInf = "/WEB-INF/item-comentarios.jsp";
        String titulo = "Comentários";
        Long id_item = Long.parseLong(request.getParameter("id_item"));
        UsuarioItem item = UsuarioDAO.getInstance().getItem(id_item);
        request.setAttribute("item", item);
        int totalPositivo = UsuarioDAO.getInstance().somaPositivoItem(id_item);
        int totalNegativo = UsuarioDAO.getInstance().somaNegativoItem(id_item);
        request.setAttribute("positivo", totalPositivo);
        request.setAttribute("negativo", totalNegativo);
        if (item.getItem().getTitulo() != null) {
            UsuarioDAO.getInstance().verificaSessionPaginaGet(request, response, webInf, titulo);
        } else {
            response.sendRedirect("item-listar.html");
        }
    }

}
