<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'editItems.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<form action="items/editItemsSubmit.action" method="post">
		<input type="hidden" name="id" value="${itemsCustomer.id }">
		<h3>修改商品信息</h3>
		<c:if test="${objectErrors!=null }">
			<c:forEach items="${objectErrors}" var="error">
				${error.defaultMessage }
			</c:forEach>
		</c:if>
		<table border="1">
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="items_name" value="${itemsCustomer.items_name }"></td>
			</tr>
			<tr>
				<td>商品价格</td>
				<td><input type="text" name="items_price" value="${itemsCustomer.items_price }"></td>
			</tr>
			<tr>
				<td>生产时间</td>
				<td><input type="text" name="items_creattime" value="<fmt:formatDate value="${itemsCustomer.items_creattime }" pattern="yyyy:MM:dd HH:mm:ss"/>"></td>
			</tr>
			<tr>
				<td>商品描述</td>
				<td><input type="text" name="items_detail" value="${itemsCustomer.items_detail }"></td>
			</tr>
		</table>
		<input type="submit" value="提交">
        <input type="reset" value="重置">
	</form>

</body>
</html>