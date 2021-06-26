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
	<div class="jumbotron text-center">
		<div class="container">
			<div class="row">
				<img alt="header image" src="https://wilcity.com/wp-content/uploads/2020/03/39875853-header-wallpapers.jpg" class="col-12" style="padding: 0px;">
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark justify-content-center">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link text-light" href="#" >List</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-light" href="${pageContext.request.contextPath}/giangvien/save" >Add</a>
			</li>
			<li class="nav-item">
				<a class="nav-link text-light" href="#" >Manager</a>
			</li>
		</ul>
	</nav>
	<div class="cotainer" style="padding: 20px">
		<div class="row">
			<div class=" dropdown col-6">
				<button type="button" class="btn btn-info dropdown-toggle" data-toggle="dropdown"> 
					Giang Vien
				</button>
				<div class="dropdown-menu">
					<c:forEach items="${giangviens }" var="gv">
						<a class="dropdown-item" href="${pageContext.request.contextPath}/giangvien/list/${gv.id}"><p>${gv.tenGV}</p></a>
   					</c:forEach>
				</div>
			</div>
		</div>
		<div class="row">
			<c:if test="${dts !=null}">
				<c:forEach var="dt" items="${dts}">
					<div class="card col-3 border border-info mt-3">
					<div class="card-header ">
						<img alt="" class="col-12 " src="${dt.urlHinh}">
					</div>
					<div class="card-body">
						<p style="font-weight: bold;" class="h5">${dt.tenDeTai }</p>
						<p>${dt.nam }</p>
						<p>${dt.moTa }</p>
					</div>
				</div>	
				</c:forEach>	
			</c:if>
			<c:if test="${dts ==null}">
				<h1>khong co de tai</h1>
			</c:if>	
		</div>
	</div>
</body>
</html>