<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
	
<!-- Layout a 1 colonna -->
<div class="row">
	<div class="col-sm-12"> 				
		<ul class="alert alert-danger" role="alert">
			Autorizzazione fallita!
			<li> L'autenticazione è stata eseguita correttamente ma l'utente non ha i permessi per accedere a nessuna funzionalità. <html:link action="/Logoff.do?Off=Esci">Esci</html:link></li>
		</ul>
	</div>
</div>
