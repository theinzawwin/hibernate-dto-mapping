<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department List</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<a href="department/create_department.htm">New Department</a>
 <div class="col-lg-12">
 	<table class="table table-info">
 		<thead>
 			<tr>
 				<th>No</th>
 				<th>Name</th>
 				<th>Action</th>
 			</tr>
 		</thead>
 		<tbody>
 			<c:forEach items="${department_list}" varStatus="row" var="d">
 				<tr>
 					<td>${row.count}</td>
 					<td>${d.name }</td>
 					<td><a href="#" class="btn btn-sm btn-info">Edit</a><a href="#" class="btn btn-sm btn-danger">Delete</a></td>
 				</tr>
 			</c:forEach>
 		</tbody>
 	</table>
 </div>
</div>
</body>
</html>