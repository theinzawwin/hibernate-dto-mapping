<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Record Attendance</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<form action="att_list.htm">
<div class="row">
	<div class="col-lg-3">
		<label>Select Grade</label>
		<select name="gradeId" class="form-control">
			<option value="0">Select Grade</option>
			<c:forEach items="${gradeList }" var="g">
				<option value="${g.id}">${g.name}</option>
			</c:forEach>
		</select>
	</div>
	
	<div class="col-lg-2">
	<br>
		<button class="btn btn-primary" type="submit">Search</button>
	</div>
</div>
</form>
<form:form action="save_attendance.htm" method="post" modelAttribute="attendanceListDTO">


<div class="row">
	<div class="col-4">
		<div class="form-group">
		<label>Select Date</label>
		<input type="date" name="date" class="form-control" />
	</div>
	</div>
	<div class="col-lg-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<td>No#</td>
					<th>RollNo</th>
					<th>Name</th>
					<th>Attendance Status</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentList }" var='std' varStatus="row">
					<tr>
						<td>${row.count }
							<form:hidden path="attList[${row.index }].studentId" value="${std.id}"/>
						</td>
						<td>${std.rollNo }</td>
						<td>${std.name }</td>
						<td>
							<form:select path="attList[${row.index }].status"  class="form-control">
								<option value="true">Present</option>
								<option value="false">Absent</option>
							</form:select>
						</td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="col-lg-12">
		<button class="btn btn-primary"> Save</button>
	</div>
</div>
</form:form>
</div>
</body>
</html>