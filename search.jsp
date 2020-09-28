<%@ page import="shop.Product"%>
<%@ page import="java.util.*"%>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB' />

<html>
<head>
<head>
	<title>EB4Y</title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="my.css">

<script>
    var allurl = window.location.search.substring(1).split('=');
    var query = allurl[0];
    if(query == "addItem"){
        window.location.replace("http://localhost:8080/ass2/baskett.jsp");
    }
</script>

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

 
<%
	String cautare = request.getParameter("searchWord").toLowerCase();
	String q="Select * from PRODUCT where lower(ARTIST) Like '%" + cautare + "%'";
	Collection list = db.getProductCollection(q);
	Integer len = cautare.length();
	if(len>=2 && list.size() > 0){
%>
<table>
<tr>
<th> Title </th> <th> Price </th> <th> Picture </th>
</tr>
<%
    for (Product product : db.getProductCollection(q) ) {
        // now use HTML literals to create the table
        // with JSP expressions to include the live data
        // but this page is unfinished - the thumbnail
        // needs a hyperlink to the product description,
        // and there should also be a way of selecting
        // pictures from a particular artist
        %>
        <tr>
             <td> <%= product.title %> </td>
             <td> &pound;<%= product.price/100+"."+product.price%100 %> </td>
             <td> <a href = '<%="productview.jsp?pid="+product.PID%>'> <img src="<%= product.thumbnail %>"/> </a> </td>
        </tr>
        <%
    }
 %>
 </table>
	<%}else{
	%>
	<h1>No Result Found!</h1>
	<%}
	%>
	</div>
</body>
</html>
