<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Store</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" />

<link rel="stylesheet" href="/css/style.css">



</head>

<body>
	

<!-- 	<section id="featured" class="my-5 pb-5"> -->
<!-- 	<div class="container text-center mt-5 py-5"></div> -->
	<div class="container">
		<div class="card w-50 mx-auto my-5" style="background-color: gainsboro;">
			<div class="card-header text-center">New User Registration</div>
			<div class="card-body">
				<form action="signup" method="post">
					
						<c:if test="${param.email!=null}">
							<p style="color: red">user name or email already exists please enter again</p>
						</c:if>
						<div class="form-group">
						<label>User Name</label> <input type=text name="username" required
							class="form-control" placeholder="Enter UserName">
					</div>
					<div class="form-group">
						<label>User email</label> <input type=text name="email" required
							class="form-control" placeholder="Enter User email">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							required class="form-control" placeholder="Enter Password">
					</div>
					<div class="form-group">
						<label>city</label> <input type="text" name="city" required
							class="form-control" placeholder="Enter City">
					</div>
					<div class="form-group">
						<label>phoneNo</label> <input type="text" name="phoneNo" required
							class="form-control" placeholder="Enter phoneNo">
					</div>

					<div class="text-center">
						<input type="submit" class="btn btn-lg btn-primary btn-block"
							value="signup" />
					</div>
				</form>
			</div>
		</div>
	</div>
<!-- 	</section> -->

	
</body>
</html>