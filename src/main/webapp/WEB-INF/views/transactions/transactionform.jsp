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
			<c:when test="${transactionForm['new']}">
				<h1>Enregistrer une transaction</h1>
			</c:when>
			<c:otherwise>
				<h1>Modifier une transaction</h1>
			</c:otherwise>
		</c:choose>
		<br />

		<spring:url value="/transactions" var="transactionActionUrl" />

		<form:form class="form-horizontal" method="post"
			modelAttribute="transactionForm" action="${transactionActionUrl}">

			<form:hidden path="id" />

			<spring:bind path="montant">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Montant</label>
					<div class="col-sm-10">
						<form:input path="montant" type="number" class="form-control" id="nom"
							placeholder="Montant" />
						<form:errors path="montant" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="type">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Type d'Opération</label>
					<div class="col-sm-10">
							<form:select class="form-control" id="type" path="type">
							  <option>DEBIT</option>
							  <option>CREDIT</option>
							</form:select>
						<form:errors path="type" class="control-label" />
					</div>
				</div>
			</spring:bind>
			
			<spring:bind path="compte">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Compte</label>
					<div class="col-sm-10">							
							<form:select class="form-control" id="compte" path="compte.id">
							  	<c:forEach var="compte" items="${comptes}">
<%-- 								  <option>${compte}</option> --%>
								  <form:option value="${compte.id}" label="numero: ${compte.numero} appartenant à ${compte.proprietaire.nom} ${compte.proprietaire.prenom}" />
	  						    </c:forEach>
							</form:select>
						<form:errors path="compte.id" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${transactionForm['new']}">
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