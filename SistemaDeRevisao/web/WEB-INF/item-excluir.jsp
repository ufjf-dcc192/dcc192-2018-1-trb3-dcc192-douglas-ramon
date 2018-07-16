<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<div class="container">
    <c:if test="${item.usuario.nome_usuario == authUser}">
        <form method="post">
            <input type="hidden" name="id_item" value="${item.item.id_item}">
            <div class="alert alert-warning" role="alert">
                <h3>Tem certeza que deseja excluir este item?</h3>
            </div>
            <a class="btn btn-primary" href="item-listar.html">Voltar</a>
            <button type="submit" class="btn btn-danger">Sim</button>
        </form>
    </c:if>
    <c:if test="${item.usuario.nome_usuario != authUser}">
        <div class="alert alert-danger text-center" role="alert">
            <h3>Você não pode excluir este item!</h3>
        </div>
        <a class="btn btn-primary" href="item-listar.html">Voltar</a>
    </c:if>
</div>
<%@include file="jspf/footer.jspf" %>