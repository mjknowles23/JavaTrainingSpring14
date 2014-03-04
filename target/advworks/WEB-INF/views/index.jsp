<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<h1>List of people in the AdventureWorks database.</h1>  
<p>You can also add, update, or delete a person.</p>  

<p><a href="${pageContext.request.contextPath}/add">Add Person</a></p> 
<table border="1" cellspacing="0" cellpadding="0">  
<thead>  
<tr>  
<th width="10%">Id</th><th width="15%">First</th><th width="15%">Last</th><th width="10%">Action</th>
</tr>  
</thead>  
<tbody>  
<c:forEach items="${people}" var="person">  
<tr>  
    <td>${person.id}</td>  
    <td>${person.firstName}</td>  
    <td>${person.lastName}</td>  
    <td>  
    <a href="${pageContext.request.contextPath}/edit/${person.id}.html">Edit</a><br />  
    <a href="${pageContext.request.contextPath}/delete/${person.id}.html">Delete</a><br />  
    </td>  
</tr> 
</c:forEach> 
  
</tbody>  
</table>  
  
<p><a href="${pageContext.request.contextPath}/">Home page</a></p> 

</body>
</html>
