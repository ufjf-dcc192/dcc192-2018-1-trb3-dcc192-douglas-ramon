<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file="jspf/header.jspf" %>
<div class="card">
    <div class="card-body">
        <h5 class="card-title">${item.item.titulo}</h5>
        <h6 class="card-subtitle mb-2 text-muted">${item.usuario.nome_usuario}</h6>
        <p class="card-text">${item.item.descricao}</p>
        <c:if test="${item.item.link2 != NULL}" var="a">
            <a href="http://${item.item.link2}" class="card-link" target="_blank">link 2</a>
        </c:if>
        <c:if test="${item.item.link3 != null}">
            <a href="http://${item.item.link3}" class="card-link" target="_blank">link 3</a>
        </c:if>
        <div class="card-link text-center">
            <ul class="list-inline">
                <li class="list-inline-item justify-content-between align-items-center">
                    <form method="post" action="avaliar-item.html" class="list-inline-item">
                        <span class="badge badge-primary badge-pill">${negativoItem}</span>
                        <input type="hidden" name="id_item" value="${item.item.id_item}">
                        <input type="hidden" name="tipo" value="0">
                        <button type="subtmit" class="card-item btn btn-link" style="padding: 0;">Unlike</button>
                    </form>
                    <form method="post" action="avaliar-item.html" class="list-inline-item">
                        <input type="hidden" name="id_item" value="${item.item.id_item}">
                        <input type="hidden" name="tipo" value="1">
                        <button type="subtmit" class="card-item btn btn-link" style="padding: 0;">Like</button>
                        <span class="badge badge-primary badge-pill">${positivoItem}</span>
                    </form>
                </li>
                <li class="list-inline-item justify-content-between align-items-center">
                </li>
            </ul>
        </div>
        <a href="#collapseExample" role="button" data-toggle="collapse" data-target="#comentar" aria-expanded="false" aria-controls="comentar">
            Comentar
        </a>
        <div class="collapse" id="comentar">
            <div class="card card-body">
                <form>
                    <div class="form-group">
                        <label for="comentario">Mensagem:</label>
                        <textarea class="form-control" name="comentario" id="comentario" placeholder="Digite aqui o comentário..." rows="5"></textarea>
                    </div>
                    <button type="submit" class="btn btn-success">Enviar</button>
                    <button type="reset" class="btn btn-danger" data-toggle="collapse" data-target="#comentar">Cancelar</button>
                </form>
            </div>
        </div>
    </div>
</div>
<c:forEach var="comentario" items="${comentarios}">
<div class="container">
    <div class="list-group" style="padding-top: 0.3rem;">
        <div class="list-group-item list-group-item-action flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${comentario.usuario.nome_usuario}</h5>
            </div>
            <div class="list-inline">
                <p class="card-text list-inline-item" style="margin-bottom: 0;"><small class="text-muted">Criado em: <fmt:formatDate value="${comentario.comentario.data_insert}" pattern="dd/MM/yyyy HH:mm"/></small></p>
                <p class="card-text list-inline-item" style="margin-bottom: 0;">
                    <small class="text-muted">
                        Ultima atualização: 
                        <c:if test="${comentario.comentario.data_update == null}"> - </c:if>
                        <c:if test="${comentario.comentario.data_update != NULL}"><fmt:formatDate value="${comentario.comentario.data_update}" pattern="dd/MM/yyyy HH:mm"/></c:if>
                    </small>
                </p>
            </div>
            <p class="mb-1">${comentario.comentario.texto}</p>
            <small>
                <div class="list-inline">
                    <div class="list-inline-item justify-content-between align-items-center">
                        <span class="badge badge-primary badge-pill">2</span>
                        <a href="#" class="card-link">Unlike</a>
                    </div>
                    <div class="list-inline-item justify-content-between align-items-center">
                        <a href="#" class="card-link">Like</a>
                        <span class="badge badge-primary badge-pill">14</span>
                    </div>
                </div>
            </small>
        </div>
    </div>
</div>
</c:forEach>
<%@include file="jspf/footer.jspf" %>