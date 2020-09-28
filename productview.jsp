<!DOCTYPE html>
<html>
<head>
	<title>EB4Y</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="my.css">


</head>
<body>

<!-- Start of top menu css-->
<div align="left" class="top-text">
	<img class="logo" src="ebaylogo.png">
</div>
<div class="top">
<ul>

  <li><a href="baskett.jsp" >Basket</a></li>

</ul>
</div>
<!-- End of top menu -->


<!-- Start of left menu-->

<div class="vertical-menu">
 
  <a href="Home.jsp">HOME</a>
  <a class="active" href="product.jsp">Products</a>
 

	
	<p>Artist Search:</p>
	<form action="search.jsp" method="get">
		
		<input type="search" name="searchWord" placeholder="Search"/>
	</form>
	
	<p>Price Search:</p>
	<form action="priceSearch.jsp" method="get">
		<input type="number" name="From" min="0" required placeholder="From"/>
		<input type="number" name="To" min="0" required placeholder="To"/>
		<button type="submit">Search</button>
	</form>

</div>
<!-- End of left menu-->

<div class="table">

 <%@include file="viewProduct.jsp" %>
</div>

</body>
 