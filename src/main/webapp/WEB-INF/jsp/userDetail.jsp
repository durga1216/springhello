<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Submitted User Information</h2>
	<table border="1">
		<tbody>
			 
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Dispatch Address</th>
				<th>Amount</th>
				<th>Order_ID</th>
				<th>Order_History</th>

			</tr>

			               

			<c:forEach var="user" items="${users}" varStatus="status">
                <tr>
					<td><c:out value="${user.user_id}" /></td>
					<td><c:out value="${user.first_name}" /></td>
					<td><c:out value="${user.last_name}" /></td>
					<td><c:out value="${user.dispathchAddress}" /></td>
					<td><c:out value="${user.amount}" /></td>
					<td><c:out value="${user.order_ids}" /></td>
					<td>
					<c:forEach items="${user.order_history}" var="userMap" varStatus="status">
		
			        <c:out value="${userMap.key}"/>->
			        <c:out value="${userMap.value}"/><br>
		
                	</c:forEach>
	 				</td>


				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>
