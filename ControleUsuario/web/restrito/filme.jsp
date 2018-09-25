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
                    <h3>Cadastro de Filmes</h3>
                </div>
                <div class="panel-body">
                    <form action="Filmes" method="POST" class="form-horizontal">
                        <input type="hidden" value="${filme.id}" name="id" />
                        <div class="form-group">
                            <label for="nome" class="control-label col-md-3">Nome: </label>
                            <div class="col-md-9">
                                <input type="text" name="nome" value="${filme.nome}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="genero" class="control-label col-md-3">Gênero: </label>
                            <div class="col-md-9">
                                <input type="text" name="genero" value="${filme.genero}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="imagem" class="control-label col-md-3">Imagem: </label>
                            <div class="col-md-9">
                                <input type="text" name="imagem" value="${filme.imagem}" class="form-control" required="true" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-3 col-md-9">
                                <input type="submit" value="Salvar" class="btn btn-primary" />
                                <input type="button" value="Voltar" class="btn" onclick="history.back()" />
                            </div>
                            <label for="estrelas" class="control-label col-md-3">Avaliação: </label>
                            <div class="col-md-9"> 
                                <span class="star-rating star-5">
                                 <input type="radio" name="estrelas" value="1" ${filme.estrelas == 1 ? 'checked' : ''}/> <i></i>  
                                 <input type="radio" name="estrelas" value="2" ${filme.estrelas == 2 ? 'checked' : ''}/> <i></i>  
                                 <input type="radio" name="estrelas" value="3" ${filme.estrelas == 3 ? 'checked' : ''}/> <i></i>  
                                 <input type="radio" name="estrelas" value="4" ${filme.estrelas == 4 ? 'checked' : ''}/> <i></i>  
                                 <input type="radio" name="estrelas" value="5" ${filme.estrelas == 5 ? 'checked' : ''}/> <i></i>  
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
