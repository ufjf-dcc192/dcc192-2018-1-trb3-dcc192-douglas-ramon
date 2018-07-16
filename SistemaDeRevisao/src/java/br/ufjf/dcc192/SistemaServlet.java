package br.ufjf.dcc192;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author douglas
 */
@WebServlet(name = "SistemaServlet", urlPatterns = {"/index.html", "/usuario-novo.html", "/item-novo.html", "/item-editar.html", "/item-listar.html", "/item-excluir.html", "/comentar.html", "/avaliar-item.html", "/avaliar-comentario.html", "/ranking.html", "/item.html", "/item-comentarios.html", "/meus-comentarios.html", "/a-avaliar.html", "/trolls.html", "/curadores.html", "/comentario-editar.html", "/comentario-excluir.html"})
public class SistemaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/index.html", "br.ufjf.dcc192.GetIndexCommand");
        rotas.put("/usuario-novo.html", "br.ufjf.dcc192.GetUsuarioNovoCommand");
        rotas.put("/item-comentarios.html", "br.ufjf.dcc192.GetItemComentarioCommand");
        rotas.put("/item-listar.html", "br.ufjf.dcc192.GetItemListarCommand");
        rotas.put("/item-editar.html", "br.ufjf.dcc192.GetItemEditarCommand");
        rotas.put("/item-excluir.html", "br.ufjf.dcc192.GetItemExcluirCommand");
        rotas.put("/item-novo.html", "br.ufjf.dcc192.GetItemNovoCommand");
        rotas.put("/comentario-editar.html", "br.ufjf.dcc192.GetComentarioEditarCommand");
        rotas.put("/comentario-excluir.html", "br.ufjf.dcc192.GetComentarioExcluirCommand");

        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(SistemaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
        rotas.put("/usuario-novo.html", "br.ufjf.dcc192.PostUsuarioNovoCommand");
        rotas.put("/item-novo.html", "br.ufjf.dcc192.PostItemNovoCommand");
        rotas.put("/avaliar-item.html", "br.ufjf.dcc192.PostAvaliarItemCommand");
        rotas.put("/avaliar-comentario.html", "br.ufjf.dcc192.PostAvaliarComentarioCommand");
        rotas.put("/comentar.html", "br.ufjf.dcc192.PostComentarioNovoCommand");
        rotas.put("/item-editar.html", "br.ufjf.dcc192.PostItemEditarCommand");
        rotas.put("/item-excluir.html", "br.ufjf.dcc192.PostItemExcluirCommand");
        rotas.put("/comentario-editar.html", "br.ufjf.dcc192.PostComentarioEditarCommand");
        rotas.put("/comentario-excluir.html", "br.ufjf.dcc192.PostComentarioExcluirCommand");
        
        String clazzName = rotas.get(request.getServletPath());
        try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            response.sendError(500, "Erro: " + ex);
            Logger.getLogger(SistemaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
