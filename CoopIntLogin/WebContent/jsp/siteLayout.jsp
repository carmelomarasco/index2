<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
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
		<link rel="stylesheet" href="resources/css/app/common.css" />
		<!-- CSS comune per l'header e il footer -->
		<link rel="stylesheet" href="resources/css/app/header-footer.css" />
		<!-- CSS comune per i menu -->
		<link rel="stylesheet" href="resources/css/app/menu.css" />
		<!-- CSS specifico per l'Agenzia (sogei.css, agenzia-entrate.css, dogane-monopoli.css) -->
		<link rel="stylesheet" href="resources/css/app/agenzia-entrate.css" />
		<!-- CSS specifico di ogni applicazione (l'unico da modificare) -->
		<link rel="stylesheet" href="resources/css/app/app.css" />
	</head>
	<body>
	
		<tiles:insert attribute="header" ignore="true"/>
		<tiles:insert attribute="menuOrizzontale" ignore="true"/>
		<main role="main" id="main">
			<div class="container-fluid">
				<div class="row">
					<tiles:insert attribute="content" ignore="true" flush="true"/>			
				</div>
			</div>
		</main>
		<tiles:insert attribute="footer" ignore="true"/>

		<!-- JS per importare jQuery -->
		<script type="text/javascript" src="resources/js/jquery.min.js"></script>
		<!-- JS per importare Bootstrap -->
		<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
	</body>
</html>