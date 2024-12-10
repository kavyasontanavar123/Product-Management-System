<%@page import="java.util.List"%>
<%@page import="com.example.product.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management</title>
<!-- Internal CSS for styling -->
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    h1 {
        text-align: center;
        margin-top: 20px;
        color: #333;
    }

    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
    }

    table th, table td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ddd;
    }

    table th {
        background-color: #007BFF;
        color: white;
    }

    table tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        padding: 6px 12px;
        color: white;
        text-decoration: none;
        border-radius: 4px;
        font-size: 14px;
    }

    a.edit {
        background-color: #28a745;
    }

    a.delete {
        background-color: #dc3545;
    }

    a:hover {
        opacity: 0.8;
    }
</style>
</head>
<body>

    <h1>Product List</h1>

    <%
    List<Product> products = (List<Product>) request.getAttribute("products");
    %>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Product product : products) {
            %>
            <tr>
                <td><%=product.getId()%></td>
                <td><%=product.getTitle()%></td>
                <td><%=product.getDescription()%></td>
                <td><%=product.getQuantity()%></td>
                <td><%=product.getPrice()%></td>
                <td><a href="update-product?product_id=<%=product.getId()%>" class="edit">EDIT</a></td>
                <td><a href="delete-product?product_id=<%=product.getId()%>" class="delete">DELETE</a></td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>

</body>
</html>
