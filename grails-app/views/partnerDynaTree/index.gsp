<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Dynatree demo with Grails</title>
	</head>
	<body>

		<r:require module="dynatree"/>

		<r:script disposition="head">
		    $(function() {
		    	$("#tree").dynatree({
		    	    initAjax: {
				        url: "${createLink(action:'treeData')}"
        			}
		    	});
		    });
		</r:script>

		<div id="tree"/>
	</body>
</html>