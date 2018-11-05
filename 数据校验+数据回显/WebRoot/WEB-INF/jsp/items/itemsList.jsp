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

<title></title>

<script type="text/javascript">
	function deleteItems() {
		document.itemsForm.action="items/deleteItems.action";
		document.itemsForm.submit();
	}
	
	function queryItems() {
		document.itemsForm.action="items/queryItems.action";
		document.itemsForm.submit();
	}
	
	function editItemsQuery() {
		document.itemsForm.action="items/editItemsQuery.action";
		document.itemsForm.submit();
	}
	
</script>

</head>

<body>
	<form name="itemsForm" action="items/queryItems.action" method="post">
		<table border="1">
			<tr>
				<td><input type="text" name="itemsCustomer.items_name"></td>
				<td><input type="button" value="搜索商品" onclick="queryItems()"></td>
				<td><input type="button" value="批量删除" onclick="deleteItems()"></td>
				<td><input type="button" value="批量修改" onclick="editItemsQuery()"></td>
			</tr>
		</table>

		<h3>商品列表</h3>
		<table border="1" width="100%">
			<tr>
				<td>选择</td>
				<td>商品名称</td>
				<td>商品价格</td>
				<td>生成时间</td>
				<td>商品描述</td>
				<td>修改商品</td>
				<td>删除商品</td>
			</tr>
			<c:forEach items="${itemsList}" var="item">
				<tr>
					<td><input type="checkbox" name="items_ids" value="${item.id }"></td>
					<td>${item.items_name }</td>
					<td>${item.items_price }</td>
					<td><fmt:formatDate value="${item.items_creattime }" pattern="yyyy:MM:dd HH:mm:ss"/></td>
					<td>${item.items_detail }</td>

					<td><a
						href="items/editItems.action?id=${item.id}">修改</a></td>
					<td><a
						href="items/deleteItemsById.action?id=${item.id}">删除</a></td>
				</tr>
			</c:forEach>	
		</table>
	</form>
</body>
</html>
