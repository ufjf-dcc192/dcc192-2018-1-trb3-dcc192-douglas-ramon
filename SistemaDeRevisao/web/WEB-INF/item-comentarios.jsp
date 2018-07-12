
<%@include file="jspf/header.jspf" %>
<div class="card">
    <div class="card-body">
        <h5 class="card-title">Título Item</h5>
        <h6 class="card-subtitle mb-2 text-muted">Autor Item</h6>
        <p class="card-text">Nesta área entra a descrição do item.</p>
        <a href="#" class="card-link">link 1</a>
        <a href="#" class="card-link">link 2</a>
        <div class="card-link text-center">
            <ul class="list-inline">
                <li class="list-inline-item justify-content-between align-items-center">
                    <span class="badge badge-primary badge-pill">2</span>
                    <a href="#" class="card-link">Unlike</a>
                </li>
                <li class="list-inline-item justify-content-between align-items-center">
                    <a href="#" class="card-link">Like</a>
                    <span class="badge badge-primary badge-pill">14</span>
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
<div class="container">
    <div class="list-group" style="padding-top: 0.3rem;">
        <div class="list-group-item list-group-item-action flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">Autor Comentário</h5>
            </div>
            <p class="mb-1">Texto do comentário</p>
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
    <div class="list-group" style="padding-top: 0.3rem;">
        <div class="list-group-item list-group-item-action flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">Autor Comentário</h5>
            </div>
            <p class="mb-1">Texto do comentário</p>
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
    <div class="list-group" style="padding-top: 0.3rem;">
        <div class="list-group-item list-group-item-action flex-column align-items-start">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">Autor Comentário</h5>
            </div>
            <p class="mb-1">Texto do comentário</p>
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
<%@include file="jspf/footer.jspf" %>