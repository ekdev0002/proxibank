<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<c:choose>  
	<c:when test="${user.statut=='ADMIN'}">  
		<jsp:include page="header.jsp"></jsp:include> 
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


		<spring:url value="/conseillers/add" var="addUrl" />

		<button class="btn btn-primary"	onclick="location.href='${addUrl}'">Ajoutter Conseiller</button>


		<h1>Liste des conseillers</h1>		

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Identifiant</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Email</th>
					<th>Téléphone</th>
					<th>login</th>
					<th>password</th>

				</tr>
			</thead>

			<c:forEach var="conseiller" items="${conseillers}">
				<tr>
					<td>${conseiller.id}</td>
					<td>${conseiller.nom}</td>
					<td>${conseiller.prenom}</td>
					<td>${conseiller.email}</td>
					<td>${conseiller.telephone}</td>
					<td>${conseiller.login}</td>
					<td>${conseiller.password}</td>

					<td>					
					<spring:url value="/conseillers/${conseiller.id}/delete" var="deleteUrl" />
					<spring:url value="/conseillers/${conseiller.id}/update" var="updateUrl" />

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