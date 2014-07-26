<html>
<body>
    <h1>say hello ${name}</h1><br/>
    ${(1 == 1)?string("yes", "no")}
    <br />
    <#list ["winter", "spring", "summer", "autumn"] as x>
		${x}
	</#list>
	${xml_escape}
	<br />
	<#assign x> 
		<#list ["q", "w", "e", "r", "t", "y", "u"] as n>
			${n} 
		</#list> 
	</#assign> 
</body>
</html>