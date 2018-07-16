<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<div class="container">
    <c:if test="${usuario.id_usuario == comentario.id_usuario}">
        <form method="post">
            <input type="hidden" name="id_comentario" value="${comentario.id_comentario}">
            <div class="alert alert-warning" role="alert">
                <h3>Tem certeza que deseja excluir este comentário?</h3>
            </div>
            <a class="btn btn-primary" href="item-comentarios.html?id_item=${comentario.id_item}">Voltar</a>
            <button type="submit" class="btn btn-danger">Sim</button>
        </form>
    </c:if>
    <c:if test="${usuario.id_usuario != comentario.id_usuario}">
        <div class="alert alert-danger text-center" role="alert">
            <h3>Você não pode excluir este comentário!</h3>
        </div>
        <a class="btn btn-primary" href="item-comentarios.html?id_item=${comentario.id_item}">Voltar</a>
    </c:if>
</div>
<%@include file="jspf/footer.jspf" %>