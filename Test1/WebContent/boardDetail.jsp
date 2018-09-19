<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="kr.itedu.test1.*"%>
<%
	BoardVO vo = (BoardVO)request.getAttribute("boardDetail");
%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/detail.css">
</head>
<body>
	<a href="boardlist">메인으로 가기</a>
	
	<h1><%=vo.getBtitle() %></h1>
	<table id=okdk>
		<tr>
			<td>작성일시</td>
			<td>수정일시</td>
			<td>내용</td>
		</tr>
		<tr>
			<td><%=vo.getBregdate()%></td>
			<td><%=vo.getEditdate()%></td>
			<td><%=vo.getBcontent()%></td>
		</tr>
	</table>
	
	<a href="boardRegMod?bid=<%=request.getParameter("bid")%>"><input type="submit" id="edit" value="수정"></a>
	
</body>
</html>