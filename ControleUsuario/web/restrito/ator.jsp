<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO_8859-1">
        <title>Filmes</title>

        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        <jsp:include page="../menu.jsp" />
        <div class="container">
            <% if (request.getAttribute("mensagens") != null) { %>
            <p class="alert alert-danger">${mensagens}</p>
            <% }%>
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h3>Cadastro de Atores</h3>
                </div>
                <div class="panel-body">
                    <form action="Atores" method="POST" class="form-horizontal">
                        <input type="hidden" value="${ator.id}" name="id" />
                        <div class="form-group">
                            <label for="nome" class="control-label col-md-3">Nome: </label>
                            <div class="col-md-9">
                                <input type="text" name="nome" value="${ator.nome}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="sexo" class="control-label col-md-3">Sexo: </label>
                            <div class="col-md-9">
                                <input type="text" name="sexo" value="${ator.sexo}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="data_nascimento" class="control-label col-md-3">Sexo: </label>
                            <div class="col-md-9">
                                <input type="date" name="data_nascimento" value="${ator.dataNascimento}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="foto" class="control-label col-md-3">Foto: </label>
                            <div class="col-md-9">
                                <input type="text" name="foto" value="${ator.foto}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="filme_id" class="control-label col-md-3">Filme: </label>
                            <div class="col-md-9">
                                <select name="filme_id" class="form-control" required="true">
                                    <option value="">Selecione o Filme</option>
                                    <c:forEach items="${filmes}" var="filme">
                                        <option value="${filme.id}" ${ator.filme.id == filme.id ? 'selected' : ''} >${filme.nome}</option>    
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" value="Salvar" class="btn btn-primary" />
                                <input type="button" value="Voltar" class="btn" onclick="history.back()" />
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
