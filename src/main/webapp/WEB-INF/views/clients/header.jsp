<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<head>
<title>proxibank</title>

<spring:url value="/resources/style.css" var="costumCss" />
<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${costumCss}" rel="stylesheet" />
</head>

<spring:url value="/deconnecte" var="DeconnecteUrl" />
<spring:url value="/client/add" var="ajoutClientUrl" />
<spring:url value="/compte/add" var="ajoutCompteUrl" />
<spring:url value="/clients/" var="listeClientsUrl" />
<spring:url value="/comptes" var="listeComptesUrl" />
<spring:url value="/comptescourants" var="listeComptesCourantsUrl" />
<spring:url value="/comptesepargnes" var="listeComptesEpargnesUrl" />
<spring:url value="/transactions" var="listeTransactionsUrl" />
<spring:url value="/transactionsdebits" var="listeTransactionsDebitsUrl" />
<spring:url value="/transactionscredits" var="listeTransactionsCreditsUrl" />
<spring:url value="/transaction/add" var="ajoutTransactionUrl" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${homeUrl}">Proxibank</a>
		</div>
		<div id="navbar">

			<ul class="nav navbar-nav  navbar-right">
              <li class="active dropdown">
                <a href="${listeClientsUrl}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Clients<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ajoutClientUrl}">Nouveau client</a></li>
                  <li><a href="${listeClientsUrl}">Lister les clients</a></li>
                </ul>
              </li>
              <li class="active dropdown">
                <a href="${listeComptesUrl}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Comptes<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ajoutCompteUrl}">Nouveau Compte</a></li>
                  <li><a href="${listeComptesCourantsUrl}">Lister les comptes courants</a></li>
                  <li><a href="${listeComptesEpargnesUrl}">Lister les comptes éparges</a></li>
                  <li><a href="${listeComptesUrl}">Lister tous les comptes</a></li>
                </ul>
              </li>

              <li class="active dropdown">
                <a href="${listeTransactionsUrl}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Transactions<span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="${ajoutTransactionUrl}">Nouvelle Opération credi/débit</a></li>
                  <li><a href="${listeTransactionsDebitsUrl }">Lister les opérations de debit</a></li>
                  <li><a href="${listeTransactionsCreditsUrl }">Lister les opérations de credit</a></li>
                  <li><a href="${listeTransactionsUrl}">Lister toutes les opérations</a></li>
                </ul>
              </li>
                            <li><a href="${DeconnecteUrl}">Deconnexion</a></li>
              
            </ul>
		</div>
	</div>
</nav>