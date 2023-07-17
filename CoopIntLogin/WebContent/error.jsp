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
		<!-- CSS specifico per l'Agenzia -->
		<link rel="stylesheet" href="resources/css/login/agenzia-entrate-login.css" id="agenzia-theme" />
    </head>
 
    <body>
    	<div class="container-fluid">
    		<header id="page-header">
		    	<div class="row">
		    		<div class="col-xs-3 col-md-2 text-right">
	    				<img src="" alt="" class="logo" />
		    		</div>
		    		<div class="col-xs-9 col-md-10">
		  				<h1><bean:message key="coopint.title" /> - <bean:message key="coopint.subtitle" /></h1>
			    		<hr aria-hidden="true" class="hidden-xs" />
		    		</div>
	    		</div>
    		</header>

			<div id="error-page" class="row">
	    		<div class="col-xs-4 text-right">
					<i class="fa fa-warning fa-4x"></i>
   				</div>
	    		<div class="col-xs-8">
	    			<h2>Il sistema non &egrave; al momento disponibile</h2>
   					<p>Ci scusiamo per l'inconveniente.</p>
					<p>Si prega di riprovare pi&ugrave; tardi.</p>
	    		</div>
    		</div>

			<footer id="page-footer">
			    <hr aria-hidden="true" />
				<p>&copy; <strong>Agenzia delle Entrate</strong></p>
			</footer>
		</div>
		
		<!-- JS per importare jQuery -->
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
	</body>
</html>