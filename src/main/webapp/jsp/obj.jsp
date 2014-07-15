<!-- 测试ajax发送请求到后台服务，请求的参数被包装成一个对象 -->


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:set var="pageFont" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>

<script type="text/javascript" src="${pageFont}/js/jquery-1.8.3.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>main</title>

<script type="text/javascript">

$(function(){
	
	var obj = {
			name : 'lichencai',
			address : 'shantou'
		}
	
	$("input[name='sendReq']").click(function(){
		$.ajax({
	        url : '${pageFont}/web/obj/putdata',
	        data : obj,
	        type : "POST",
	        dataType : 'json',
	        success : function(data){
	        	console.log(data);
	        }
		});
	});
	
})


</script>

</head>
<body>

<input type="button" value="发送请求" name="sendReq"/>

</body>
</html>