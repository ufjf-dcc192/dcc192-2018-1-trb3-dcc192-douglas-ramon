<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<div class="container">
    <c:if test="${usuario.nome_usuario == authUser}">
        <form method="post">
            <input type="hidden" name="id_comentario" value="${comentario.id_comentario}">
            <div class="form-group">
                <label for="texto">Mensagem:</label>
                <textarea class="form-control" name="texto" id="texto" placeholder="Digite aqui o comentário..." rows="5">${comentario.texto}</textarea>
            </div>
            <button type="submit" class="btn btn-success">Enviar</button>
            <a class="btn btn-danger" href="item-comentarios.html?id_item=${comentario.id_item}">Voltar</a>
        </form>
    </c:if>
    <c:if test="${usuario.nome_usuario != authUser}">
        <div class="alert alert-danger text-center" role="alert">
            <h3>Você não pode editar este comentário!</h3>
        </div>
        <a class="btn btn-primary" href="item-comentarios.html?id_item=${comentario.id_item}">Voltar</a>
    </c:if>
</div>
<%@include file="jspf/footer.jspf" %>