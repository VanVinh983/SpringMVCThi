<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script src="https://kit.fontawesome.com/c5f90f79c0.js"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="jumbotron jumbotron-fluid text-center">
		<div class="container-fluid">
			<div class="row">
				<img alt="header image"
					src="https://wilcity.com/wp-content/uploads/2020/03/39875853-header-wallpapers.jpg"
					class="col-12" style="padding: 0px;">
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark justify-content-center">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link text-light"
				href="${pageContext.request.contextPath}/giangvien/list">List</a></li>
			<li class="nav-item"><a class="nav-link text-light" href="#">Add</a>
			</li>
			<li class="nav-item"><a class="nav-link text-light" href="#">Manager</a>
			</li>
		</ul>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-12 justify-content-center">
				<form:form
					action="${pageContext.request.contextPath}/giangvien/saveform"
					modelAttribute="dt" method="post">

					<table class="table table-striped">
						<tbody>
							<tr>
								<form:hidden path="id"/>
								<td><form:label path="tenDeTai">ten De Tai: </form:label></td>
								<td><form:input path="tenDeTai"/>
									<form:errors path="tenDeTai" cssClass="text-danger"/>
								</td>
							</tr>
							<tr>
								<td><form:label path="nam">nam: </form:label></td>
								<td><form:input path="nam" /><form:errors path="nam" cssClass="text-danger"/></td>
							</tr>
							<tr>
								<td><form:label path="moTa">mo ta: </form:label></td>
								<td><form:input path="moTa" /> <form:errors path="moTa" cssClass="text-danger"/></td>
							</tr>
							<tr>
								<td><form:label path="urlHinh">link anh: </form:label></td>
								<td><form:input path="urlHinh" /> <form:errors path="urlHinh" cssClass="text-danger"/></td>
							</tr>
							<tr>
								<td><form:label path="giangVien.id">giang vien: </form:label>
								</td>
								<td><form:select path="giangVien.id">
										<c:forEach items="${giangviens }" var="gv">
											<form:option value="${gv.id}">${gv.tenGV}</form:option>
										</c:forEach>
									</form:select></td>
							</tr>
							<tr>
								<td><input class="btn btn-success" type="submit"
									value="submit"></td>
							</tr>
						</tbody>
					</table>

				</form:form>
			</div>
		</div>
	</div>
</body>
</html>