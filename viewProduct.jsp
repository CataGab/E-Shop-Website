<%@ page import="shop.Product"%>

<jsp:useBean id='db'
             scope='session'
             class='shop.ShopDB' />

<html>
<head>
<title>EB4Y</title>
</head>
<body>
<%
    String pid = request.getParameter("pid");
    Product product = db.getProduct(pid);
    // out.println("pid = " + pid);
    if (product == null) {
        // do something sensible!!!
        System.out.println( product );
    }
    else {
        %>
        <div align="center">
        <h2> <%= product.title %>  by <%= product.artist %> </h2>
        <img class = "bigimage" src="<%= product.fullimage %>" />
        <p> <%= product.description %> </p>
        <a href='<%="baskett.jsp?addItem="+product.PID%>' > add to basket</a>
        </div>
        <%
    }
%>
</body>
</html>
