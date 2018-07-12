<%@include file="jspf/header.jspf" %>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col col-md-auto">
            <form>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="email@example.com" required>
                </div>
                <div class="form-group">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" id="senha" name="senha" placeholder="senha" required>
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>
            <a href="#">Novo usuário</a>
        </div>
    </div>
</div>
<%@include file="jspf/footer.jspf" %>