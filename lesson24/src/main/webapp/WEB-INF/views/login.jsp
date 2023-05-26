<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="js/jquery-3.6.4.js"></script>
        <script src="js/logreg.js"></script>
        <link href="css/logreg.css" rel="stylesheet" type="text/css">
</head>
<body class="text-center">
  
<main class="form-signin w-100 m-auto">
  <form id="f" >
    
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div id="login" class="form-floating">
      <input id="lgn" type="text" class="form-control" placeholder="name@example.com">
      <label for="floatingInput">Login</label>
    </div>
    <div  id="password"  class="form-floating">
      <input id="pass" type="password" class="form-control" placeholder="Password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      <label>
        <input type="checkbox" value="remember-me"> Remember me
      </label>
    </div>
    <button id="log" onclick = "logTo()" method="POST" class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-body-secondary">welcome to my website</p>
  </form>
</main>

</body>
</html>