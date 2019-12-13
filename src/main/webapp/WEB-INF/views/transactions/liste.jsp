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

		<h1>Liste des transactions</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Identifiant</th>
					<th>Montant</th>
					<th>Date de Realisation</th>
					<th>Type</th>
					<th>Compte</th>
					<th>Proprietaire du Compte</th>
					<th>Agent de Caisse</th>
				</tr>
			</thead>

			<c:forEach var="transaction" items="${transactions}">
				<tr>
					<td>${transaction.id}</td>
					<td>${transaction.montant}</td>
					<td>${transaction.dateRealisation}</td>
					<td>${transaction.type}</td>
					<td>${transaction.compte.numero}</td>
					<td>${transaction.compte.proprietaire.nom} ${transaction.compte.proprietaire.prenom}</td>
					<td>${transaction.realisateur.nom} ${transaction.realisateur.prenom}</td>

					<td>					
					<spring:url value="/transactions/${transaction.id}/delete" var="deleteUrl" />
					<spring:url value="/transactions/${transaction.id}/update" var="updateUrl" />

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