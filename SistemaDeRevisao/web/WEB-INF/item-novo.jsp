<%@include file="jspf/header.jspf" %>
<div class="container">
    <form method="post">
        <div class="form-group row">
            <label for="titulo" class="col-sm-2 col-form-label">Título<small class="text-danger"><strong>*</strong></small></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="titulo" name="titulo" placeholder="Título" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="descricao" class="col-sm-2 col-form-label">Descrição<small class="text-danger"><strong>*</strong></small></label>
            <div class="col-sm-10">
                <textarea class="form-control" id="descricao" name="descricao" placeholder="Descrição" rows="4" required></textarea>
            </div>
        </div>
        <div class="form-group row">
            <label for="link1" class="col-sm-2 col-form-label">Link 1<small class="text-danger"><strong>*</strong></small></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="link1" name="link1" placeholder="Link 1" required>
            </div>
        </div>
        <div class="form-group row">
            <label for="link2" class="col-sm-2 col-form-label">Link 2</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="link2" name="link2" placeholder="Link 2">
            </div>
        </div>
        <div class="form-group row">
            <label for="link3" class="col-sm-2 col-form-label">Link 3</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="link3" name="link3" placeholder="Link 3">
            </div>
        </div>
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * são obrigatórios!</strong></small></small>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-primary">Cadastrar</button>
                <a href="item-listar.html" class="btn btn-danger">Voltar</a>
            </div>
        </div>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>