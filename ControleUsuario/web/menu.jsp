<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.xhtml">Meu sistema</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <% // if (request.getSession() != null && request.getSession().getAttribute("usuarioLogado") != null) { %>
                <li><a href="Usuarios?acao=listar">Lista de Usuários</a></li>
                <li><a href="Filmes?acao=listar">Lista de Filmes</a></li>
                <li><a href="Atores?acao=listar">Lista de Atores</a></li>
                <li class="alert-danger"><a href="LogoutServlet">Sair</a></li>
                    <% //} else { %>
                <li><a href="Registrar?acao=registrar">Registrar-se</a></li>
                <li><a href="Registrar?acao=login">Login</a></li>
                    <%// } %>
            </ul>
        </div><!--/.nav-collapse -->
    </div><!--/.container-fluid -->
</nav>
