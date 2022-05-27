<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Category</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container p-5"> <!-- Beginning of Container -->
        <div class="row mb-2">
            <a href="/category">Create a category</a>
        </div>
        <div class="row">
            <div class="col-sm-5">
                <h1><c:out value="${category.name}"/></h1>
                <h3>Products</h3>
                <ul>
                    <c:forEach items="${category.products}" var="product">
                        <li><c:out value="${product.name}"/></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-sm-2"></div>
            <div class="col-sm-5">
                <h3>Add a product</h3>
                    <ul>
                        <c:forEach items="${addProductList}" var="product">
                            <a href="/category/addproduct/${product.id}/${category.id}"><c:out value="${product.name}"/></a>
                        </c:forEach>
                    </ul>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>