<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                <div class="panel-heading clearfix">
                    <h3>
                        Lista de Filmes
                        <a href="Filmes?acao=inserir" class="pull-right">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach items="${filmes}" var="u">
                        <div class="col-md-4">
                            <div class="thumbnail" style="min-height: 300px;">
                                <a href="Filmes?acao=editar&id=${u.id}">
                                    <img src="${u.imagem}" alt="${u.nome}" class="img-rounded" style="max-height: 300px; width: auto;">
                                </a>
                                <div class="caption">
                                    <h4>${u.nome}</h4>
                                    <p>${u.genero}</p>
                                    <p>
                                        <a href="Filmes?acao=editar&id=${u.id}" class="btn btn-xs btn-warning" role="button">Editar</a>
                                        <a href="Filmes?acao=excluir&id=${u.id}" class="btn btn-xs btn-danger" role="button">Excluir</a>
                                    </p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </body>
</html>
