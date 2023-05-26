<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:if test="${Username =='admin'}">
 <div id="cat_table">
  <h1>ORDERS</h1>
  <table id="order_table" border="1">
 	 <tr>
 	 		<th>id</th>
  			<th>Date</th>
  			<th>User</th>
  			<th>info_order</th>
  			<th>Status</th>
  			<th>Show</th>
  			<th>Change</th>
  	</tr>
  	<c:forEach var="item" items="${orders}" varStatus="num">
  	<tr>
 	 		<td>${num.count}</td>
  			<td>${item.date}</td>
  			<td>${item.user}</td>
  			<td>${item.info_order}</th>
  			<td>${item.status}</td>
  			<td><button onclick="show('${item.info_order}')" type="submit" method="GET">Show</button></td>
  			<td><button onclick="change(${item.id})" type="submit" method="POST">Change</button></td>
  	</tr>
  	</c:forEach>
  </table>
  </div>
</c:if>
<c:if test="${Username !='admin'}">
<div id="cat_table">
  <h1>ORDERS</h1>
  <table id="order_table" border="1">
 	 <tr>
 	 		<th>id</th>
  			<th>Date</th>
  			<th>User</th>
  			<th>info_order</th>
  			<th>Status</th>
  			<th>Show</th>
  	</tr>
  	<c:forEach var="item" items="${orders}" varStatus="num">
  	<tr>
 	 		<td>${num.count}</td>
  			<td>${item.date}</td>
  			<td>${item.user}</td>
  			<td>${item.info_order}</th>
  			<td>${item.status}</td>
  			<td><button onclick="show('${item.info_order}')" type="submit" method="GET">Show</button></td>
  			</tr>
  	</c:forEach>
  </table>
  </div>
</c:if>