<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/page/share/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${buyCart.items}" var="item">
	${item.product.name},${item.amount},
	<c:forEach items="${item.product.styles}" var="style">
		[${style.name}]
	</c:forEach>
	
	</br>
</c:forEach>
</body>
</html>