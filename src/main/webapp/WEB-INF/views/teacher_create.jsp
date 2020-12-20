<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h3 class="title">New Teacher</h3>
<form:form action="${pageContext.request.contextPath}/teacher/create_teacher.htm" method="post" modelAttribute="teacherDTO">

	<div class="row">
		<div class="col-lg-6">
		<div class="form-group">
				<label for="departmentId">Department</label>
				<form:select path="departmentId" class="form-control" items="${departmentList }" itemLabel="name" itemValue="id">
				
				</form:select>
			</div>
			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="nrc">Nrc</label>
				<form:input path="nrc" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="email">Email</label>
				<form:input path="email" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="educationDesc">Education Records</label>
				<form:input path="educationDesc" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Save" class="btn btn-primary" />
				<input type="reset" value="Reset" class="btn btn-warning" />
			</div>
		</div>
	</div>
	</form:form>
</div>
</body>
</html>