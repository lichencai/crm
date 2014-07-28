<html>
<body>
    <h1>say hello ${name}</h1><br/>
    ${(1 == 1)?string("yes", "no")}
    <br />
    <#list ["winter", "spring", "summer", "autumn"] as x>
		${x}
	</#list>
	<br />
	
	<!#-- 对变量进行赋值 -->
	<#assign x="张三">
	${x}
</body>
</html>