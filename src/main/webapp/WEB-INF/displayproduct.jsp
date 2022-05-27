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
<title>View Product</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container p-5"> <!-- Beginning of Container -->
        <div class="row mb-2">
            <a href="/">Create a product</a>
        </div>
        <div class="row">
            <div class="col-sm-5">
                <h1><c:out value="${product.name}"/></h1>
                <h3>Categories</h3>
                <ul>
                    <c:forEach items="${product.categories}" var="category">
                        <li><c:out value="${category.name}"/></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-sm-2"></div>
            <div class="col-sm-5">
                <h3>Select a Category to Add</h3>
                <ul>
                    <c:forEach items="${addCategoryList}" var="category">
                        <a href="/product/addCategory/${product.id}/${category.id}"><c:out value="${category.name}"/></a>
                    </c:forEach>
                    
                </ul>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>