<%@page import="java.util.List"%>

<%@page import="br.com.ifc.entidades.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>

        <link rel="stylesheet" href="../resources/bootstrap/css/bootstrap.min.css"/>
    </head>
    <body>
        
  <jsp:include page="../menu.jsp" />
       <div class="container">
           <table class="table table-striped" >
               <thead>
                   <tr>
                       <th>ID</th>
                       <th>Nome</th>
                       <th>Usuário</th>
                       <th>Email</th>
                       <th>Senha</th>
                   </tr>
               </thead>
               <tbody>
                   <c:forEach items="${usuarios}" var="u">
                       <tr>
                           <td>${u.id}</td>
                           <td>${u.nome}</td>
                           <td>${u.usuario}</td>
                           <td>${u.email}</td>
                           <td>${u.senha}</td>
                       </tr>
                   </c:forEach>
               </tbody>
           </table>
       </div>
    </body>
</html>
