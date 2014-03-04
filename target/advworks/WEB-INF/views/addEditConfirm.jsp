<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<body>
<h1>Person Confirmation Page</h1>  
<p>The following data was entered into the database:</p>  

<h2>Person Information</h2>
<form:form modelAttribute="editedPerson" commandName="person" method="POST" action="${pageContext.request.contextPath}/edit/${person.id}">
        <form:label path="id">ID</form:label>
        <form:input path="id" readonly="true" />
    <br />
        <form:label path="firstName">First Name</form:label>
        <form:input path="firstName" readonly="true"  />
    <br />
        <form:label path="lastName">Last Name</form:label>
        <form:input path="lastName" readonly="true"  />
    <br />
</form:form>
<p><a href="${pageContext.request.contextPath}/">Home page</a></p> 

</body>
</html>
