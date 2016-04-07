<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="view/table.css">
</head>
<body>
	<center>
		<h3>${title }</h3>
		<table id="table_content">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>성별</th>
				<th>주소</th>
				<th>전화</th>
			</tr>
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.no }</td>
					<td>${vo.name }</td>
					<td>${vo.sex }</td>
					<td>${vo.addr }</td>
					<td>${vo.tel }</td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>



