<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<h3>Teacher List</h3>
<div class="row">

	<div class="col-lg-8">
	<a href="<c:url value='/teacher/create_teacher.htm' />">New Teacher</a>
	<table class="table table-bordered table-responsive">
	<thead>
		<tr>
			<th>No</th>
			<th>Name</th>
			<th>Nrc</th>
			<th>Email</th>
			<th>Education</th>
			<th>Department</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${teacherList }" var="t" varStatus="row">
			<tr>
				<td>${row.count }</td>
				<td>${t.name }</td>
				<td>${t.nrc }</td>
				<td>${t.email }</td>
				<td>${t.educationDesc }</td>
				<td>${t.departmentName }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	</div>
</div>

</div>

</body>
</html>