<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Employee Data Form</h2>
	<form:form action="save.html" method="POST">
		<table>
			<tbody>
				<tr>
					<td><form:label path="user_id">User ID:</form:label></td>
					<td><form:input path="user_id" value="${user.user_id}" /></td>
				</tr>
				<tr>
					<td><form:label path="first_name">First Name:</form:label></td>
					<td><form:input path="first_name" value="${user.first_name}" /></td>
				</tr>

				<tr>
					<td><form:label path="last_name">Last Name:</form:label></td>
					<td><form:input path="last_name" value="${user.last_name}" /></td>
				</tr>

				<tr>
					<td><form:label path="dispathchAddress">Dispatch Address</form:label></td>
					<td><form:input path="dispathchAddress"
							value="${user.dispathchAddress}" /></td>
				</tr>

				<tr>
					<td><form:label path="amount">Amount</form:label></td>
					<td><form:input path="amount" value="${user.amount}" /></td>
				</tr>

				<tr>
					<td><form:label path="order_ids">Order_Id</form:label></td>
					<td><form:input path="order_ids" value="${user.order_ids}" /></td>
				</tr>



				<tr>
					<td colspan="2"><input type="submit" value="Submit" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
	<c:if test="${!empty users}">
		<h2>List Users</h2>
		<table align="left" border="1">
			<tr>
				<th>User ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Dispatch Address</th>
				<th>Amount</th>
				<th>Order_id</th>
				<th>Order_History</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.user_id}" /></td>
					<td><c:out value="${user.first_name}" /></td>
					<td><c:out value="${user.last_name}" /></td>
					<td><c:out value="${user.dispathchAddress}" /></td>
					<td><c:out value="${user.amount}" /></td>
					<td><c:out value="${user.order_ids}" /></td>
					<td><c:forEach items="${user.order_history}" var="userMap"
							varStatus="status">
							<c:out value="${userMap.key}" />->
			        <c:out value="${userMap.value}" />
							<br>

						</c:forEach></td>
					<td align="center"><a href="edit.html?id=${user.user_id}">Edit</a>
						| <a href="delete.html?id=${user.user_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
