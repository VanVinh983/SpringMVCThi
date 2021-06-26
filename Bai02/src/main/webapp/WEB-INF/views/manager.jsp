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
	<c:url value="" var="update">
		<c:param name="tacvu" value="update" />
	</c:url>
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
			<div class=" dropdown col-6">
				<button type="button" class="btn btn-info dropdown-toggle"
					data-toggle="dropdown">Giang Vien</button>
				<div class="dropdown-menu">
					<c:forEach items="${giangviens }" var="gv">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/giangvien/manager/${gv.id}"><p>${gv.tenGV}</p></a>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ten de tai</th>
							<th>nam</th>
							<th>mo ta</th>
							<th>update/delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dt" items="${dts}">
							<tr>
								<td>${dt.tenDeTai }</td>
								<td>${dt.nam }</td>
								<td>${dt.moTa }</td>
								<td>
									<c:url value="/giangvien/delete" var="delete">
										<c:param name="delete" value="${dt.id}" />
										<c:param name="giangvien" value="${dt.giangVien.id}"/>
									</c:url> 
									<c:url value="/giangvien/update" var="update">
										<c:param name="update" value="${dt.id}" />
									</c:url>
									<a href="${delete}">delete</a>/<a href="${update }">update</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>