<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"></jsp:include>

<body>
	<div class="container">

		<c:choose>
			<c:when test="${conseillerForm['new']}">
				<h1>Enregistrer un conseiller</h1>
			</c:when>
			<c:otherwise>
				<h1>Modifier un conseiller</h1>
			</c:otherwise>
		</c:choose>
		<br />

		<spring:url value="/conseillers" var="conseillerActionUrl" />

		<form:form class="form-horizontal" method="post"
			modelAttribute="conseillerForm" action="${conseillerActionUrl}">

			<form:hidden path="id" />

			<spring:bind path="nom">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Nom</label>
					<div class="col-sm-10">
						<form:input path="nom" type="text" class="form-control" id="nom"
							placeholder="Nom" />
						<form:errors path="nom" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="prenom">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Prénom</label>
					<div class="col-sm-10">
						<form:input path="prenom" type="text" class="form-control" id="prenom"
							placeholder="Prénom" />
						<form:errors path="prenom" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="email">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<form:input path="email" type="email" class="form-control" id="email"
							placeholder="Email" />
						<form:errors path="email" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="telephone">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Téléphone</label>
					<div class="col-sm-10">
						<form:input path="telephone" type="tel" class="form-control" id="telephone"
							placeholder="Téléphone" />
						<form:errors path="telephone" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="login">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Login</label>
					<div class="col-sm-10">
						<form:input path="login" type="text" class="form-control" id="password"
							placeholder="Login" />
						<form:errors path="login" class="control-label" />
					</div>
				</div>
			</spring:bind>
			<spring:bind path="password">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<form:input path="password" type="text" class="form-control" id="password"
							placeholder="Password" />
						<form:errors path="password" class="control-label" />
					</div>
				</div>
			</spring:bind>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${conseillerForm['new']}">
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

	<jsp:include page="footer.jsp" />

</body>
</html>