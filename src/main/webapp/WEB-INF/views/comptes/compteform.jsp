<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
		<jsp:include page="../clients/header.jsp"></jsp:include> 

<body>
	<div class="container">

		<c:choose>
			<c:when test="${compteForm['new']}">
				<h1>Enregistrer un compte</h1>
			</c:when>
			<c:otherwise>
				<h1>Modifier un compte</h1>
			</c:otherwise>
		</c:choose>
		<br />

		<spring:url value="/comptes" var="compteActionUrl" />

		<form:form class="form-horizontal" method="post"
			modelAttribute="compteForm" action="${compteActionUrl}">

			<form:hidden path="id" />

			<spring:bind path="numero">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Nemro de Compte</label>
					<div class="col-sm-10">
						<form:input path="numero" type="number" class="form-control" id="numero"
							placeholder="Numero de Compte" />
						<form:errors path="numero" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<spring:bind path="proprietaire">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">proprietaire</label>
					<div class="col-sm-10">							
							<form:select class="form-control" id="proprietaire" path="proprietaire.id">
							  	<c:forEach var="proprietaire" items="${clientsForm}">
								  <form:option value="${proprietaire.id}" label="${proprietaire.prenom}" />
	  						    </c:forEach>
							</form:select>
						<form:errors path="proprietaire.id" class="control-label" />
					</div>
				</div>
			</spring:bind>



			<spring:bind path="categorie">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">categorie</label>
					<div class="col-sm-10">							
							<form:select class="form-control" id="categorie" path="categorie">
							  <option>COURANT</option>
							  <option>EPARGNE</option>
							</form:select>
						<form:errors path="categorie" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${compteForm['new']}">
							<button type="submit" class="btn-lg btn-primary pull-right">Enregistrer
							</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn-lg btn-primary pull-right">Mettre à jour
							</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>

	</div>

	<jsp:include page="../clients/footer.jsp" />

</body>
</html>