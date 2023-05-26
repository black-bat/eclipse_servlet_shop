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
        <script src="js/web.js"></script>
        <link href="css/web.css" rel="stylesheet" type="text/css">
        <style>
        h1{
        margin:0 auto;
        text-align: center;
        }
        table{
				margin:0 auto;
				text-align: center;
				width:400px;
					}
		#cart_table{
				margin:0 auto;
				text-align: center;
					}
        </style>
</head>
<body>
<header>
    <div class="px-3 py-2 text-bg-dark">
      <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <a href="/" class="d-flex align-items-center my-2 my-lg-0 me-lg-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"></use></svg>
          </a>

          <ul id="head-1" class="nav col-12 col-lg-auto my-2 justify-content-center my-md-0 text-small">
            <li>
              <a href="#" class="nav-link text-secondary">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#home"></use></svg>
                Home
              </a>
            </li>
            <li>
              <a href="#" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#speedometer2"></use></svg>
                Dashboard
              </a>
            </li>
            <li>
              <a href="Cart24" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#table"></use></svg>
                Orders
              </a>
            </li>
            <li>
              <a href="Catalog24" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#grid"></use></svg>
                Products
              </a>
            </li>
            <li>
              <a href="#" class="nav-link text-white">
                <svg class="bi d-block mx-auto mb-1" width="24" height="24"><use xlink:href="#people-circle"></use></svg>
                Customers
              </a>
            </li>
            <li>
                <jsp:include page="navigation.jsp"></jsp:include>
            </li>
          </ul>
          

          <nav class="navbar navbar-expand-lg navbar-dark" aria-label="Offcanvas navbar large">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">Buy & point</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar2" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="offcanvas offcanvas-end text-bg-dark" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbar2Label">
                <div class="offcanvas-header">
                  <h5 class="offcanvas-title" id="offcanvasNavbar2Label">Offcanvas</h5>
                  <button type="button" class="btn-close btn-close-white" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                </div>
                <div class="offcanvas-body">
                  <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">
                    <li class="nav-item">
                      <a class="nav-link active" aria-current="page" href="https://github.com/black-bat">Home</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Products
                      </a>
                      <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="Filter" type="button"  onclick="filter2()">Meat</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter8()">Fish</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter1()">Milk and Eggs</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter3()">Berries</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter4()">Fruits</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter5()">Vegetables</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter6()">Nuts</a></li>
                        <li><a class="dropdown-item" href="Filter" type="button" onclick = "filter7()">Drinks</a></li>
                      </ul>
                    </li>
                  </ul>
                  <form class="d-flex mt-3 mt-lg-0" role="search">
                     <input id="search" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <a href="Filter" class="btn btn-outline-success" type="button" onclick = "filterTitle()" metod="POST">Search</a>
                  </form>
                </div>
              </div>
            </div>
          </nav>

<br><br>
<br><br>
<br><br>

        </div>
      </div>
    </div>
    
  </header>

  <br><br>
  <br><br>
  <br><br>
  
  <div id="cat_table">
  <h1>INFO</h1>
  <table id="order_table" border="1">
 	 <tr>
 	 		<th>id</th>
  			<th>Title</th>
  			<th>Count</th>
  			<th>Price</th>
  			<th>info_order</th>
  	</tr>
  	<c:forEach var="item" items="${info}" varStatus="num">
  	<tr>
 	 		<td>${num.count}</td>
  			<td>${item.title}</td>
  			<td>${item.count}</td>
  			<td>${item.totalPrice}</th>
  			<td>${item.infoOrder}</td>
  			  	
  			</tr>
  	</c:forEach>
  </table>
  </div>
   <a id="back"  href="Order24" class="w-100 btn btn-lg btn-primary" type="submit">BACK</a>
 
  
   <footer class="py-3 my-4">
        <ul class="nav justify-content-center border-bottom pb-3 mb-3">
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Home</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Features</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">Pricing</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">FAQs</a></li>
          <li class="nav-item"><a href="#" class="nav-link px-2 text-body-secondary">About</a></li>
        </ul>
        <p class="text-center text-body-secondary">© 2023 Company, Inc</p>
      </footer>
</body>
</html>