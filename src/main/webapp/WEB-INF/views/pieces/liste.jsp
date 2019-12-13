<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<c:choose>  
	<c:when test="${user.statut=='ADMIN'}">
		<jsp:include page="../conseillers/header.jsp"></jsp:include> 
	</c:when>  
	<c:otherwise>  
		<jsp:include page="../clients/header.jsp"></jsp:include> 
	</c:otherwise>  
</c:choose>  


<body>
	<div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>Liste des pieces</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Identifiant</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Email</th>
					<th>Téléphone</th>
				</tr>
			</thead>

			<c:forEach var="piece" items="${pieces}">
				<tr>
					<td>${piece.id}</td>
					<td>${piece.nom}</td>
					<td>${piece.prenom}</td>
					<td>${piece.email}</td>
					<td>${piece.telephone}</td>
					<td>					
					<spring:url value="/pieces/${piece.id}/delete" var="deleteUrl" />
					<spring:url value="/pieces/${piece.id}/update" var="updateUrl" />

					<button class="btn btn-primary"	onclick="location.href='${updateUrl}'">Modifier</button>
					<button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Supprimer</button>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<jsp:include page="../clients/footer.jsp" />
</body>
</html>