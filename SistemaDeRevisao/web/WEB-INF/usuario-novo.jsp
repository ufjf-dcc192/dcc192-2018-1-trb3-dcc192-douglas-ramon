<%@include file="jspf/header.jspf" %>
<div class="container">
    <form method="POST">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="nomeCompleto">Nome Completo<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nomeCompleto" placeholder="Nome completo" name="nomeCompleto" required>
            </div>
            <div class="form-group col-md-6">
                <label for="nomeUsuario">Nome de usuário<small class="text-danger"><strong>*</strong></small></label>
                <input type="text" class="form-control" id="nomeUsuario" placeholder="Nome usuário" name="nomeUsuario" required>
            </div> 
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="email">E-mail<small class="text-danger"><strong>*</strong></small></label>
                <input type="email" class="form-control" id="email" name="email" placeHolder="seu@email.com" required>
            </div>
            <div class="form-group col-md-6">
                <label for="senha">Senha<small class="text-danger"><strong>*</strong></small></label>
                <input type="password" class="form-control" id="senha" name="senha" required>
            </div>
        </div>
        <div class="form-group row">
            <small class="text-danger"><small><strong>Os campos com * são obrigatórios!</strong></small></small>
        </div>
        <button type="submit" class="btn btn-success">Cadastrar</button>
        <button type="reset" class="btn btn-secondary">Limpar Campos</button>
        <a class="btn btn-danger" href="eventos.html">Voltar</a>
    </form>
</div>
<%@include file="jspf/footer.jspf" %>