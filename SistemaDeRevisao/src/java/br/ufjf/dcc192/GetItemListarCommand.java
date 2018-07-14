/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufjf.dcc192;

import java.io.IOException;
import java.util.List;
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
        String webInf = "/WEB-INF/item-listar.jsp";
        String titulo = "Lista de Itens";
        List<UsuarioItem> itens = UsuarioDAO.getInstance().listaItem();
        request.setAttribute("itens", itens);
        UsuarioDAO.getInstance().verificaSessionPaginaGet(request, response, webInf, titulo);
    }

}
