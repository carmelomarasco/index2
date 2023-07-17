<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="col-md-3 col-xl-2">

	<!-- Menu di sezione -->
	<nav role="navigation" aria-label="Menu della sezione ...">
		<h1 class="sr-only">Menu <bean:message key="coopint.title" /> ...</h1>
		<!-- Se il menu e' a tre livelli: -->
		<!-- riportare come titolo del Menu di sezione la voce di secondo livello del Menu principale -->
		<div id="menu-left-title">
			<i class="fa fa-home"></i>${menuVerticale.titolo}
			<a href="#menu-left" data-toggle="collapse" class="visible-xs visible-sm collapsed">
				<i class="fa fa-lg fa-pull-right"></i>
			</a>
		</div>
		<ul id="menu-left" class="nav collapse">								
														
			<c:forEach items="${menuVerticale.elenco}" var="appAbil">
				<c:if test="${ fn:length(appAbil.subVoci) eq 0 }">
					<c:set var="appAbilUrl"	value="${appAbil.url}"/>		 
					<%-- Per ambiente locale su DB di TEST --%>
					<c:if test="${ pageContext.request.serverName eq 'localhost' }">
						<c:set var="appAbilUrl" value="${fn:replace(appAbil.url, 'http://10.50.5.194', 'http://localhost:9080')}"></c:set>
						<c:set var="appAbilUrl" value="${fn:replace(appAbil.url, 'https://irapwas85t01.srv.sogei.it', 'http://localhost:9080')}"></c:set>
					</c:if>
					<c:if test="${ pageContext.request.serverName eq 'fbianni' }">
						<c:set var="appAbilUrl" value="${fn:replace(appAbil.url, 'http://10.50.5.194', 'http://fbianni:9081')}"></c:set>
						<c:set var="appAbilUrl" value="${fn:replace(appAbil.url, 'https://irapwas85t01.srv.sogei.it', 'http://fbianni:9081')}"></c:set>
					</c:if>
					<li><a href="${appAbilUrl}">${appAbil.titolo}</a></li>
				</c:if>		
				<c:if test="${ fn:length(appAbil.subVoci) gt 0 }">					 					
					<!-- Voce espandibile -->
					<li class="submenu">
						<a href="#${appAbil.url}" class="collapsed" data-toggle="collapse">${appAbil.titolo}</a>
						<ul id="${appAbil.url}" class="nav collapse" aria-hidden="false">
						<c:forEach items="${appAbil.subVoci}" var="voce">
							<c:set var="voceValue"	value="${voce.value}"/>		 
							<%-- Per ambiente locale su DB di TEST --%>
							<c:if test="${ pageContext.request.serverName eq 'localhost' }">
								<c:set var="voceValue" value="${fn:replace(voce.value, 'http://10.50.5.194', 'http://localhost:9080')}"></c:set>
								<c:set var="voceValue" value="${fn:replace(voce.value, 'https://irapwas85t01.srv.sogei.it', 'http://localhost:9080')}"></c:set>
							</c:if>
							<c:if test="${ pageContext.request.serverName eq 'fbianni' }">
								<c:set var="voceValue" value="${fn:replace(voce.value, 'http://10.50.5.194', 'http://fbianni:9081')}"></c:set>
								<c:set var="voceValue" value="${fn:replace(voce.value, 'https://irapwas85t01.srv.sogei.it', 'http://fbianni:9081')}"></c:set>
							</c:if>
							<li><a href="${voceValue}">${voce.key}</a></li>
						</c:forEach>
						</ul>
					</li>
																						
				</c:if>		
			</c:forEach>													
					
		</ul>		
	</nav>
	
</div>
