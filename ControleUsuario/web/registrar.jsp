<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
        <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="menu.jsp" />
        <div class="container">
            <% if (request.getSession().getAttribute("mensagens") != null) {%>
            <p class="well-sm bg-danger"><%= request.getSession().getAttribute("mensagens")%></p>
            <%}%>

            <form method="POST" action="Registrar" class="form-horizontal">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3>Registrar usuário</h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label for="nome" class="col-md-3 control-label">Nome:</label>
                            <div class="col-md-9">
                                <input type="text" name="nome" value="<c:out value="${usuario.nome}" />" class="form-control" autofocus="true" placeholder="Informe seu nome"  required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="email" class="col-md-3 control-label">E-mail:</label>
                            <div class="col-md-9">
                                <input type="text" name="email" value="<c:out value="${usuario.email}" />" class="form-control" placeholder="Informe seu e-mail" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="cpf" class="col-md-3 control-label">CPF:</label>
                            <div class="col-md-9">
                                <input type="text" name="cpf" value="<c:out value="${usuario.cpf}" />" class="form-control" placeholder="Informe seu CPF" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="usuario" class="col-md-3 control-label">Usuário:</label>
                            <div class="col-md-9">
                                <input type="text" name="usuario" value="<c:out value="${usuario.usuario}" />" class="form-control"placeholder="Informe seu código de usuário" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="senha" class="col-md-3 control-label">Senha:</label>
                            <div class="col-md-9">
                                <input type="password" name="senha" value="<c:out value="${usuario.senha}" />" class="form-control"placeholder="Informe uma senha" required="true" />
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="confirmacao" class="col-md-3 control-label">Repita a senha:</label>
                            <div class="col-md-9">
                                <input type="password" name="confirmacao" value="<c:out value="${usuario.senha}" />" class="form-control"placeholder="Informe uma senha" required="true" />
                            </div>
                        </div>
                    </div>
                    <div class="panel-footer">
                        <input type="submit" value="Registrar-se" class="btn btn-primary" />
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>
