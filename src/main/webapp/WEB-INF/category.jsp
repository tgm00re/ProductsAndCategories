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
<title>Categories</title>
  <!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet" 
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">

</head>
<body>
    <div class="container p-5"> <!-- Beginning of Container -->
        <div class="row mb-2">
            <a href="/">Create a Product</a>
        </div>
        <div class="row">
            <div class="col-sm-5">
                <h1>Create a New Category</h1>
                <form:form modelAttribute="category" action="/category/create" method="post">
                    <div class="form-group my-3">
                        <form:label path="name">Name</form:label>
                        <form:input path="name" type="text" class="form-control" id="name"/>
                        <form:errors path="name" class="text-danger"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
            </div>
            <div class="col-sm-2"></div>
            <div class="col-sm-5">
                <h1>All Categories</h1>
                <ul>
                    <c:forEach items="${categoryList}" var="category">
                        <li><a href="/view/category/${category.id}"><c:out value="${category.name}"/></a></li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div> <!-- End of Container -->
</body>
</html>