<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ page import="com.example.beans.Person" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hello <br>

<!-- With scriptlet :<br> -->
<%-- <% Person person=(Person)request.getAttribute("person"); %><br> --%>
<%--  ADI: <%= person.getUsername()%> <br> --%>
<%--  pHONE:<%=  person.getPhone()%><br> --%>
<%--  Address:<%= person.getAddress()%><br> --%>
<%--  Country:<%= person.getCountry()%><br> --%>
<%--  Password:<%= person.getPassword()%><br> <br> --%>


<!-- With EL variable:  <br> -->
<%-- Phone: ${person.phone} <br> --%>
<%-- Username:${person.username}<br> --%>
<%-- Address:${person.address}<br> --%>
<%-- Country:${person.country}<br> --%>
<%-- Password:${person.password}<br><br> --%>

<c:forEach items="${persons}" var="item" > <br>
<c:out value="${item.id }"></c:out> <br>
<c:out value="${item.username }"></c:out> <br>
<c:out value="${item.phone }"></c:out> <br>
<c:out value="${item.address }"></c:out> <br>
<c:out value="${item.country }"></c:out> <br>
<c:out value="${item.password }"></c:out> <br>
</c:forEach>



</body>
</html>