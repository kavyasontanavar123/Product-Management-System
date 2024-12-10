<%@page import="com.example.product.entity.Product"%>
<%@page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Product</title>
</head>
<body>
    <%
        // Fetch the product object passed from the controller
        Product product = (Product) request.getAttribute("product");
    %>

    <h2>Update Product</h2>
    <form action="update-product" method="post">
       
        <input type="number" name="id" value="<%= product.getId() %>" readonly="readonly" />

        <input type="text" name="title" placeholder="Enter the title" value="<%= product.getTitle() %>" >
        <input type="text" name="description" placeholder="Enter the description" value="<%= product.getDescription() %>" >
        <input type="number" name="quantity" placeholder="Enter the quantity" value="<%= product.getQuantity() %>" >
        <input type="number"  name="price" placeholder="Enter the price" value="<%= product.getPrice() %>" >
        
        <input type="submit" value="Update Product">
    </form>
</body>
</html>
