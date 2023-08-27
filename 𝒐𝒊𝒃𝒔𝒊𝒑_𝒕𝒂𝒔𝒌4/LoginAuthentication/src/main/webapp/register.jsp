<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
</head>
<body>

	<!-- navbar start -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-custom">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp">Home <span class="sr-only"></span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="register.jsp">Register</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<!-- navbar end -->

	<!-- Registration -->


	<!--Form -->
	<div class="container">
		<div class="row mt-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-header text-center c-head text-white">
						<i class="fa fa-user-circle fa-3x" aria-hidden="true"></i>
						<h4>Registration Page</h4>
					</div>
					<%
					String regMsg = (String) session.getAttribute("reg-msg");
					if (regMsg != null) {
					%>
					<div class="alert alert-success" role="alert"><%=regMsg%>Login.....<a
							href="login.jsp">Click here</a>
					</div>
					<%
								session.removeAttribute("reg-msg");			
					}
					%>
 					<div class="card-body">
						<form action="RegisterServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Name</label> <input type="text"
									class="form-control" id="exampleInputEmail1" name="uname"
									aria-describedby="emailHelp" placeholder="Enter email"
									required="required"> <label for="exampleInputEmail1">Email</label>
								<input type="email" class="form-control" id="exampleInputEmail1"
									name="email" aria-describedby="emailHelp"
									placeholder="Enter email" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									name="password" placeholder="Password" required="required">
							</div>
							<button type="submit"
								class="btn btn-primary btn-block badge-pill">Submit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>