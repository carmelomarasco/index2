<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header role="banner" aria-label="Informazioni e strumenti utente">
	<div id="agenzia-header" class="hidden-xs">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2">
					<p>Agenzia delle Entrate</p>
				</div>
	   		</div>
	   	</div>
	</div>
	<div id="page-header">
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-3 col-md-2 text-right hidden-xs">
					<img src="resources/img/CoopInt_logo_152.png" alt="CoopInt" class="logo" />
				</div>
				<div class="col-sm-9 col-md-5 col-xl-6">
					<div class="row header-links">
						<div class="col-xs-10 col-sm-7">
							<c:if test="${ eN != null && eN != 'COOPINT_LOGIN_SEMAFORO' }">
								<a href="/CoopIntLoginWeb/Aut.do?login=ok&eN=COOPINT_LOGIN_SEMAFORO"><i class="fa fa-arrow-left">
								</i><bean:message key="coopint.title" /></a>
							</c:if>
						</div>
						<div class="col-xs-2 col-sm-5 text-right">
							<a href="/CoopIntLoginWeb/SideMenu.do?id=5-01-00-00&openMenu=1&compatta=ok&head=Help"><i class="fa fa-info-circle fa-lg"></i><span class="hidden-xs">Info e Assistenza</span></a>
						</div>
					</div>
					<hr aria-hidden="true" />
					<c:choose>
						<c:when test="${ eN == 'COOPINT_LOGIN_SEMAFORO' || eN == null}">
							<h1><bean:message key="coopint.title" /><small><bean:message key="coopint.subtitle" /></small></h1>
						</c:when>
						<c:otherwise>
							<h1>${appName}</h1>
						</c:otherwise>
					</c:choose>					
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-5 col-md-offset-0 col-xl-4">
					<div id="user-info">
						<span class="hidden-xs">Utente: </span><strong><%= request.getRemoteUser()%></strong>
						<button id="open-user-info" data-toggle="collapse" data-target="#user-collapse" class="visible-xs collapsed pull-right fa-lg">
							<span class="sr-only">Apri menu utente</span>
						</button>
						<div id="user-collapse" class="row collapse">
							<div class="col-sm-9">
								<!-- <p>Seconda voce utente: <strong>valore</strong></p>-->
								<span class="user-links">
						  			<!-- <a href=""><i class="fa fa-font-awesome"></i>Link utente</a>
								  	<a href=""><i class="fa fa-font-awesome"></i>Link utente</a>-->
					  			</span>
				 			</div>
							<div class="col-sm-3 text-right">
								<button class="btn btn-primary" onclick="location.href='/CoopIntLoginWeb/Logoff.do?Off=Esci'"><i class="fa fa-sign-out"></i>Esci</button>
							</div>
					  	</div>
					</div>
				</div>
	   		</div>
	   	</div>
	</div>
</header>