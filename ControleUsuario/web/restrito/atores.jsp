<%@page import="java.util.Date"%>
<%@page import="br.com.ifc.entidades.Atores"%>
<%@page import="java.text.SimpleDateFormat"%>
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
                        Lista de Atores
                        <a href="Atores?acao=inserir" class="pull-right">
                            <span class="glyphicon glyphicon-plus"></span>
                        </a>
                    </h3>
                </div>
                <div class="panel-body">
                    <c:forEach items="${atores}" var="ator">
                        <div class="col-md-6">
                            <div class="thumbnail">
                                <a href="Atores?acao=editar&id=${ator.id}">
                                    <img src="${ator.foto}" alt="${ator.nome}" class="img-rounded img-thumbnail" style="max-height: 220px;">
                                </a>
                                <div class="caption">
                                    <hr />
                                    <h4>${ator.nome}</h4>
                                    <p>${ator.sexo}</p>
                                    <p>${ator.dataNascimento}</p>
                                    <hr />
                                    <em>Participou no filme <strong>${ator.filme.nome}</strong></em>
                                    <hr />
                                    <p>
                                        <a href="Atores?acao=editar&id=${ator.id}" class="btn btn-xs btn-warning" role="button">Editar</a>
                                        <a href="Atores?acao=excluir&id=${ator.id}" class="btn btn-xs btn-danger" role="button">Excluir</a>
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
