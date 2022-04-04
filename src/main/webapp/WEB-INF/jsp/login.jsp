<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<%@ include file="head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="card w-50 mx-auto my-5" style="background-color: gainsboro;">
			<div class="card-header text-center" style="color: green;">User Login</div>
			<div class="card-body">
				<form action="login" method="post">
					<c:if test="${param.error!=null}">
						<p style="color: red">You entered wrong credentials!</p>
					</c:if>
					<c:if test="${param.logout!=null}">
						<p style="color: green">You have successfully logged out.!</p>
					</c:if>
					<div class="form-group">
						<label>Email</label> <input type=text name="email" required
							class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							required class="form-control" placeholder="Password">
					</div>
					<div class="text-center">
						<input type="submit" class="btn btn-lg btn-primary btn-block"
							value="login" />
					</div>
				</form>
				<br> 
				<span class="form-signin" action="signup" method="get"> <a
					href="signup" style="color: green"> SignUp Here for new user
						register</a></span>
			</div>
		</div>
	</div>
</body>
</html>