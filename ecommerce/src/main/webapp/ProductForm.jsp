<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product store web</title>
</head>
<body>
    <center>
        
        <h2>
            <a href="/new">Add New Product</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Product</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${product != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${product == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${product != null}">
                        Edit product
                    </c:if>
                    <c:if test="${product == null}">
                        Add New product
                    </c:if>
                </h2>
            </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.product_id}' />" />
                </c:if>           
            <tr>
                <th>Type: </th>
                <td>
                    <input type="text" name="Type" size="45"
                            value="<c:out value='${product.type}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Brand: </th>
                <td>
                    <input type="text" name="brand" size="45"
                            value="<c:out value='${product.brand}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Size: </th>
                <td>
                    <input type="text" name="size" size="5"
                            value="<c:out value='${product.size}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>