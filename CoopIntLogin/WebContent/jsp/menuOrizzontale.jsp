<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if test="${ fn:length(menuOrizzontale.elenco) gt 1 }">
<style type="text/css">
.navbar-nav > li {
    width: ${100/fn:length(menuOrizzontale.elenco)}%;
}
</style>
</c:if>
<nav role="navigation" aria-label="Menu principale">
	<h1 class="sr-only">Menu principale</h1>
	<div class="navbar">
		<div class="container-fluid">

			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#menu-top" aria-expanded="false">
					<span class="sr-only">Apri menu principale</span>
					<i class="fa fa-bars fa-lg"></i>
				</button>
				<span class="navbar-brand visible-xs">Menu</span>
			</div>

			<div class="collapse navbar-collapse" id="menu-top">
				<ul class="nav navbar-nav">
					<c:forEach items="${menuOrizzontale.elenco}" var="area">
					
						<c:if test="${ fn:length(area.subVoci) eq 0 }">
							<c:choose><c:when test="${area.titolo eq titoloMenu}">
								<li class="active"></c:when>
	                        <c:otherwise><li></c:otherwise>
                            </c:choose>
                            <a href="/CoopIntLoginWeb/Aut.do?login=ok&a=${area.titolo}"><i class="fa fa-home"></i>${area.titolo}</a></li>										 
						</c:if>		
						<!-- Voce con sotto-menu -->
						<c:if test="${ fn:length(area.subVoci) gt 0 }">	
							<c:set var="testSubMenu" value="${false}"></c:set>
							<c:forEach items="${area.subVoci}" var="voce">
								<c:if test="${voce.key eq titoloMenu}">
									<c:set var="testSubMenu" value="${true}"></c:set>
								</c:if>
							</c:forEach>				 
							<c:choose><c:when test="${testSubMenu eq true}">
								<li class="dropdown active"></c:when>												
	                        <c:otherwise><li class="dropdown"></c:otherwise>											
                            </c:choose>                           
							<a href="" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-font-awesome"></i>${area.titolo}<i class="fa fa-caret-down"></i>
							</a>
							<ul class="dropdown-menu">
							<c:forEach items="${area.subVoci}" var="voce">
								<li><a href="/CoopIntLoginWeb/Aut.do?login=ok&a=${voce.key}">${voce.key}</a></li>
							</c:forEach>
							</ul>
							</li>										 											
						</c:if>		
					</c:forEach>								

				</ul>
			</div>
		</div>
	</div>
</nav>
