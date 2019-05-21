<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="venBean" class="beans.VendorBean" scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>





</head>
<%-- <jsp:setProperty property="*" name="venBean" /> --%>
<body>
<form action="" method="get">
	<table style="background-color: cyan; margin: auto;" border="1">
		<c:forEach var='v' items="${sessionScope.venBean.vendorList}">

			<tr>

				<td>${v.name}</td>
				<td>${v.email}</td>
				<td>${v.city}</td>
				<td>${v.role}</td>
				<td><input type="submit" name="vid" value='${v.id}'
					formaction="update.jsp">Update</td>
				<td><input type="submit" name="vid" value='${v.id}'
					formaction="delete.jsp">Delete</td>
			</tr>
		</c:forEach>
	</table>
	</form>
</body>
</html>