<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Department</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h3 class="title">Create New Department</h3>
<form:form action="${pageContext.request.contextPath}/department/create_department.htm" method="post" modelAttribute="departmentDTO">


 <div class="mb-3 row border my-5">
 
    <label for="staticEmail" class="col-sm-2 col-form-label">Name</label>
    <div class="col-sm-5">
      <form:input type="text" path="name" class="form-control"  />
    </div>
  </div>
  <div class="mb-3 row">
   <input type="submit" class="btn btn-success" value="Save"><input type="reset" class="btn btn-default" value="Reset">
  </div>
  </form:form>
</div>
</body>
</html>