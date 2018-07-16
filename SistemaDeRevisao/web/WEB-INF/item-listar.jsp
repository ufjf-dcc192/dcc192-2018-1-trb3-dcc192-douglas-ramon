<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="jspf/header.jspf" %>
<c:forEach var="item" items="${itens}">
    <div class="list-group" style="padding-top: 0.3rem;">
        <div class="card">
            <div class="card-body" style="padding-bottom: 0;">
                <div class="card-link d-flex justify-content-between">
                    <ul class="list-inline">
                        <li class="list-inline-item">
                            <h5 class="card-title">${item.item.titulo}</h5>
                        </li>
                        <c:if test="${item.usuario.nome_usuario == authUser}">
                            <li class="list-inline-item">
                                <form method="get" action="item-editar.html">
                                    <input type="hidden" name="id_item" value="${item.item.id_item}">
                                    <button class="btn btn-link" type="submit" style="padding-right: 0;"><small>Editar Item</small></button>
                                </form>
                            </li>
                            <li class="list-inline-item">
                                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#excluirItem" style="padding-left: 0;">
                                    <small>Excluir Item</small>
                                </button>
                            </li>
                        </c:if>
                    </ul>
                </div>
                <h6 class="card-subtitle mb-2 text-muted">${item.usuario.nome_usuario}</h6>
                <p class="card-text">${item.item.descricao}</p>
                <a href="http://${item.item.link1}" class="card-link" target="_blank">link 1</a>
                <c:if test="${item.item.link2 != NULL}" var="a">
                    <a href="http://${item.item.link2}" class="card-link" target="_blank">link 2</a>
                </c:if>
                <c:if test="${item.item.link3 != null}">
                    <a href="http://${item.item.link3}" class="card-link" target="_blank">link 3</a>
                </c:if>
                <div class="card-link text-center">
                    <form method="get" action="item-comentarios.html">
                        <input type="hidden" name="id_item" value="${item.item.id_item}">
                        <button type="submit" href="item-comentarios.html" class="btn btn-link">Visualizar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<!-- Modal -->
<div class="modal fade" id="excluirItem" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Excluir Item</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Tem certeza que deseja excluir este item?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <form method="post" action="item-excluir.html">
                    <input type="hidden" value="${item.item.id_item}" name="id_item">
                    <button type="submit" class="btn btn-danger">Sim</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>