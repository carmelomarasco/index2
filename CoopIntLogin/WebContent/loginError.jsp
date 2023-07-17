<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html lang="it">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />

		<title><bean:message key="coopint.title" /> - <bean:message key="coopint.subtitle" /></title>

		<!-- CSS per importare Bootstrap -->
		<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
		<!-- CSS per importare FontAwesome -->
		<link rel="stylesheet" href="resources/css/font-awesome.min.css" />
		<!-- CSS per importare il font Titillium -->
		<link rel="stylesheet" href="resources/css/titillium.css" />
		<!-- CSS comune per tutte le applicazioni -->
		<link rel="stylesheet" href="resources/css/login/common-login.css" />
		<!-- CSS specifico per l'Agenzia (sogei-login.css, agenzia-entrate-login.css, dogane-monopoli-login.css) -->
		<link rel="stylesheet" href="resources/css/login/agenzia-entrate-login.css" id="agenzia-theme" />
    </head>
 
    <body id="login-page">
		<div class="container-fluid">
    		<header id="page-header">
		    	<div class="row">
		    		<div class="col-xs-3 col-md-2 text-right">
	    				<img src="resources/img/CoopInt_logo_152.png" alt="" class="logo" />
		    		</div>
		    		<div class="col-xs-9 col-md-10">
		  				<h1><bean:message key="coopint.title" /> - <bean:message key="coopint.subtitle" /></h1>
			    		<hr aria-hidden="true" class="hidden-xs" />
		    		</div>
	    		</div>
    		</header>

			<form id="login-form" action="/CoopIntLoginWeb/j_security_check">
				<div class="form-group">
					<label for="j_username" class="control-label">Codice fiscale:</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-user"></i></div>
						<input id="j_username"name="j_username" class="form-control" type="text" maxlength="16" autocomplete="off" required autofocus />
					</div>
				</div>
				<div class="form-group">
					<label for="j_password" class="control-label">Parola Chiave:</label>
					<div class="input-group">
						<div class="input-group-addon"><i class="fa fa-lock"></i></div>
						<input id="j_password" name="j_password" class="form-control" type="password" autocomplete="off" required />
					</div>
				</div>
				
				<p id="message" class="alert alert-danger" role="alert" tabindex="0"></p>
				
				<ul class="alert alert-danger" role="alert">
				L'autenticazione può essere fallita per i seguenti motivi:
					<li>Il Codice fiscale o la Parola Chiave potrebbero essere stati digitati in modo errato;</li>
					<li>Il Codice fiscale o la Parola Chiave non esistono;</li>
					<li>La Parola Chiave è scaduta, o le credenziali sono state disabilitate.</li>
				</ul>			

				<button id="login-button" type="submit" class="btn btn-primary btn-block">
					<i class="fa fa-sign-in"></i>Accedi
				</button>
			</form>

			<footer id="page-footer">
			    <hr aria-hidden="true" />
				<p>&copy; <strong>Agenzia delle Entrate</strong></p>
			</footer>
		</div>
		
		<!-- JS per importare jQuery -->
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	</body>
</html>