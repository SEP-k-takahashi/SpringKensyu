<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%!HttpServletRequest request;
	String name;
	String address;
	String tel;
	String categoryid;
	String errmsg;
	String category;
	ResultSet rs = Common.getCategoryAll();%>
<%
	if ((String) request.getAttribute("name") == null) {
		name = "";
		address = "";
		tel = "";
		category = "";
		errmsg = "";
	} else {
		name = (String) request.getAttribute("name");
		address = (String) request.getAttribute("address");
		tel = (String) request.getAttribute("tel");
		category = (String) request.getAttribute("categoryid");
		errmsg = (String) request.getAttribute("errmsg");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>住所録管理システム：住所録登録</h1>
	<br>
	<p>
		名前：<%=name%>
	</p>
	<p>
		住所：<%=address%>
	</p>
	<p>
		電話番号：<%=tel%>
	</p>
	<input type="submit" value="登録">
	<input type="submit" value="戻る">
</body>
</html>